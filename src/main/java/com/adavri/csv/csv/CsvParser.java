package com.adavri.csv.csv;

import com.adavri.csv.csv.model.Csv;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CsvParser {

    private static final String[] HEADERS = new String[]{
            "source", "codeListCode", "code", "displayValue", "longDescription", "fromDate", "toDate", "sortingPriority"
    };

    public static boolean isValid(byte[] csvBytes) {
        final String csvFile = new String(csvBytes, StandardCharsets.UTF_8);
        final String[] lines = csvFile.split("\n");
        if (lines.length <= 1) {
            return false;
        }
        final String[] headers = lines[0].split(",");
        if (headers.length != HEADERS.length) {
            return false;
        }
        for (int i = 0; i < headers.length; i++) {
            if (!headers[i].replace("\"", "").equalsIgnoreCase(HEADERS[i])) {
                return false;
            }
        }
        return true;
    }

    public static List<Csv> parse(byte[] csvBytes) {
        final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

        final String csvFile = new String(csvBytes, StandardCharsets.UTF_8);
        final String[] lines = csvFile.split("\n");
        final List<Csv> csvs = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            final String[] data = lines[i].split(",");
            final Csv csv = new Csv();
            csv.setSource(data[0].replace("\"", ""));
            csv.setCodeListCode(data[1].replace("\"", ""));
            csv.setCode(data[2].replace("\"", ""));
            csv.setDisplayValue(data[3].replace("\"", ""));
            csv.setLongDescription(data[4].replace("\"", ""));
            String fromDate = data[5].replace("\"", "");
            if (!fromDate.isEmpty()) {
                csv.setFromDate(LocalDate.parse(fromDate, format));
            }
            if (!data[6].replace("\"", "").isBlank()) {
                csv.setToDate(LocalDate.parse(data[6].replace("\"", ""), format));
            }
            if (data.length == 8 && !data[7].replace("\"", "").isBlank()) {
                csv.setSortingPriority(Integer.parseInt(data[7].replace("\"", "")));
            }
            csvs.add(csv);
        }

        return csvs;
    }

}
