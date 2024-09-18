package com.offerista.interviewtask.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PrimeNumberController {

    private final CSVWriterService csvWriterService;

    @Autowired
    public PrimeNumberController(CSVWriterService csvWriterService) {
        this.csvWriterService = csvWriterService;
    }

    @PostMapping("/receiveNumbers")
    public ResponseEntity<String> processNumbers(@RequestBody List<Integer> numbers) {
        List<Integer> primes = PrimeNumberUtils.filterPrimes(numbers);

        try {
            csvWriterService.writeListToCSV(primes);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to write primes to CSV", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Primes processed and written to CSV", HttpStatus.OK);
    }
}
