package com.offerista.interviewtask.producer;

import java.util.List;

public interface DataSaver<T> {
    public void save(List<T> data);
}
