package com.offerista.interviewtask.producer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CSVWriterService {

    private static final String CSV_FILE_PATH = "generatedNumbers.csv";

    public void writeListToCSV(List<Integer> integerList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(integerList);
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
