package com.bhasad.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhasad.api.aggregator.FindDataAggregator;
import com.bhasad.api.service.model.Quote;
import com.bhasad.service.model.hello.wsdl.GetQuoteResponse;



@RestController
@RequestMapping(value = "/api/v1")
public class BhasadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BhasadController.class);
	
	@Autowired
	FindDataAggregator findDataAggregator;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Quote findData (
			@RequestHeader (value = "uuid", required = true) String uuid,
			@RequestHeader (value = "Accept", required = false) String accept,
			@RequestHeader (value = "Accept-Language", required = false) String acceptLanguage,
			@RequestHeader (value = "Content-Type", required = false) String contentType,
			@RequestParam  (value = "dataId", required = true) String dataId

	) throws Exception {
		
		LOGGER.info("Inside PoolController::findData");
		return findDataAggregator.getQuote(dataId, uuid);

	}
	
}
