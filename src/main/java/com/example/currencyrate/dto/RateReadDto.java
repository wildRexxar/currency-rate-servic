package com.example.currencyrate.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RateReadDto {

    private String date;
    private String abbreviation;
    private String name;
    private Long scale;
    private String officialRate;
}
