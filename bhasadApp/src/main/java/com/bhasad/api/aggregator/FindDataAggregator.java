package com.bhasad.api.aggregator;



import com.bhasad.api.service.model.Quote;
import com.bhasad.service.model.hello.wsdl.GetQuoteResponse;

public interface FindDataAggregator {
	
	public GetQuoteResponse findData(String dataId, String uuid) throws Exception;

	public Quote getQuote(String dataId, String uuid) throws Exception;
}
