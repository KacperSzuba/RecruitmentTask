package com.recruitment.task.exchangerate.client;

import com.recruitment.task.exchangerate.middle.MiddleExchangeRate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NbpMiddleExchangeRateResponse {
    private String table;
    private String currency;
    private String code;
    private List<NbpMiddleExchangeRateResponse.Rate> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<NbpMiddleExchangeRateResponse.Rate> getRates() {
        return rates;
    }

    public void setRates(List<NbpMiddleExchangeRateResponse.Rate> rates) {
        this.rates = rates;
    }

    public static class Rate {
        private String no;
        private LocalDate effectiveDate;
        private BigDecimal mid;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public LocalDate getEffectiveDate() {
            return effectiveDate;
        }

        public void setEffectiveDate(LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public BigDecimal getMid() {
            return mid;
        }

        public void setMid(BigDecimal mid) {
            this.mid = mid;
        }
    }

    public MiddleExchangeRate toFirstMiddleExchangeRate() {
        return new MiddleExchangeRate(this.rates.get(0));
    }
}
