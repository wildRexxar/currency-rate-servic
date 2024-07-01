package com.example.currencyrate.handler.exception;

import com.example.currencyrate.handler.HttpResponse;

public class CurrencyCodeNotFoundException extends Exception{

    public CurrencyCodeNotFoundException() {
        super(HttpResponse.CURRENCY_CODE_NOT_FOUND.getText());
    }
}