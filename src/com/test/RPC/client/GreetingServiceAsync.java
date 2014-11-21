package com.test.RPC.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.test.RPC.server.GreetingServiceImpl;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void getData(AsyncCallback<String> callback);

	void getPopulation(String country, String year,
			AsyncCallback<String> callback);

	void getProduction(String country, String goods, String year,
			AsyncCallback<String> callback);

	void getTrade(String country, String goods, String year,
			AsyncCallback<String> callback);


}
