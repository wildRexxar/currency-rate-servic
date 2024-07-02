package com.example.currencyrate.service;


import com.example.currencyrate.dto.RateReadDto;

import com.example.currencyrate.dto.RateResponse;
import com.example.currencyrate.entity.db.Rate;
import java.util.List;

public interface CurrencyRateService {

    List<RateReadDto> getCurrencyRatesByDate(String date);

    RateReadDto getCurrencyByDateAndCurrencyCode(String date, String currencyCode);

    Boolean checkExistListRatesByDate(String date);

    List<Rate> saveInDb(RateResponse[] rateResponses);

    List<Rate> getListRatesByDate(String date);
}
