package com.example.currencyrate.mapper;

import com.example.currencyrate.dto.RateReadDto;
import com.example.currencyrate.entity.db.Rate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RateReadMapper implements Mapper<Rate, RateReadDto> {


    @Override
    public RateReadDto map(Rate from) {
        return RateReadDto.builder()
                .date(convertDateFormat(from.getDate()))
                .abbreviation(from.getAbbreviation())
                .name(from.getName())
                .scale(from.getScale())
                .officialRate(from.getOfficialRate())
                .build();
    }

    private String convertDateFormat(Date from){
        return new SimpleDateFormat("yyyy-MM-dd").format(from);
    }
}