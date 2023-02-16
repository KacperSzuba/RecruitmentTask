package com.recruitment.task.exchangerate.client;

import com.recruitment.task.exchangerate.sell.SellExchangeRate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NbpSellExchangeRateResponse {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

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

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public static class Rate {
        private String no;
        private LocalDate effectiveDate;
        private BigDecimal bid;
        private BigDecimal ask;

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

        public BigDecimal getBid() {
            return bid;
        }

        public void setBid(BigDecimal bid) {
            this.bid = bid;
        }

        public BigDecimal getAsk() {
            return ask;
        }

        public void setAsk(BigDecimal ask) {
            this.ask = ask;
        }
    }

    public SellExchangeRate toFirstSellExchangeRate() {
        return new SellExchangeRate(rates.get(0));
    }
}
