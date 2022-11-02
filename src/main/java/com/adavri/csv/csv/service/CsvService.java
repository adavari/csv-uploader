package com.adavri.csv.csv.service;

import com.adavri.csv.csv.model.Csv;

import java.util.List;

public interface CsvService {

    void save(List<Csv> csvs);

    Csv getByCode(String code);

    List<Csv> findAll();

    void clear();

}
