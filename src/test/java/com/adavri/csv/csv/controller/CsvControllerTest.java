package com.adavri.csv.csv.controller;

import com.adavri.csv.csv.testing.SlowTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@SlowTest
public class CsvControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("when a csv file uploaded")
    void upload() throws Exception {
        final String csv = "\"source\",\"codeListCode\",\"code\",\"displayValue\",\"longDescription\",\"fromDate\",\"toDate\",\"sortingPriority\"\n" +
                "\"ZIB\",\"ZIB001\",\"271636001\",\"Polsslag regelmatig\",\"The long description is necessary\",\"01-01-2019\",\"\",\"1\"";

        final MockMultipartFile csvFile =
                new MockMultipartFile("file", "", "text/plain", csv.getBytes());

        mockMvc
                .perform(multipart("/api/v1/csv")
                        .file(csvFile)
                )
                .andExpect(status().isCreated());

    }

    @Test
    @DisplayName("when get all csvs")
    void get() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/csv"))
                .andExpect(status().isOk());
    }



}
