package com.example.currencyrate.mapper;

public interface Mapper <F, T>{
    T map(F from);
}
