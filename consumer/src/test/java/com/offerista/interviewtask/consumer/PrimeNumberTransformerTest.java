package com.offerista.interviewtask.consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTransformerTest {

    private PrimeNumberTransformer primeNumberTransformer;

    @BeforeEach
    public void setUp() {
        primeNumberTransformer = new PrimeNumberTransformer();
    }

    @Test
    public void shouldIdentifyPrimeNumbers() {
        assertTrue(primeNumberTransformer.isPrime(2));
        assertTrue(primeNumberTransformer.isPrime(3));
        assertTrue(primeNumberTransformer.isPrime(7));
    }

    @Test
    public void shouldIdentifyNonPrimeNumbers() {
        assertFalse(primeNumberTransformer.isPrime(4));
        assertFalse(primeNumberTransformer.isPrime(9));
        assertFalse(primeNumberTransformer.isPrime(62));
    }

    @Test
    public void shouldHandleEdgeCases() {
        assertFalse(primeNumberTransformer.isPrime(1));
        assertFalse(primeNumberTransformer.isPrime(0));
        assertFalse(primeNumberTransformer.isPrime(-13));
        assertFalse(primeNumberTransformer.isPrime(-6));
    }

    @Test
    public void shouldIdentifyNegativePrimeLikeNumbersAsNonPrime() {
        assertFalse(primeNumberTransformer.isPrime(-2));
        assertFalse(primeNumberTransformer.isPrime(-3));
    }

    @Test
    public void shouldIdentifyLargePrimeNumbers() {
        assertTrue(primeNumberTransformer.isPrime(7919));
        assertTrue(primeNumberTransformer.isPrime(104729));
    }

    @Test
    public void shouldIdentifyLargeNonPrimeNumbers() {
        assertFalse(primeNumberTransformer.isPrime(8000));
        assertFalse(primeNumberTransformer.isPrime(104728));
    }

    @Test
    public void shouldHandleRepeatedInputs() {
        assertTrue(primeNumberTransformer.isPrime(7));
        assertTrue(primeNumberTransformer.isPrime(7));
        assertTrue(primeNumberTransformer.isPrime(7));
    }

    @Test
    public void testFilterPrimesWithMixedNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> primes = primeNumberTransformer.transform(numbers);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFilterPrimesWithAllNonPrimes() {
        List<Integer> numbers = Arrays.asList(4, 6, 8, 9, 10);

        List<Integer> primes = primeNumberTransformer.transform(numbers);

        assertTrue(primes.isEmpty(), "Expected no prime numbers");
    }

    @Test
    public void testFilterPrimesWithAllPrimes() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
        List<Integer> primes = primeNumberTransformer.transform(numbers);
        assertEquals(numbers, primes);
    }

    @Test
    public void testFilterPrimesWithEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        List<Integer> primes = primeNumberTransformer.transform(numbers);
        assertTrue(primes.isEmpty(), "Expected empty list of prime numbers");
    }

    @Test
    public void testFilterPrimesWithNegativeNumbersAndZero() {
        List<Integer> numbers = Arrays.asList(-10, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> primes = primeNumberTransformer.transform(numbers);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5);
        assertEquals(expectedPrimes, primes);
    }
}