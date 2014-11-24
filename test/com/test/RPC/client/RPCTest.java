package com.test.RPC.client;

import static org.junit.Assert.*;

import javax.swing.Box.Filler;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.FlexTable;
import com.test.RPC.shared.FieldVerifier;
import com.test.RPC.client.VisualizeTable;
import com.test.RPC.client.Visualization;
import com.test.*;

public class RPCTest extends GWTTestCase {

	public void testisValidName() {
		String isNull=null;
		String tooShort="a";
		String isOk="A very long string";

		boolean returnedForIsNull=FieldVerifier.isValidName(isNull);
		boolean returnedForTooShort=FieldVerifier.isValidName(tooShort);
		boolean returnedForIsOk=FieldVerifier.isValidName(isOk);

		assertEquals(returnedForIsNull, false);
		assertEquals(returnedForTooShort, false);
		assertEquals(returnedForIsOk, true);
	}
	
	public void testaddRow() {
		FlexTable wanted=new FlexTable();
		wanted.setText(0,0,"A");
		wanted.setText(0,1,"B");
		wanted.setText(0,2,"C");
		wanted.setText(0,3,"D");

		FlexTable fillMe=new FlexTable();
		String[] insert={"A","B","C","D"};
		
		fillMe=VisualizeTable.addRow(fillMe, insert);
		
		assertEquals(fillMe.getRowCount(), wanted.getRowCount());
		assertEquals(fillMe.getCellCount(0), wanted.getCellCount(0));
		assertEquals(fillMe.getText(0, 0), wanted.getText(0,0));
		assertEquals(fillMe.getText(0, 1), wanted.getText(0,1));
		assertEquals(fillMe.getText(0, 2), wanted.getText(0,2));
		assertEquals(fillMe.getText(0, 3), wanted.getText(0,3));
	}

	public void testparsePop() {
//		String[] data = toParse.split("\\,");
//		//country, year, value (in 1000)
//		//﻿Domain Code,Domain,AreaCode,AreaName,ElementCode,ElementName,ItemCode,ItemName,Year,Unit,Value,Flag,FlagD
//		
//		String[] result = {data[3], data[8], data[10]};
//		return result;
		
		
		String wantedString = "A,B,C,D,E,F,G,H,I,J,K";
		String[] wanted = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K"};
		
		Visualization myViz = new Visualization();
		
		String [] needed = myViz.parsePop(wantedString);
		
		assertEquals(wanted, needed);
//		assertArrayEquals(wanted, needed);
		
	}
	
	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "com.test.RPC.RPCTest";
	}
	
}
