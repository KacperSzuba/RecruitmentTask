package com.recruitment.task.exchangerate.sell;

import com.recruitment.task.exchangerate.Currency;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="db_nbp_sell_exchange_rate")
class DbNbpSellExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Currency currency;

    private BigDecimal bid;

    BigDecimal getBid() {
        return bid;
    }

    void setDate(LocalDate date) {
        this.date = date;
    }

    void setCurrency(Currency currency) {
        this.currency = currency;
    }

    void setBid(BigDecimal sellRate) {
        this.bid = sellRate;
    }
}
