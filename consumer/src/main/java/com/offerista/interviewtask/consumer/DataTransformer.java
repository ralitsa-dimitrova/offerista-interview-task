package com.offerista.interviewtask.consumer;

import java.util.List;

public interface DataTransformer<T> {

    public List<Integer> transform(List<T> data);
}
