package com.recruitment.task.exchangerate.middle;

import java.time.LocalDate;
import java.util.List;

class MiddleExchangeRateRequest {
    private List<CurrencyAmount> currencies;
    private LocalDate date;

    public List<CurrencyAmount> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrencyAmount> currencies) {
        this.currencies = currencies;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
