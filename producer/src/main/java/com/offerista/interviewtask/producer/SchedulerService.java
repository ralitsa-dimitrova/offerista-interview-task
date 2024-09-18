package com.offerista.interviewtask.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SchedulerService {

    private static final int MAX_STREAM_SIZE = 100;
    private static final int MAX_NUMBERS_PER_BATCH = 5;
    private static final int BATCH_PERIOD_MS = 5;
    private final AtomicInteger totalNumbersSent = new AtomicInteger(0);

    private final NumberGeneratorService numberGeneratorService;
    private final SenderService senderService;
    private final CSVWriterService csvWriterService;

    @Autowired
    public SchedulerService(NumberGeneratorService numberGeneratorService, SenderService senderService, CSVWriterService csvWriterService) {
        this.numberGeneratorService = numberGeneratorService;
        this.senderService = senderService;
        this.csvWriterService = csvWriterService;
    }

    @Scheduled(fixedRate = BATCH_PERIOD_MS)
    public void generateAndSendNumbers() {
        if (totalNumbersSent.get() >= MAX_STREAM_SIZE) {
            return;
        }

        List<Integer> numbers = numberGeneratorService.generateNumbers(MAX_NUMBERS_PER_BATCH, MAX_STREAM_SIZE - totalNumbersSent.get());
        totalNumbersSent.addAndGet(numbers.size());

        if (!numbers.isEmpty()) {
            senderService.sendNumbers(numbers);
            csvWriterService.writeListToCSV(numbers);
        }
    }
}