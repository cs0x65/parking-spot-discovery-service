package com.ridecell.parkingassistant;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.logging.log4j.LogManager;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;


public class App 
{
	private static Server server;
	
    public static void main(String[] args){
    	LogManager.getLogger().info("Starting Parking Assist Microservice...");
        init();    
    }
    
    private static void init(){
    	LogManager.getLogger().info("Initializing components...");
    	initJetty();
    }
    

	private static void initJetty(){
    	LogManager.getLogger().info("Starting Jetty Server...");
    	try {
    		URI baseUri = UriBuilder.fromPath("http://127.0.0.1:8080").build();
    		LogManager.getLogger().info("Deploying Jetty at base URI = "+baseUri);
            server = JettyHttpContainerFactory.createServer(baseUri, new AppResourceConfig());
            server.start();
        } catch(Exception ex){
			LogManager.getLogger().fatal("Couldn't start Jetty!");
			LogManager.getLogger().fatal("Exception: "+ex);
			cleanup();
		} 
    }
    
    public static void cleanup() {
    	stopJetty();
    }
    

    public static void stopJetty(){
    	LogManager.getLogger().info("Stopping Jetty...");
    	if(server != null){
    		try {
    			server.stop();
    		} catch (Exception e) {
    			LogManager.getLogger().error("Couldn't stop Jetty!");
    			LogManager.getLogger().fatal("Exception: "+e);
    		}
		}
    }
}
