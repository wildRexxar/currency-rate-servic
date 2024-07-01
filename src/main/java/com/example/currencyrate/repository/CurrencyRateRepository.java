package com.example.currencyrate.repository;

import com.example.currencyrate.entity.db.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CurrencyRateRepository extends JpaRepository<Rate, Long> {

    @Query(
            value = "SELECT * FROM CURRENCY_RATE.RATE r WHERE r.DATE = ?1",
            nativeQuery = true)
    List<Rate> findByDate(String date);

}
