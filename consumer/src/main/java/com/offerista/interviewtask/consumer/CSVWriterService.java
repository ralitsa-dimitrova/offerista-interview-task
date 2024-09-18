package com.offerista.interviewtask.consumer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CSVWriterService {

    private static final String CSV_FILE_PATH = "primes.csv";

    public void writeListToCSV(List<Integer> integerList) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(integerList);
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
