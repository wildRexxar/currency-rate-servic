package com.example.currencyrate.mapper;

import com.example.currencyrate.dto.RateResponse;
import com.example.currencyrate.entity.db.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RateCreateMapper implements Mapper<RateResponse, Rate> {

    @Override
    public Rate map(RateResponse from) {
        return Rate.builder()
                .id(from.getId())
                .date(from.getDate())
                .abbreviation(from.getAbbreviation())
                .name(from.getName())
                .scale(from.getScale())
                .officialRate(from.getOfficialRate())
                .build();
    }
}
