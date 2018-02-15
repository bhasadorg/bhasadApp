package com.bhasad.api.aggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.bhasad.api.service.QuoteServiceImpl;
import com.bhasad.api.service.RESTQuoteServiceImpl;
import com.bhasad.api.service.model.Quote;
import com.bhasad.service.model.hello.wsdl.GetQuoteResponse;


@Component
public class FindDataAggregatorImpl implements FindDataAggregator {

	@Autowired
	QuoteServiceImpl quoteService;
	
	@Autowired
	RESTQuoteServiceImpl getQuoteSvc;
	
	
	@Override
	public GetQuoteResponse findData(String dataId, String uuid) throws Exception {
		GetQuoteResponse quoteResponse = quoteService.getQuote(dataId);
		return quoteResponse;
	}


	@Override
	public Quote getQuote(String dataId, String uuid) throws Exception {
		return getQuoteSvc.getQuote(dataId);
	}
	

}
