package com.offerista.interviewtask.consumer;

import java.util.List;

public interface DataSaver<T> {
    public void save(List<T> data);
}
