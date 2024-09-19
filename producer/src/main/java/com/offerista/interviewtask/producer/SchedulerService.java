package com.offerista.interviewtask.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.offerista.interviewtask.producer.ProducerConstants.*;

@Service
public class SchedulerService {
    private final NumberGeneratorService numberGeneratorService;
    private final SenderService senderService;
    private final CSVWriterService csvWriterService;

    private int totalNumbersSent = 0;

    @Autowired
    public SchedulerService(NumberGeneratorService numberGeneratorService, SenderService senderService, CSVWriterService csvWriterService) {
        this.numberGeneratorService = numberGeneratorService;
        this.senderService = senderService;
        this.csvWriterService = csvWriterService;
    }

    @Scheduled(fixedRate = BATCH_PERIOD_MS, initialDelay = INITIAL_DELAY)
    public void generateAndSendNumberBatch() {
        if (totalNumbersSent >= MAX_STREAM_SIZE) {
            return;
        }

        List<Integer> numberBatch = numberGeneratorService.generateNumbers(MAX_NUMBERS_PER_BATCH, MAX_STREAM_SIZE - totalNumbersSent);
        totalNumbersSent++;

        if (!numberBatch.isEmpty()) {
            senderService.sendNumbers(numberBatch);
            csvWriterService.writeListToCSV(numberBatch);
        }
    }
}