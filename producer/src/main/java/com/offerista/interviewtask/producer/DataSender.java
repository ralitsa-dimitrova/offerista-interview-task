package com.offerista.interviewtask.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.offerista.interviewtask.producer.ProducerConstants.CONSUMER_SERVICE_ENDPOINT;

public abstract class DataSender<T> {
    protected final RestTemplate restTemplate;

    @Autowired
    public DataSender(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public abstract void sendData(List<T> data);

    protected void sendData(List<T> data, String dataType) {
        String endpoint = String.format(CONSUMER_SERVICE_ENDPOINT + "/%s", dataType);
        restTemplate.postForObject(endpoint, data, String.class);
    }
}
