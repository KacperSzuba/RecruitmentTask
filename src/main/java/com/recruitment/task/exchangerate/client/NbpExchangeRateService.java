package com.recruitment.task.exchangerate.client;

import com.recruitment.task.exchangerate.Currency;
import com.recruitment.task.exchangerate.middle.MiddleExchangeRate;
import com.recruitment.task.exchangerate.sell.SellExchangeRate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NbpExchangeRateService {
    private final NbpExchangeRateClient nbpExchangeRateClient;

    NbpExchangeRateService(NbpExchangeRateClient nbpExchangeRateClient) {
        this.nbpExchangeRateClient = nbpExchangeRateClient;
    }

    public SellExchangeRate getSellExchangeRate(Currency currency, LocalDate date) {
        return nbpExchangeRateClient.getSellExchangeRate(currency, date).toFirstSellExchangeRate();
    }

    public MiddleExchangeRate getMiddleExchangeRate(Currency currency, LocalDate date) {
        return nbpExchangeRateClient.getMiddleExchangeRate(currency, date).toFirstMiddleExchangeRate();
    }
}
