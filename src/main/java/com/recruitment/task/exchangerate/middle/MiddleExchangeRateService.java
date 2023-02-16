package com.recruitment.task.exchangerate.middle;

import com.recruitment.task.exchangerate.Currency;
import com.recruitment.task.exchangerate.client.NbpExchangeRateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
class MiddleExchangeRateService {

    private final NbpExchangeRateService nbpExchangeRateService;

    MiddleExchangeRateService(NbpExchangeRateService nbpExchangeRateService) {
        this.nbpExchangeRateService = nbpExchangeRateService;
    }


    BigDecimal calculateTotalCost(LocalDate date, List<CurrencyAmount> currencies) {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (CurrencyAmount currency : currencies) {
            BigDecimal exchangeRate = getExchangeRate(currency.getCode(), date);
            totalCost = totalCost.add(exchangeRate.multiply(currency.getAmount()));
        }
        totalCost = totalCost.setScale(2, RoundingMode.HALF_UP);

        return totalCost;
    }

    private BigDecimal getExchangeRate(Currency currency, LocalDate date) {
        return nbpExchangeRateService.getMiddleExchangeRate(currency, date).getRate().getMid();
    }
}
