package com.adavri.csv.csv.service.impl;

import com.adavri.csv.csv.exception.CsvNotFoundException;
import com.adavri.csv.csv.model.Csv;
import com.adavri.csv.csv.repository.CsvRepository;
import com.adavri.csv.csv.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleCsvService implements CsvService {

    private final CsvRepository csvRepository;

    @Autowired
    public SimpleCsvService(CsvRepository csvRepository) {
        this.csvRepository = csvRepository;
    }

    @Override
    public void save(List<Csv> csvs) {
        csvRepository.saveAll(csvs);
    }

    @Override
    public Csv getByCode(String code) {
        return csvRepository.findById(code).orElseThrow(CsvNotFoundException::new);
    }

    @Override
    public List<Csv> findAll() {
        return csvRepository.findAll();
    }

    @Override
    public void clear() {
        csvRepository.deleteAll();
    }
}
