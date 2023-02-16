package com.recruitment.task.exchangerate.sell;

import com.recruitment.task.exchangerate.client.NbpSellExchangeRateResponse;

public class SellExchangeRate {
    private NbpSellExchangeRateResponse.Rate rate;

    public SellExchangeRate(NbpSellExchangeRateResponse.Rate rate) {;
        this.rate = rate;
    }

    NbpSellExchangeRateResponse.Rate getRate() {
        return rate;
    }
}
