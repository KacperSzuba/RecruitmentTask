package com.recruitment.task.exchangerate.sell;

import com.recruitment.task.exchangerate.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
interface SellExchangeRateRepository extends CrudRepository<DbNbpSellExchangeRate, Long> {
    Optional<DbNbpSellExchangeRate> findRateByCurrencyAndDate(Currency currency, LocalDate date);
}
