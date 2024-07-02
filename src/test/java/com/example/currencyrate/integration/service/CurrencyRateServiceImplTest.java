package com.example.currencyrate.integration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.currencyrate.dto.RateReadDto;
import com.example.currencyrate.dto.RateResponse;
import com.example.currencyrate.integration.TestFather;
import com.example.currencyrate.repository.CurrencyRateRepository;
import com.example.currencyrate.service.CurrencyRateServiceImpl;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


@AutoConfigureMockMvc
@RequiredArgsConstructor
public class CurrencyRateServiceImplTest extends TestFather {


    private final CurrencyRateServiceImpl currencyRateService;
    private final CurrencyRateRepository currencyRateRepository;


    @Test
    void getCurrencyRatesByDate(){
        assertEquals(3, currencyRateService.getListRatesByDate("2024-01-01").size());
    }

    @Test
    void getCurrencyByDateAndCurrencyCode() {
        RateReadDto rateReadDto = currencyRateService.getCurrencyByDateAndCurrencyCode("2024-01-01", "USD");
        assertNotNull(rateReadDto);
        assertEquals("3.1624", rateReadDto.getOfficialRate());
    }


    @Test
    void getListRatesByDate() {
        assertEquals(3, currencyRateService.getListRatesByDate("2024-01-01").size());
    }

    @Test
    void checkExistListRatesByDate() {
        assertTrue(currencyRateService.checkExistListRatesByDate("2024-01-01"));
        assertFalse(currencyRateService.checkExistListRatesByDate("2024-06-01"));
    }

    @Test
    void saveInDb() {
        int sizeAfterSave = currencyRateRepository.findAll().size();
        currencyRateService.saveInDb(new RateResponse[]{
            RateResponse.builder()
                .id(9999L)
                .date(new Date())
                .name("FakeMoney")
                .abbreviation("FM")
                .officialRate("999999")
                .scale(1L)
                .build()});
        int sizeBeforeSave = currencyRateRepository.findAll().size();
        assertEquals(sizeAfterSave + 1, sizeBeforeSave);
    }
}
