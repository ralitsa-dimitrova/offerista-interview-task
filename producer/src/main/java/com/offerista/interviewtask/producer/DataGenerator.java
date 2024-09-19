package com.offerista.interviewtask.producer;

import java.util.List;

public interface DataGenerator<T> {
    /**
     * Generates a batch of items with a size of up to {@code maxItems}.
     */
    public List<T> generateItemsBatch(int maxItemsPerBatch);
}
