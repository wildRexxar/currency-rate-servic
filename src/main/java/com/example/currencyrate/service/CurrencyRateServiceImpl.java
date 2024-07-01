package com.example.currencyrate.service;

import com.example.currencyrate.dto.RateReadDto;
import com.example.currencyrate.dto.RateResponse;
import com.example.currencyrate.entity.db.Rate;
import com.example.currencyrate.handler.exception.CurrencyCodeNotFoundException;
import com.example.currencyrate.mapper.RateCreateMapper;
import com.example.currencyrate.mapper.RateReadMapper;
import com.example.currencyrate.repository.CurrencyRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {


    private static final String URL_PREFIX = "https://api.nbrb.by/exrates/rates?";
    private static final String PERIODICITY = "periodicity=0";

    private final CurrencyRateRepository currencyRateRepository;
    private final RestTemplate restTemplate;
    private final RateReadMapper rateReadMapper;
    private final RateCreateMapper rateCreateMapper;


    @Override
    public List<RateReadDto> getCurrencyRatesByDate(String date) {
        return getListRatesByDate(date).stream().map(rateReadMapper::map).toList();

    }

    @Override
    @SneakyThrows
    public RateReadDto getCurrencyByDateAndCurrencyCode(String date, String currencyCode) {
        return getListRatesByDate(date).stream()
                .filter(curr -> curr.getAbbreviation().equalsIgnoreCase(currencyCode))
                .map(rateReadMapper::map)
                .findFirst()
                .orElseThrow(CurrencyCodeNotFoundException::new);
    }

    private List<Rate> getListRatesByDate(String date) {
        if(checkExistListRatesByDate(date)){
            return currencyRateRepository.findByDate(date);
        } else {
            return saveAndReturn(date);
        }
    }

    private List<Rate> saveAndReturn(String date) {
        return Stream.of(getCurrencyList(date))
                .map(rateCreateMapper::map)
                .map(currencyRateRepository::save)
                .toList();
    }

    @Override
    public Boolean checkExistListRatesByDate(String date) {
        return !currencyRateRepository.findByDate(date).isEmpty();
    }

    private RateResponse[] getCurrencyList(String date) {
        String onDate = "";
        if (date != null && !date.isEmpty() && !date.trim().isEmpty()) {
            onDate = "ondate=" + date + "&";
        }
        return restTemplate.getForObject(URL_PREFIX + onDate + PERIODICITY, RateResponse[].class);
    }
}