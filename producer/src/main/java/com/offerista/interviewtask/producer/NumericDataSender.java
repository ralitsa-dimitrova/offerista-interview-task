package com.offerista.interviewtask.producer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NumericDataSender<T> extends DataSender<T> {

    public NumericDataSender(RestTemplate restTemplate) {
        super(restTemplate);
    }

    public void sendData(List<T> data) {
        sendData(data, "integer");
    }
}
