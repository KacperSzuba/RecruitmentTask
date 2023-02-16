package com.recruitment.task.exchangerate.client;

import com.recruitment.task.exchangerate.Currency;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
class NbpExchangeRateClient {
    private static final String NBP_SELL_EXCHANGE_RATE_URL = "http://api.nbp.pl/api/exchangerates/rates/c/{currency}/{date}";
    private static final String NBP_MIDDLE_EXCHANGE_RATE_URL = "http://api.nbp.pl/api/exchangerates/rates/a/{currency}/{date}";

    private final RestTemplate nbpRestTemplate;

    NbpExchangeRateClient(RestTemplate nbpRestTemplate) {
        this.nbpRestTemplate = nbpRestTemplate;
    }

    NbpSellExchangeRateResponse getSellExchangeRate(Currency currency, LocalDate date) {
        final String url = NBP_SELL_EXCHANGE_RATE_URL
                .replace("{currency}", currency.name())
                .replace("{date}", date.toString());
        return nbpRestTemplate.getForObject(url, NbpSellExchangeRateResponse.class);
    }

    public NbpMiddleExchangeRateResponse getMiddleExchangeRate(Currency currency, LocalDate date) {
        final String url = NBP_MIDDLE_EXCHANGE_RATE_URL
                .replace("{currency}", currency.name())
                .replace("{date}", date.toString());
        return nbpRestTemplate.getForObject(url, NbpMiddleExchangeRateResponse.class);
    }
}
