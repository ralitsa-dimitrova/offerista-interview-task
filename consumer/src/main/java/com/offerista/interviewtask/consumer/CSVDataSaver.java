package com.offerista.interviewtask.consumer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.offerista.interviewtask.consumer.ConsumerConstants.CSV_FILE_PATH;

@Service
public class CSVDataSaver<T> implements DataSaver<T> {

    public void save(List<T> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(data);
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
