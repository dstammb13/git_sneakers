package com.test.RPC.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.test.RPC.server.GreetingServiceImpl;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	String getData();
	String getPopulation(String country, String year);
	String getProduction(String country, String goods, String year);
	String getTrade(String country, String goods, String year);
}
