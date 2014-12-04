package com.test.RPC.client;

import com.google.gwt.user.client.ui.FlexTable;

public class VisualizeTable extends Visualization {
	public enum Case{
		POPULATION, TRADE, PRODUCTION
	}
	/*
	private FlexTable t;
*/
	//constructor
	/*public VisualizeTable(Case c) {
		int len;
		switch (c) {
		case POPULATION:
			len = 3;
		
				t.setText(0,0,"country");
				t.setText(0,1,"year");
				t.setText(0,2,"population");	
			
		case TRADE:
			len = 4;
				t.setText(0,0,"country");
				t.setText(0,1,"goods");
				t.setText(0,2,"year");
				t.setText(0,3,"population");	
			
		case PRODUCTION:			
				t.setText(0,0,"country");
				t.setText(0,1,"goods");
				t.setText(0,2,"year");
				t.setText(0,3,"population");	

		
		}
	}*/	
	
		
		public void addRow(FlexTable t, String[] data) {
			int high = t.getRowCount();
			for (int i = 0; i<data.length; i++) {
				t.setText(high, i, data[i]);
		
	}
		
	
}


		
	
}
