package com.jankubik.algoTraderTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jankubik.algoTraderTest.client.SymbolDetailsInterface;
import com.jankubik.algoTraderTest.client.TradesInterface;
import com.jankubik.algoTraderTest.client.WSTradesClient;

@SpringBootApplication
public class AlgoTraderTestApplication implements CommandLineRunner{
	
	@Autowired
	SymbolDetailsInterface SymbolsInterface;
	
	@Autowired
	TradesInterface TradesInterface;

	private static Logger LOG = LoggerFactory.getLogger(AlgoTraderTestApplication.class);
	
	public static void main(String[] args) {
    	LOG.info("STARTING THE APPLICATION");
    	SpringApplication.run(AlgoTraderTestApplication.class, args);
    	LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {

        LOG.info("EXECUTING : command line runner");
        
        SymbolsInterface.getSymbolsDetails();
        
        TradesInterface.callTrades();
        
	}	
}
