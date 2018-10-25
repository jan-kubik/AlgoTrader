package com.jankubik.algotrader.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.jankubik.algotrader.model.SymbolDetails;

@Component
public class CallSymbolsDetails implements SymbolDetailsInterface {
	
	private static Logger LOG = LoggerFactory.getLogger(CallSymbolsDetails.class);
	private static String URL = "https://api.bitfinex.com/v1/symbols_details";
	
	public void getSymbolsDetails() {
		
		ResponseEntity<List<SymbolDetails>> response = call();
		
		if(response!=null) {
			List<SymbolDetails> symbols = response.getBody();
			
			symbols.forEach(item->System.out.println(item.myToString()));
		}
		
	}
	
	private ResponseEntity<List<SymbolDetails>> call(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		 try {
			 LOG.info("Execute GET on: " + URL);
			 return restTemplate.exchange(URL, HttpMethod.GET, null,
					 new ParameterizedTypeReference<List<SymbolDetails>>(){});
		 } catch (HttpStatusCodeException e) {
			 LOG.error(e.getResponseBodyAsString(), e);
			 return null;
		 }
	}
}
