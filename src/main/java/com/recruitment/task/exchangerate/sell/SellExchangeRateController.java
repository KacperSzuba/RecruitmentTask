package com.recruitment.task.exchangerate.sell;

import com.recruitment.task.exchangerate.Currency;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
class SellExchangeRateController {

    private final SellExchangeRateService sellExchangeRateService;

    SellExchangeRateController(SellExchangeRateService sellExchangeRateService) {
        this.sellExchangeRateService = sellExchangeRateService;
    }

    @GetMapping("/exchange-rate/sell/{currency}/{date}")
    ResponseEntity<BigDecimal> getSellExchangeRate(@PathVariable Currency currency, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        try {
            BigDecimal sellExchangeRate = sellExchangeRateService.getSellExchangeRate(currency, date);
            return ResponseEntity.ok(sellExchangeRate);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
