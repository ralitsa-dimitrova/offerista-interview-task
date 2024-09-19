package com.offerista.interviewtask.consumer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static com.offerista.interviewtask.consumer.ConsumerConstants.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DataProcessingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataSaver dataSaver;

    @Test
    public void testProcessDataEndpoint() throws Exception {
        mockMvc.perform(post(PROCESS_DATA_ENDPOINT)
                        .content("[1, 2, 3, 4, 5]")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(PROCESS_DATA_SUCCESS_MESSAGE));

        verify(dataSaver).save(Arrays.asList(2, 3, 5));
    }

    @Test
    public void testProcessDataWithEmptyList() throws Exception {
        mockMvc.perform(post(PROCESS_DATA_ENDPOINT)
                        .content("[]")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(PROCESS_DATA_SUCCESS_MESSAGE));

        verify(dataSaver, times(1)).save(Mockito.anyList());
    }
}