package com.example.currencyrate.service;


import com.example.currencyrate.dto.RateReadDto;

import java.util.List;

public interface CurrencyRateService {

    List<RateReadDto> getCurrencyRatesByDate(String date);

    RateReadDto getCurrencyByDateAndCurrencyCode(String date, String currencyCode);

    Boolean checkExistListRatesByDate(String date);
}
