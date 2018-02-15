package com.bhasad.api.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.bhasad.service.model.hello.wsdl.GetQuote;
import com.bhasad.service.model.hello.wsdl.GetQuoteResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuoteServiceImpl extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(QuoteServiceImpl.class);

	public GetQuoteResponse getQuote(String ticker) throws Exception {
		
		GetQuoteResponse response = null;
		try {
			GetQuote request = new GetQuote();
			request.setSymbol(ticker);

			log.info("Requesting quote for " + ticker);

			response = (GetQuoteResponse) getWebServiceTemplate().marshalSendAndReceive(
					"http://www.webservicex.com/stockquote.asmx", request,
					new SoapActionCallback("http://www.webserviceX.net/GetQuote"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Response " + response.getGetQuoteResult());
		return response;

	}

}
