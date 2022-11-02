package com.adavri.csv.csv.controller;

import com.adavri.csv.csv.CsvParser;
import com.adavri.csv.csv.dto.CsvDto;
import com.adavri.csv.csv.dto.MessageResponse;
import com.adavri.csv.csv.exception.EmptyFileException;
import com.adavri.csv.csv.exception.InternalServerError;
import com.adavri.csv.csv.exception.InvalidCsvException;
import com.adavri.csv.csv.model.Csv;
import com.adavri.csv.csv.service.CsvService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/csv")
public class CsvController {

    private final CsvService csvService;
    private final Converter<Csv, CsvDto> csvConverter;

    public CsvController(CsvService csvService, Converter<Csv, CsvDto> csvConverter) {
        this.csvService = csvService;
        this.csvConverter = csvConverter;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse upload(@RequestParam("file") MultipartFile file) {
        if (file.getSize() == 0) {
            throw new EmptyFileException();
        }
        final byte[] fileBytes;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            throw new InternalServerError(e);
        }
        if (!CsvParser.isValid(fileBytes)) {
            throw new InvalidCsvException();
        }
        final List<Csv> parsedCsvs = CsvParser.parse(fileBytes);
        csvService.save(parsedCsvs);
        return new MessageResponse(false, "csv file uploaded successfully!");
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CsvDto> fetchAll() {
        final List<Csv> csvs = csvService.findAll();
        return csvs.stream().map(csvConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public CsvDto getByCode(@PathVariable("code") String code) {
        final Csv csv = csvService.getByCode(code);
        return csvConverter.convert(csv);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MessageResponse clearData() {
        csvService.clear();
        return new MessageResponse(false, "all data deleted successfully!");
    }
}
