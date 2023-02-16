package com.recruitment.task.exchangerate.middle;

import com.recruitment.task.exchangerate.Currency;

import java.math.BigDecimal;

class CurrencyAmount {
    private Currency code;
    private BigDecimal amount;

    public Currency getCode() {
        return code;
    }

    public void setCode(Currency code) {
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
