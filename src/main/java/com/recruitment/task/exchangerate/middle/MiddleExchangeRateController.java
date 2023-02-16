package com.recruitment.task.exchangerate.middle;

import com.recruitment.task.exchangerate.Currency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

@RestController
class MiddleExchangeRateController {

    private final MiddleExchangeRateService middleExchangeRateService;

    MiddleExchangeRateController(MiddleExchangeRateService middleExchangeRateService) {
        this.middleExchangeRateService = middleExchangeRateService;
    }

    @PostMapping("/exchange-rate/middle/calculate")
    ResponseEntity<BigDecimal> calculateTotalCost(@RequestBody MiddleExchangeRateRequest request) {
        try {
            BigDecimal totalCost = middleExchangeRateService.calculateTotalCost(request.getDate(), request.getCurrencies());
            return ResponseEntity.ok(totalCost);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
