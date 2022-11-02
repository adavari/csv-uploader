package com.adavri.csv.csv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CsvDto {

    @JsonProperty("code")
    private String code;

    @JsonProperty("source")
    private String source;

    @JsonProperty("code_list_code")
    private String codeListCode;

    @JsonProperty("display_value")
    private String displayValue;

    @JsonProperty("long_description")
    private String longDescription;

    @JsonProperty("from_date")
    private LocalDate fromDate;

    @JsonProperty("to_date")
    private LocalDate toDate;

    @JsonProperty("sorting_priority")
    private int sortingPriority;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getSortingPriority() {
        return sortingPriority;
    }

    public void setSortingPriority(int sortingPriority) {
        this.sortingPriority = sortingPriority;
    }
}
