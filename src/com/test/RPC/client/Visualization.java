package com.test.RPC.client;

public class Visualization {
	
	public String[] parsePop(String toParse) {
		String[] data = toParse.split("\\,");
		//country, year, value (in 1000)
		//﻿Domain Code,Domain,AreaCode,AreaName,ElementCode,ElementName,ItemCode,ItemName,Year,Unit,Value,Flag,FlagD
		
		String[] result = {data[3], data[8], data[10]};
		return result;
	}
	
	public String[] parseTrade(String toParse) {
		String[] data = toParse.split("\\,");
		//country, goods, year, value (in tonnes)
		//﻿Domain Code,Domain,AreaCode,AreaName,ElementCode,ElementName,ItemCode,ItemName,Year,Unit,Value,Flag,FlagD
		
		String[] result = {data[3], data[8], data[9], data[10]};
		return result;
	}
	
	public String[] parseProd(String toParse) {
		String[] data = toParse.split("\\,");
		//country, goods, year, value (in tonnes)
		//﻿Domain Code,Domain,AreaCode,AreaName,ElementCode,ElementName,ItemCode,ItemName,Year,Unit,Value,Flag,FlagD
		
		String[] result = {data[3], data[7], data[8], data[10] + " " + data[9]};
		return result;
	}
	
	
}
