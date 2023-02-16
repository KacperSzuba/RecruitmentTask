package com.recruitment.task.exchangerate.middle;

import com.recruitment.task.exchangerate.client.NbpMiddleExchangeRateResponse;

public class MiddleExchangeRate {
    private NbpMiddleExchangeRateResponse.Rate rate;

    public MiddleExchangeRate(NbpMiddleExchangeRateResponse.Rate rate) {;
        this.rate = rate;
    }

    NbpMiddleExchangeRateResponse.Rate getRate() {
        return rate;
    }
}
