package com.example.currencyrate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RateResponse {
    @JsonProperty("Cur_ID") private Long id;
    @JsonProperty("Date") private Date date;
    @JsonProperty("Cur_Abbreviation") private String abbreviation;
    @JsonProperty("Cur_Scale") private Long scale;
    @JsonProperty("Cur_Name") private String name;
    @JsonProperty("Cur_OfficialRate") private String officialRate;
}
