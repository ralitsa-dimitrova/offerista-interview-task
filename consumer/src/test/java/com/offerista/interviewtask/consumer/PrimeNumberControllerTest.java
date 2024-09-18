package com.offerista.interviewtask.consumer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrimeNumberControllerTest {
    private static final String CONSUMER_ENDPOINT = "/receiveNumbers";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CSVWriterService csvWriterService;

    @Test
    public void testProcessNumbersEndpoint() throws Exception {
        mockMvc.perform(post(CONSUMER_ENDPOINT)
                        .content("[1, 2, 3, 4, 5]")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("Primes processed and written to CSV"));

        verify(csvWriterService).writeListToCSV(Arrays.asList(2, 3, 5));
    }

    @Test
    public void testProcessNumbersWithEmptyList() throws Exception {
        mockMvc.perform(post(CONSUMER_ENDPOINT)
                        .content("[]")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("Primes processed and written to CSV"));

        verify(csvWriterService, times(1)).writeListToCSV(Mockito.anyList());
    }
}