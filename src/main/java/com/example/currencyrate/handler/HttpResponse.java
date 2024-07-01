package com.example.currencyrate.handler;

import lombok.Getter;

@Getter
public enum HttpResponse {
    CURRENCY_CODE_NOT_FOUND("Currency code not found");

    private String text;

    HttpResponse(String text) {
        this.text = text;
    }

}
