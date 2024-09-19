package com.offerista.interviewtask.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.offerista.interviewtask.producer.ProducerConstants.*;

@Service
public class DataGenerationScheduler {
    private final DataGenerator generator;
    private final DataSender sender;
    private final DataSaver saver;

    private int totalItemsSent = 0;

    @Autowired
    public DataGenerationScheduler(DataGenerator generator, DataSender sender, DataSaver saver) {
        this.generator = generator;
        this.sender = sender;
        this.saver = saver;
    }

    // Note: As the producer depends on the readiness of the consumer
    // The initial delay of 10s is a workaround
    // This would be better achieved with a
    // "depends on" relationship in the docker-compose file
    // combined with a spring actuator liveliness check
    @Scheduled(fixedRate = BATCH_PERIOD_MS, initialDelay = INITIAL_DELAY)
    public void generateAndSendItemBatch() {
        if (totalItemsSent >= MAX_STREAM_SIZE) {
            return;
        }

        List<Integer> itemsBatch = generator.generateItemsBatch(
                Math.min(MAX_ITEMS_PER_BATCH, MAX_STREAM_SIZE - totalItemsSent));
        totalItemsSent += itemsBatch.size();

        if (!itemsBatch.isEmpty()) {
            sender.sendData(itemsBatch);
            saver.save(itemsBatch);
        }
    }
}