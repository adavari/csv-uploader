package com.adavri.csv.csv;

import com.adavri.csv.csv.model.Csv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvParserTest {

    @Test
    void shouldParseCsvCorrectly() {
        final String csv = "\"source\",\"codeListCode\",\"code\",\"displayValue\",\"longDescription\",\"fromDate\",\"toDate\",\"sortingPriority\"\n" +
                "\"ZIB\",\"ZIB001\",\"271636001\",\"Polsslag regelmatig\",\"The long description is necessary\",\"01-01-2019\",\"\",\"1\"";
        final List<Csv> csvs = CsvParser.parse(csv.getBytes(StandardCharsets.UTF_8));

        Assertions.assertEquals(1, csvs.size());
        Assertions.assertEquals("ZIB", csvs.get(0).getSource());
    }

}