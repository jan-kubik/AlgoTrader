package com.jankubik.algotrader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jankubik.algotrader.client.SymbolDetailsInterface;
import com.jankubik.algotrader.client.TradesInterface;
import com.jankubik.algotrader.client.WSTradesClient;

@SpringBootApplication
public class AlgoTraderTestApplication implements CommandLineRunner{
	
	@Autowired
	SymbolDetailsInterface symbolsInterface;
	
	@Autowired
	TradesInterface tradesInterface;

	private static Logger LOG = LoggerFactory.getLogger(AlgoTraderTestApplication.class);
	
	public static void main(String[] args) {
    	LOG.info("STARTING THE APPLICATION");
    	SpringApplication.run(AlgoTraderTestApplication.class, args);
    	LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {

        LOG.info("EXECUTING : command line runner");
        
        symbolsInterface.getSymbolsDetails();
        
        tradesInterface.callTrades();
        
	}	
}
