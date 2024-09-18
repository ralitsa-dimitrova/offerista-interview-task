package com.offerista.interviewtask.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SenderService {
    private final RestTemplate restTemplate;
    private final String consumerUrl = "http://localhost:8081/receiveNumbers"; // Change to your target microservice URL

    @Autowired
    public SenderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendNumbers(List<Integer> numbers) {
        restTemplate.postForObject(consumerUrl, numbers, Void.class);
    }
}
