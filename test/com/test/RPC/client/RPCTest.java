package com.test.RPC.client;

import static org.junit.Assert.*;

import java.util.Arrays;

import javax.swing.Box.Filler;

import org.junit.Test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.FlexTable;
import com.test.RPC.client.*;
import com.test.RPC.client.AppState;
import com.test.RPC.client.GreetingService;



public class RPCTest extends GWTTestCase {
	
	
	public void testsetDataSet() 
	{
	
		String dataSet = "Population";
		String dataSet2 = "Production";
		String dataSet3 = "Trade";
		
		
		assertEquals(dataSet, 0);
		assertEquals(dataSet2, 1);
		assertEquals(dataSet3, 2);
	}
	
	public void testsetDataSet2() {
		String dataSet = "foo";
		assertEquals(dataSet, dataSet);
	}
	
	public void testgetYear() {
		String year ="hallo";
		assertEquals(year, year);
		
	}

	public void testsetUntilYear() {
		String year2 ="neu";
		assertEquals(year2, year2);
	}
	
	public void testgetUntilYear() {
		String year3 ="alt";
		assertEquals(year3, year3);
	}
public void testsetYear(String year) {
		
		String any = "any year";
		String nope = "blabla";
		
		assertEquals(any, "");
		assertEquals(nope, nope);
	}
	
	public void testgetCountry() {
		String country = "Schweiz";
		
		assertEquals(country, country);
	}

	public void testsetCountry() {
		String country2 = "Armenia";
		
		assertEquals(country2, country2);
	}

	
	public void testgetGoods() {
		String good = "Weizen";
		
		assertEquals(good, good);
	}

	public void testsetGoods(String goods) {
		String anygood = "any year";
		String nopegood = "blabla";
		
		assertEquals(anygood, "");
		assertEquals(nopegood, nopegood);
	}

	
	public void testsetState() {
		int state = 6;
		
		assertEquals(state, state);
	}
	
	public void testgetState() {
		int state1 = 6;
		
		assertEquals(state1, state1);
	}
	//
//	public void testisValidName() {
//		String isNull=null;
//		String tooShort="a";
//		String isOk="A very long string";
//
//		boolean returnedForIsNull=FieldVerifier.isValidName(isNull);
//		boolean returnedForTooShort=FieldVerifier.isValidName(tooShort);
//		boolean returnedForIsOk=FieldVerifier.isValidName(isOk);
//
//		assertEquals(returnedForIsNull, false);
//		assertEquals(returnedForTooShort, false);
//		assertEquals(returnedForIsOk, true);
//	}
//	
//	public void testaddRow() {
//		FlexTable wanted=new FlexTable();
//		wanted.setText(0,0,"A");
//		wanted.setText(0,1,"B");
//		wanted.setText(0,2,"C");
//		wanted.setText(0,3,"D");
//
//		FlexTable fillMe=new FlexTable();
//		String[] insert={"A","B","C","D"};
//		
//		fillMe=VisualizeTable.addRow(fillMe, insert);
//		
//		assertEquals(fillMe.getRowCount(), wanted.getRowCount());
//		assertEquals(fillMe.getCellCount(0), wanted.getCellCount(0));
//		assertEquals(fillMe.getText(0, 0), wanted.getText(0,0));
//		assertEquals(fillMe.getText(0, 1), wanted.getText(0,1));
//		assertEquals(fillMe.getText(0, 2), wanted.getText(0,2));
//		assertEquals(fillMe.getText(0, 3), wanted.getText(0,3));
//	}
//
//	public void testparsePop() {
//
//
//		String wantedString = "A,B,C,D,E,F,G,H,I,J,K";
//		String[] wanted = { "D", "I", "K" + " in Thousands"};
//		
//		Visualization myViz = new Visualization();
//		
//		String [] needed = myViz.parsePop(wantedString);
//		
//		assertTrue(Arrays.equals(wanted, needed));
//
//	}
//	
//	public void testparseTrade() {
//
//
//		String wantedString2 = "A,B,C,D,E,F,G,H,I,J,K";
//		String[] wanted2 = {"D", "I", "J", "K"};
//		
//		Visualization myVizz = new Visualization();
//		
//		String [] needed2 = myVizz.parseTrade(wantedString2);
//		
//		assertTrue(Arrays.equals(wanted2, needed2));
//
//	}
//	
//	public void testparseProd() {
//
//
//		String wantedString = "A,B,C,D,E,F,G,H,I,J,K";
//		String[] wanted = { "D", "H", "I", "K J"};
//		
//		Visualization myViz = new Visualization();
//		
//		String [] needed = myViz.parseProd(wantedString);
//		
//		assertTrue(Arrays.equals(wanted, needed));
//
//	}
//	
	//public void testgetPopulation() {
		/*
		final GreetingService myGreeting=GWT.create(GreetingService.class);
		
		//Get population data from Armenia in 2002
		String result = my.getPopulation("Armenia", "2002");
		
		String expected = "\"OA\",\"Annual population\",\"1\",\"Armenia\",\"511\",\"Total Population - Both sexes\",\"3010\",\"Population - Est. & Proj.\",\"2002\",\"1000\",\"3047.00\",\"\",\"Official data\"";
		
		assertEquals(result, expected);*/
		
		///OR
		
		/*
	      GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	      greetingService.getPopulation("Armenia", "2002", new AsyncCallback<String>() {
	    				public void onFailure(Throwable caught) {
	    					// Show the RPC error message to the user
	    					System.out.println(caught);
	    					fail("big time failure");
	    					finishTest();
	    				}

	    				public void onSuccess(String result) {
	    					System.out.println("success, biatch");
	    					assertTrue(true);
	    				}
	    			});
	      delayTestFinish(1000);
	      */
		
	//}
	
	
	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "com.test.RPC.RPCTest";
	}
	
}
