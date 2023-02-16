package com.recruitment.task.exchangerate.sell;

import com.recruitment.task.exchangerate.Currency;
import com.recruitment.task.exchangerate.client.NbpExchangeRateService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
class SellExchangeRateService {
    private final SellExchangeRateRepository sellExchangeRateRepository;
    private final NbpExchangeRateService nbpExchangeRateService;

    SellExchangeRateService(SellExchangeRateRepository sellExchangeRateRepository, NbpExchangeRateService nbpExchangeRateService) {
        this.sellExchangeRateRepository = sellExchangeRateRepository;
        this.nbpExchangeRateService = nbpExchangeRateService;
    }

    @Transactional
    public BigDecimal getSellExchangeRate(Currency currency, LocalDate date) {
        return sellExchangeRateRepository.findRateByCurrencyAndDate(currency, date)
                .map(DbNbpSellExchangeRate::getBid)
                .orElseGet(() -> getSellExchangeFromApiAndSave(currency, date));
    }

    private BigDecimal getSellExchangeFromApiAndSave(Currency currency, LocalDate date){
        final SellExchangeRate sellExchangeRate = nbpExchangeRateService.getSellExchangeRate(currency, date);
        saveSellExchangeRate(currency, date, sellExchangeRate.getRate().getBid());
        return sellExchangeRate.getRate().getBid();
    }

    private void saveSellExchangeRate(Currency currency, LocalDate date, BigDecimal sellRate) {
        DbNbpSellExchangeRate dbNbpSellExchangeRate = new DbNbpSellExchangeRate();
        dbNbpSellExchangeRate.setCurrency(currency);
        dbNbpSellExchangeRate.setDate(date);
        dbNbpSellExchangeRate.setBid(sellRate);
        sellExchangeRateRepository.save(dbNbpSellExchangeRate);
    }
}
