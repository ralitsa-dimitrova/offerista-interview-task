package com.offerista.interviewtask.consumer;

import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberUtils {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> filterPrimes(List<Integer> numbers) {
        return numbers.stream()
                .filter(PrimeNumberUtils::isPrime)
                .collect(Collectors.toList());
    }
}
