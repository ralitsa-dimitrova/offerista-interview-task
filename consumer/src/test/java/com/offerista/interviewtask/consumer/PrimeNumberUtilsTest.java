package com.offerista.interviewtask.consumer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberUtilsTest {

    @Test
    public void shouldIdentifyPrimeNumbers() {
        assertTrue(PrimeNumberUtils.isPrime(2));
        assertTrue(PrimeNumberUtils.isPrime(3));
        assertTrue(PrimeNumberUtils.isPrime(7));
    }

    @Test
    public void shouldIdentifyNonPrimeNumbers() {
        assertFalse(PrimeNumberUtils.isPrime(4));
        assertFalse(PrimeNumberUtils.isPrime(9));
        assertFalse(PrimeNumberUtils.isPrime(62));
    }

    @Test
    public void shouldHandleEdgeCases() {
        assertFalse(PrimeNumberUtils.isPrime(1));
        assertFalse(PrimeNumberUtils.isPrime(0));
        assertFalse(PrimeNumberUtils.isPrime(-13));
        assertFalse(PrimeNumberUtils.isPrime(-6));
    }

    @Test
    public void shouldIdentifyNegativePrimeLikeNumbersAsNonPrime() {
        assertFalse(PrimeNumberUtils.isPrime(-2));
        assertFalse(PrimeNumberUtils.isPrime(-3));
    }

    @Test
    public void shouldIdentifyLargePrimeNumbers() {
        assertTrue(PrimeNumberUtils.isPrime(7919));
        assertTrue(PrimeNumberUtils.isPrime(104729));
    }

    @Test
    public void shouldIdentifyLargeNonPrimeNumbers() {
        assertFalse(PrimeNumberUtils.isPrime(8000));
        assertFalse(PrimeNumberUtils.isPrime(104728));
    }

    @Test
    public void shouldHandleRepeatedInputs() {
        assertTrue(PrimeNumberUtils.isPrime(7));
        assertTrue(PrimeNumberUtils.isPrime(7));
        assertTrue(PrimeNumberUtils.isPrime(7));
    }

    @Test
    public void testFilterPrimesWithMixedNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> primes = PrimeNumberUtils.filterPrimes(numbers);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFilterPrimesWithAllNonPrimes() {
        List<Integer> numbers = Arrays.asList(4, 6, 8, 9, 10);

        List<Integer> primes = PrimeNumberUtils.filterPrimes(numbers);

        assertTrue(primes.isEmpty(), "Expected no prime numbers");
    }

    @Test
    public void testFilterPrimesWithAllPrimes() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
        List<Integer> primes = PrimeNumberUtils.filterPrimes(numbers);
        assertEquals(numbers, primes);
    }

    @Test
    public void testFilterPrimesWithEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        List<Integer> primes = PrimeNumberUtils.filterPrimes(numbers);
        assertTrue(primes.isEmpty(), "Expected empty list of prime numbers");
    }

    @Test
    public void testFilterPrimesWithNegativeNumbersAndZero() {
        List<Integer> numbers = Arrays.asList(-10, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> primes = PrimeNumberUtils.filterPrimes(numbers);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5);
        assertEquals(expectedPrimes, primes);
    }
}