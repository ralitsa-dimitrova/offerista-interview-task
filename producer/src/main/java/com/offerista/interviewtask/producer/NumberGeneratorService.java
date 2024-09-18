package com.offerista.interviewtask.producer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NumberGeneratorService {

    private static final Random random = new Random();
    private static final int MAX_NUMBER_VALUE = 100;

    public List<Integer> generateNumbers(int maxNumbersPerBatch, int maxRemainingNumbers) {
        int numbersToSend = Math.min(random.nextInt(maxNumbersPerBatch) + 1, maxRemainingNumbers);
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersToSend; i++) {
            numbers.add(random.nextInt(MAX_NUMBER_VALUE));
        }

        return numbers;
    }
}
