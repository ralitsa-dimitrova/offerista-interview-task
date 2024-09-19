package com.offerista.interviewtask.producer;

public class ProducerConstants {

    public static final String CSV_FILE_PATH = "generatedData.csv";

    public static final String CONSUMER_SERVICE_ENDPOINT = "http://consumer-service:8081/api/processData";

    public static final int BATCH_PERIOD_MS = 5;
    public static final int INITIAL_DELAY = 10000;

    public static final int MAX_ITEMS_PER_BATCH = 5;
    public static final int MAX_NUMBER_VALUE = 100;
    public static final int MAX_STREAM_SIZE = 100;
}
