package com.test.RPC.client;

import com.google.gwt.user.client.ui.RootPanel;

public class AppState {
	private String year;
	private String untilYear;
	private String country;
	private String goods;
	
	//The dataset selected
	//0=population, 1=production, 2=trade
	private int dataSet=0;
	
	//The visualization currently shown
	//0=table, 1=map, 2=graph
	private int state=0;
	

	public int getDatSet() {
		return dataSet;
	}

	public void setDataSet(String dataSet) {

		if(dataSet.equals("Population")) {
			this.dataSet=0;
		} else if(dataSet.equals("Production")) {
			this.dataSet=1;
		} else if(dataSet.equals("Trade")) {
			this.dataSet=2;
		}
	}
	
	public void setDataSet(int dataSet) {
		this.dataSet = dataSet;
	}

	//Year currently selected
	//TODO: allow multiple selected years (for time series)

	public String getYear() {
		return year;
	}

	public void setUntilYear(String year) {
		this.untilYear = year;
	}
	
	public String getUntilYear() {
		return untilYear;
	}

	public void setYear(String year) {
		this.year = year;
	}

	
	//Country currently selected
	//TODO: allow multiple selected countries (for comparison)
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	//Good currently selected
	//TODO: allow multiple selected goods (for comparison)
	
	public String getGoods() {
		return this.goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	
	public void setState(int state) {
		this.state=state;
	}
	
	public int getState() {
		return this.state;
	}
}
