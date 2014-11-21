package com.test.RPC.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import com.test.RPC.client.GreetingService;
import com.test.RPC.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.unix4j.*;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	
	
	public String getPopulation(String country, String year) {
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/population 1990-2011.csv");	
		String result = Unix4j.cat(fullPath).grep(country).cat().grep(year).toStringResult();
		return result;
	}
	
	public String getProduction(String country, String goods, String year) {
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/production 1990-2011.csv");	
		String result = Unix4j.cat(fullPath).grep(country).cat().grep(goods).cat().grep(year).toStringResult();
		return result;
	}
	public String getTrade(String country, String goods, String year) {
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/trade 1990-2011.csv");	
		String result = Unix4j.cat(fullPath).grep(country).cat().cat().grep(goods).grep(year).toStringResult();
		return result;
	}
	
		
		
		public String getData() {
		/*
		File myFile = new File("rpcTest/war/grep_test.txt"); */	
		//String file = readFile("/rpcTest/war/WEB-INF/grep_test.txt");
		
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/population 1990-2011.csv");
		
		String country = "Armenia";
		String year = "2002";
		String goods = "Barley";
		String pattern = "grep";
		//String result = Unix4j.cat(file).grep(pattern).toStringResult();
		//population
		//String result = Unix4j.cat("/rpcTest/war/population 1990-2011.csv").grep(country).cat().grep(year).toStringResult();
		String result = Unix4j.cat(fullPath).grep(country).cat().grep(year).toStringResult();
		
		
		//trade
		//String result = Unix4j.cat("/home/nw21/workspace/rpcTest/war/trade 1990-2011.csv").grep(country).cat().grep(year).cat().grep(goods).toStringResult();
		
		return result;
		
	}
	
	

	public GreetingServiceImpl createFactory() {
		GreetingServiceImpl i = new GreetingServiceImpl();
		return i;
	}
	
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();	
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}
	
	
	//fetch data after table has been initialized, just dummy data...
	public ArrayList<String> getData(ArrayList<String> data) {
		return null;
	}
	
	
	
	
	
	//creates table (same as runImport with dummy data, just testing...
	public ArrayList<ArrayList<String>> createData() {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		for (int i=0;i<10;i++) {
			ArrayList<String> tmp = new ArrayList<String>();
			for (int j=0;j<10;j++) {
				
				tmp.add(j, "Test row: "+ Integer.toString(i) + " Test Column: "+Integer.toString(j));
			}
			table.add(i, tmp);
		
			
		}
		return table;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
