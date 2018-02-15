package com.bhasad.api.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bhasad.api.service.model.Quote;

@Service
public class RESTQuoteServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(RESTQuoteServiceImpl.class);

    public Quote getQuote(String symbol) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
        return quote;
    }

}
