package com.offerista.interviewtask.consumer;

public class ConsumerConstants {

    public static final String BASE_API_PATH = "/api";
    public static final String PROCESS_DATA_PATH = "/processData";
    public static final String PROCESS_DATA_ENDPOINT = BASE_API_PATH + PROCESS_DATA_PATH + "/integer";

    public static final String CSV_FILE_PATH = "processedData.csv";

    public static final String PROCESS_DATA_ERROR_MESSAGE_GENERIC = "Failed to write data to CSV";
    public static final String PROCESS_DATA_ERROR_MESSAGE_UNSUPPORTED_DATA_TYPE =
            PROCESS_DATA_ERROR_MESSAGE_GENERIC + " due to unsupported data type";
    public static final String PROCESS_DATA_SUCCESS_MESSAGE = "Data processed and written to CSV";
}
