package com.adavri.csv.csv.converter;

import com.adavri.csv.csv.dto.CsvDto;
import com.adavri.csv.csv.model.Csv;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CsvToCsvDtoConverter implements Converter<Csv, CsvDto> {
    @Override
    public CsvDto convert(Csv source) {
        final CsvDto csvDto = new CsvDto();
        csvDto.setCode(source.getCode());
        csvDto.setSource(source.getSource());
        csvDto.setCodeListCode(source.getCodeListCode());
        csvDto.setDisplayValue(source.getDisplayValue());
        csvDto.setLongDescription(source.getLongDescription());
        csvDto.setFromDate(source.getFromDate());
        csvDto.setToDate(source.getToDate());
        csvDto.setSortingPriority(source.getSortingPriority());
        return csvDto;
    }
}
