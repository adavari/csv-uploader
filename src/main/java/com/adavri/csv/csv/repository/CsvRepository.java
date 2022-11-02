package com.adavri.csv.csv.repository;

import com.adavri.csv.csv.model.Csv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvRepository extends JpaRepository<Csv, String> {
}
