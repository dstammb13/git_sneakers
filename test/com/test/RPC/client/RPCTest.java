package com.test.RPC.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;
import com.test.RPC.shared.FieldVerifier;
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

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "com.test.RPC.RPCTest";
	}
	
}
