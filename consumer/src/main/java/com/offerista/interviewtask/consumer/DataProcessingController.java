package com.offerista.interviewtask.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.offerista.interviewtask.consumer.ConsumerConstants.*;

@RestController
@RequestMapping(BASE_API_PATH)
public class DataProcessingController<T> {

    private final DataSaver dataSaver;
    private final DataTransformer transformer;

    @Autowired
    public DataProcessingController(DataSaver dataSaver, DataTransformer transformer) {
        this.dataSaver = dataSaver;
        this.transformer = transformer;
    }

    @PostMapping(PROCESS_DATA_PATH + "/{dataType}")
    public ResponseEntity<String> processData(@PathVariable String dataType, @RequestBody List<Integer> data) {
        List<Integer> transformedData;

        if (dataType.equalsIgnoreCase("integer")) {
            transformedData = transformer.transform(data);
        } else {
            return new ResponseEntity<>(PROCESS_DATA_ERROR_MESSAGE_UNSUPPORTED_DATA_TYPE, HttpStatus.BAD_REQUEST);
        }

        try {
            dataSaver.save(transformedData);
        } catch (Exception e) {
            return new ResponseEntity<>(PROCESS_DATA_ERROR_MESSAGE_GENERIC, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(PROCESS_DATA_SUCCESS_MESSAGE, HttpStatus.OK);
    }
}
