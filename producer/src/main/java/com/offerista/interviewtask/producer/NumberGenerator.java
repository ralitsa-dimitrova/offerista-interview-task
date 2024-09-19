package com.offerista.interviewtask.producer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NumberGenerator implements DataGenerator<Integer> {

    private static final Random random = new Random();

    public List<Integer> generateItemsBatch(int maxItemsPerBatch, int maxRemainingNumbers) {
        int numbersToSend = Math.min(random.nextInt(maxItemsPerBatch) + 1, maxRemainingNumbers);
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersToSend; i++) {
            numbers.add(random.nextInt(ProducerConstants.MAX_NUMBER_VALUE));
        }

        return numbers;
    }

    @Override
    public List<Integer> generateItemsBatch(int maxItems) {
        int numbersToSend = random.nextInt(maxItems) + 1;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersToSend; i++) {
            numbers.add(random.nextInt(ProducerConstants.MAX_NUMBER_VALUE));
        }

        return numbers;
    }
}
