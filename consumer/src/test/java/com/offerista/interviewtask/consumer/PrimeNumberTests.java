package com.offerista.interviewtask.consumer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeNumberTests {

    private final ConsumerApplication consumerApplication = new ConsumerApplication();

    @Test
    public void shouldIdentifyPrimeNumbers() {
        assertTrue(consumerApplication.isPrime(2));
        assertTrue(consumerApplication.isPrime(3));
        assertTrue(consumerApplication.isPrime(7));
    }

    @Test
    public void shouldIdentifyNonPrimeNumbers() {
        assertFalse(consumerApplication.isPrime(4));
        assertFalse(consumerApplication.isPrime(9));
        assertFalse(consumerApplication.isPrime(62));
    }

    @Test
    public void shouldHandleEdgeCases() {
        assertFalse(consumerApplication.isPrime(1));
        assertFalse(consumerApplication.isPrime(0));
        assertFalse(consumerApplication.isPrime(-13));
        assertFalse(consumerApplication.isPrime(-6));
    }

    @Test
    public void shouldIdentifyNegativePrimeLikeNumbersAsNonPrime() {
        assertFalse(consumerApplication.isPrime(-2));
        assertFalse(consumerApplication.isPrime(-3));
    }

    @Test
    public void shouldIdentifyLargePrimeNumbers() {
        assertTrue(consumerApplication.isPrime(7919));
        assertTrue(consumerApplication.isPrime(104729));
    }

    @Test
    public void shouldIdentifyLargeNonPrimeNumbers() {
        assertFalse(consumerApplication.isPrime(8000));
        assertFalse(consumerApplication.isPrime(104728));
    }

    @Test
    public void shouldHandleRepeatedInputs() {
        assertTrue(consumerApplication.isPrime(7));
        assertTrue(consumerApplication.isPrime(7));
        assertTrue(consumerApplication.isPrime(7));
    }
}
