package com.offerista.interviewtask.consumer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrimeNumberTransformer implements DataTransformer<Integer> {

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public List<Integer> transform(List<Integer> data) {
        return data.stream()
                .filter(this::isPrime)
                .collect(Collectors.toList());
    }
}
