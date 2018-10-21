package com.jankubik.algoTraderTest.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.websocket.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jankubik.algoTraderTest.AlgoTraderTestApplication;

@Component
@ClientEndpoint
public class WSTradesClient implements TradesInterface {
	
	private static Logger LOG = LoggerFactory.getLogger(AlgoTraderTestApplication.class);
	
	private static String REQUEST = "{" + 
    		"\"event\":\"subscribe\"," + 
    		"\"channel\":\"trades\"," + 
    		"\"pair\":\"BTCUSD\"" + 
    		"}";
	private static String URL = "wss://api.bitfinex.com/ws";
	
    private static Object waitLock = new Object();
    
    public void callTrades() {
    	
    	WebSocketContainer container=null;
        Session session=null;
        try{
        	container = ContainerProvider.getWebSocketContainer();
        	LOG.info("Connecting to: " + URL);
        	session=container.connectToServer(WSTradesClient.class, URI.create(URL));
        	session.getAsyncRemote().sendText(REQUEST);
        	LOG.info("Sending message: " + REQUEST);
        	wait4TerminateSignal();
        	} catch (Exception e) {
        		LOG.error(e.getMessage(),e);
        		e.printStackTrace();
        	}
        finally{
        	if(session!=null){
        		try {
        			session.close();
        			} catch (Exception e) {
        				LOG.error(e.getMessage(),e);
        				e.printStackTrace();
        			}
        	}         
        }
    }
    
    @OnMessage
    public void onMessage(String message) {
    	
    	//LOG.info("Recieved message: " + message);
    	if(message.contains("\"te\"")) {
    		List<String> elephantList = Arrays.asList(message.split(","));
    	    java.util.Date time=new java.util.Date(Long.parseLong(elephantList.get(3))*1000);
    	    System.out.println("{"+time+","+elephantList.get(4)+","+elephantList.get(5).replace(']', '}'));
    	}  
       
    }
    
    private static void  wait4TerminateSignal(){
    	synchronized(waitLock){
    		try {
    			waitLock.wait();
    		} catch (InterruptedException e) {   
    			LOG.error(e.getMessage(),e);
    		}
    	}
    }
}
