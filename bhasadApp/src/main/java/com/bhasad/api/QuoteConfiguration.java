package com.bhasad.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.bhasad.api.service.QuoteServiceImpl;

@Configuration
public class QuoteConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.bhasad.service.model.hello.wsdl");
		return marshaller;
	}

	@Bean
	public QuoteServiceImpl quoteClient(Jaxb2Marshaller marshaller) {
		QuoteServiceImpl client = new QuoteServiceImpl();
		client.setDefaultUri("http://www.webservicex.com/stockquote.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	

}
