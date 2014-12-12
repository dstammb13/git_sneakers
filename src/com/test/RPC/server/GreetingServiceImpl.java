package com.test.RPC.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import com.test.RPC.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.unix4j.*;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	
	
	public String getPopulation(String country, String fromYearArg, String until) {
        ServletContext context = getServletContext();
        String fullPath = context.getRealPath("/population 1990-2011.csv");   
        String result="";
        Integer fromYear = new Integer(fromYearArg);
        Integer untilYear = new Integer(until);;
        for (int i = fromYear; i<=untilYear; i++) {
        	StringBuilder currentYear = new StringBuilder();
        	currentYear.append(i);
        	
        	result += Unix4j.cat(fullPath).grep(country).cat().grep(currentYear.toString()).toStringResult() + "#";
        }
        result.replace("\\n","#");
        return result;
        
        
        
        /*
        if(year==null || year=="") {
            //get population for all years
            result += Unix4j.cat(fullPath).grep(country).toStringResult();
        } else {
            //get population only for one year
            result += Unix4j.cat(fullPath).grep(country).cat().grep(year).toStringResult();
        }
        
        return result;*/
	}
	
	public String getProduction(String country, String goods, String from, String until) {
	    ServletContext context = getServletContext();
        String fullPath = context.getRealPath("/production 1990-2011.csv");   
        String result="";
        
        Integer fromYear = new Integer(from);
        Integer untilYear = new Integer(until);
        for (int i = fromYear; i<=untilYear; i++) {
        	StringBuilder currentYear = new StringBuilder();
        	currentYear.append(i);
        	if(goods==null || goods=="") {
                //get production for all years of all goods of this country
                //set: country
                result +=Unix4j.cat(fullPath).grep(currentYear.toString()).cat().grep(country).toStringResult() + "#";
        	}
        	else {
        		result += Unix4j.cat(fullPath).grep(country).cat().grep(currentYear.toString()).cat().grep(goods).toStringResult() + "#";
        		
        	}
            //get production for all years
            
             /*else {
                //get production for all years of one good of this country
                //set: country, good
                result += Unix4j.cat(fullPath).grep(country).cat().grep(goods).toStringResult();
            } else {
            //get production only for one year
            if(goods==null || goods=="") {
                //get production of one year of all goods of this country
                //set: country, year
                result += Unix4j.cat(fullPath).grep(country).cat().grep(year).toStringResult();
            } else {
                //get production of one year of one good of this country
                //set: country, good, year
                result += Unix4j.cat(fullPath).grep(country).cat().grep(goods).cat().grep(year).toStringResult();
            } }*/
        }
        result.replace("\\n","#");
        return result;
	}
	
	
	public String getTrade(String country, String goods, String from, String until) {
		ServletContext context = getServletContext();
        String result = "";
       
        for(int j =1;j<6;++j) {
        	StringBuilder currentFile = new StringBuilder();
        	currentFile.append("/trade.part");
        	currentFile.append(j);
        	currentFile.append(".csv");
            String fullPath = context.getRealPath(currentFile.toString());
            //result=result;
       
            Integer fromYear = new Integer(from);
            Integer untilYear = new Integer(until);
            for (int i = fromYear; i<=untilYear; i++) {
            	StringBuilder currentYear = new StringBuilder();
            	currentYear.append(i);
            	if(goods==null || goods=="") {
                    //get production for all years of all goods of this country
                    //set: country
                    result += Unix4j.cat(fullPath).grep(currentYear.toString()).cat().grep(country).toStringResult() + "#";
            	}
            	else {
            		result += Unix4j.cat(fullPath).grep(country).cat().grep(currentYear.toString()).cat().grep(goods).toStringResult() + "#";
            	}
            }//end for year
        }//end for files
            
            
            
            /*if(year==null || year=="") {
                //get trade for all years
                if(goods==null || goods=="") {
                    //get trade for all years of all goods of this country
                    //set: country
                    result += Unix4j.cat(fullPath).grep(country).toStringResult();
                } else {
                    //get trade for all years of one good of this country
                    //set: country, good
                    result += Unix4j.cat(fullPath).grep(country).cat().grep(goods).toStringResult();
                }
            } else {
                //get trade only for one year
                if(goods==null || goods=="") {
                    //get tradde of one year of all goods of this country
                    //set: country, year
                    result += Unix4j.cat(fullPath).grep(country).cat().grep(year).toStringResult();
                } else {
                    //get trade of one year of one good of this country
                    //set: country, good, year
                    result += Unix4j.cat(fullPath).grep(country).cat().grep(goods).cat().grep(year).toStringResult();
                }
            }*/
        
        result.replace("\\n","#");
        
        return result;
	}
	
		
		
		public String getData(String pattern) {
		/* ..
		File myFile = new File("rpcTest/war/grep_test.txt"); */	
		//String file = readFile("/rpcTest/war/WEB-INF/grep_test.txt");
		
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/grep_test.txt");
		String result = Unix4j.cat(fullPath).grep(pattern).toStringResult();
		/*
		String country = "Armenia";
		String year = "2002";
		String goods = "Barley";
		String pattern = "grep";
		//String result = Unix4j.cat(file).grep(pattern).toStringResult();
		//population
		//String result = Unix4j.cat("/rpcTest/war/population 1990-2011.csv").grep(country).cat().grep(year).toStringResult();
		String result = Unix4j.cat(fullPath).grep(country).cat().grep(year).toStringResult();
		*/
		
		//trade
		//String result = Unix4j.cat("/home/nw21/workspace/rpcTest/war/trade 1990-2011.csv").grep(country).cat().grep(year).cat().grep(goods).toStringResult();
		
		return result;
		
	}
	
	

	public GreetingServiceImpl createFactory() {
		GreetingServiceImpl i = new GreetingServiceImpl();
		return i;
	}
	
	public String greetServer(String input) throws IllegalArgumentException {
		/*// Verify that the input is valid. 
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
*/
		return "";
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
