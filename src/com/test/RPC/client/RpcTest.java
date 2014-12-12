package com.test.RPC.client;

import java.util.ArrayList;
import java.util.Stack;

import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLBRElement;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.builder.shared.HtmlBRBuilder;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RpcTest implements EntryPoint {
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	AppState state = new AppState();	
	public void onModuleLoad() {
	

		final HTML header = new HTML("<div style=\"clear:all;\"><h2 style=\"text-shadow:0em 3px 3px #ccc;font-size:3em;\">AgrarViz</h2><br /><i>Advanced data mining system solution</i>"
						+ "<br /><br /><br /><br clear=\"all\" /></div>");
		final HTML source = new HTML("Source: FAOSTAT Date: Mon Sep 15 01:42:26 CEST 2014, Field: wallpaperstock.net ID 43165, Tree: colourbox.com ID 3230211, <a href=\"http://wwww.iceflowstudios.com/2013/tutorials/loading-circle-animation-using-photshop-cs6\">Circle</a>");
		source.addStyleName("source");
		
		final HorizontalPanel vizPanel = new HorizontalPanel();
		vizPanel.setWidth("75%");
		vizPanel.setHeight("100%");
		vizPanel.setStyleName("vizPanel");
		vizPanel.add(header);
		final HTMLPanel settingsPanel = new HTMLPanel("");
		final HTML settingsTitle = new HTML("<h2 style=\"text-shadow:0em 3px 3px #444;font-size:3em;\">Settings</h2>");
		settingsPanel.add(settingsTitle);
		settingsPanel.setWidth("25%");
		settingsPanel.setHeight("100%");
		settingsPanel.setStyleName("settingsPanel");
		settingsPanel.add(source);
		
		//Generate a list for the countries
		final ListBox countryList= new ListBox();
		String countryData = "Armenia:Afghanistan:Albania:Algeria:American Samoa:Andorra:Angola:Antigua and Barbuda:Argentina:Australia:Austria:Bahamas:Bahrain:Barbados:Belgium-Luxembourg:Bangladesh:Bermuda:Bhutan:Bolivia (Plurinational State of):Botswana:Brazil:Aruba:Belize:Solomon Islands:Brunei Darussalam:Bulgaria:Myanmar:Burundi:Cameroon:Canada:Cabo Verde:Cayman Islands:Central African Republic:Sri Lanka:Chad:Chile:China:Colombia:Comoros:Congo:Cook Islands:Costa Rica:Cuba:Cyprus:Czechoslovakia:Azerbaijan:Benin:Denmark:Dominica:Dominican Republic:Belarus:Ecuador:Egypt:El Salvador:Equatorial Guinea:Ethiopia PDR:Estonia:Faroe Islands:Falkland Islands (Malvinas):Fiji:Finland:France:French Guiana:French Polynesia:Djibouti:Georgia:Gabon:Gambia:Germany:Bosnia and Herzegovina:Ghana:Gibraltar:Kiribati:Greece:Greenland:Grenada:Guadeloupe:Guam:Guatemala:Guinea:Guyana:Haiti:Holy See:Honduras:Hungary:Croatia:Iceland:India:Indonesia:Iran (Islamic Republic of):Iraq:Ireland:Israel:Italy:Côte d'Ivoire:Kazakhstan:Jamaica:Japan:Jordan:Kyrgyzstan:Kenya:Cambodia:Democratic People's Republic of Korea:Republic of Korea:Kuwait:Latvia:Lao People's Democratic Republic:Lebanon:Lesotho:Liberia:Libya:Liechtenstein:Lithuania:Marshall Islands:Madagascar:Malawi:Malaysia:Maldives:Mali:Malta:Martinique:Mauritania:Mauritius:Mexico:Monaco:Mongolia:Montserrat:Morocco:Mozambique:Micronesia (Federated States of):Republic of Moldova:Namibia:Nauru:Nepal:Netherlands:Netherlands Antilles:New Caledonia:The former Yugoslav Republic of Macedonia:Vanuatu:New Zealand:Nicaragua:Niger:Nigeria:Niue:Norway:Northern Mariana Islands:Pacific Islands Trust Territory:Pakistan:Panama:Czech Republic:Papua New Guinea:Paraguay:Peru:Philippines:Poland:Portugal:Guinea-Bissau:Timor-Leste:Puerto Rico:Eritrea:Qatar:Palau:Zimbabwe:Réunion:Romania:Rwanda:Russian Federation:Serbia and Montenegro:Saint Helena:Saint Kitts and Nevis:Saint Lucia:Saint Pierre and Miquelon:Saint Vincent and the Grenadines:San Marino:Sao Tome and Principe:Saudi Arabia:Senegal:Seychelles:Sierra Leone:Slovenia:Slovakia:Singapore:Somalia:South Africa:Spain:Western Sahara:Sudan (former):Suriname:Tajikistan:Swaziland:Sweden:Switzerland:Syrian Arab Republic:Turkmenistan:United Republic of Tanzania:Thailand:Togo:Tokelau:Tonga:Trinidad and Tobago:Oman:Tunisia:Turkey:Turks and Caicos Islands:United Arab Emirates:Uganda:Tuvalu:USSR:United Kingdom:Ukraine:United States of America:Burkina Faso:Uruguay:Uzbekistan:Venezuela (Bolivarian Republic of):Viet Nam:Ethiopia:British Virgin Islands:United States Virgin Islands:Wallis and Futuna Islands:Samoa:Yugoslav SFR:Yemen:Democratic Republic of the Congo:Zambia:Belgium:Luxembourg:Anguilla:Mayotte:Serbia:Montenegro:Sudan:South Sudan:Occupied Palestinian Territory:World:Africa:Eastern Africa:Middle Africa:Northern Africa:Southern Africa:Western Africa:Americas:Northern America:Central America:Caribbean:South America:Asia:Central Asia:Eastern Asia:Southern Asia:South-Eastern Asia:Western Asia:Europe:Eastern Europe:Northern Europe:Southern Europe:Western Europe:Oceania:Australia & New Zealand:Melanesia:Micronesia:Polynesia:European Union:Least Developed Countries:Land Locked Developing Countries:Small Island Developing States:Low Income Food Deficit Countries:Net Food Importing Developing Countries";
		String[] countries = countryData.split(":");
		for(String country : countries) {
			countryList.addItem(country);
		}
		settingsPanel.add(countryList);

		settingsPanel.add(new HTML("<br />"));
		
		HTMLPanel yearChooser=new HTMLPanel("");
		//Generate a list for the year
		final ListBox year = new ListBox();
		//year.addItem("any year");
		for (int i = 1990; i <2012; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			year.addItem(sb.toString());
			
		}
		yearChooser.add(year);
		
		
		Label untilLabel=new Label(" until ");
		untilLabel.setStyleName("inlineLabel");
		yearChooser.add(untilLabel);
		
		final ListBox yearUntil = new ListBox();
		for (int i = 1990; i <2012; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			yearUntil.addItem(sb.toString());
			
		}
		yearUntil.setItemSelected(yearUntil.getItemCount()-1, true);
		yearChooser.add(yearUntil);
		
		HTML hintLabel=new HTML("<br /><br />");
		hintLabel.setStyleName("inlineLabel");
		yearChooser.add(hintLabel);
		
		settingsPanel.add(yearChooser);

		//Generate a list for the dataset
		final ListBox dataSet= new ListBox();
		
		String[] dataSetPossibilities = {"Production","Population","Trade"};
		for(String dataSetIter : dataSetPossibilities) {
			dataSet.addItem(dataSetIter);
		}
		settingsPanel.add(dataSet);

		settingsPanel.add(new HTML("<br />"));

		//Generate a list for the goods
		final ListBox goodList = new ListBox();
		String goodData = "Anise, badian, fennel, coriander;Apples;Apricots;Artichokes;Asparagus;Avocados;Bananas;Barley;Beans, dry;Beans, green;Blueberries;Broad beans, horse beans, dry;Buckwheat;Cabbages and other brassicas;Canary seed;Carrots and turnips;Cashew nuts, with shell;Cashewapple;Cassava;Cauliflowers and broccoli;Cherries;Cherries, sour;Chestnut;Chick peas;Chillies and peppers, dry;Chillies and peppers, green;Cinnamon (canella);Cloves;Cocoa, beans;Coconuts;Coffee, green;Cotton lint;Cottonseed;Cranberries;Cucumbers and gherkins;Currants;Dates;Eggplants (aubergines);Figs;Flax fibre and tow;Fonio;Fruit, fresh nes;Fruit, tropical fresh nes;Garlic;Ginger;Gooseberries;Grain, mixed;Grapefruit (inc. pomelos);Grapes;Hops;Jute;Kapok fibre;Kapokseed in shell;Kiwi fruit;Kola nuts;Leeks, other alliaceous vegetables;Lemons and limes;Lentils;Lettuce and chicory;Linseed;Maize;Maize, green;Mangoes, mangosteens, guavas;Manila fibre (abaca);MatÃ©;Melons, other (inc.cantaloupes);Millet;Mushrooms and truffles;Mustard seed;Nutmeg, mace and cardamoms;Nuts, nes;Oats;Oil, palm;Oilseeds nes;Olives;Onions, dry;Onions, shallots, green;Oranges;Papayas;Peaches and nectarines;Pears;Peas, dry;Peas, green;Pepper (piper spp.);Peppermint;Persimmons;Pineapples;Pistachios;Plantains;Plums and sloes;Popcorn;Poppy seed;Potatoes;Pumpkins, squash and gourds;Pyrethrum, dried;Quinces;Rapeseed;Roots and tubers, nes;Rubber, natural;Rye;Sesame seed;Sorghum;Soybeans;Spices, nes;Spinach;Strawberries;Sugar beet;Sugar crops, nes;Sunflower seed;Sweet potatoes;Tangerines, mandarins, clementines, satsumas;Tea;Tobacco, unmanufactured;Tomatoes;Triticale;Vanilla;Vegetables, fresh nes;Vetches;Walnuts, with shell;Watermelons;Wheat";
		String[] goods = goodData.split(";");
		for(String good : goods) {
			goodList.addItem(good);
		}
		settingsPanel.add(goodList);
		
		settingsPanel.add(new HTML("<br />"));
		

		//Generate the filter button
		Button filterButton = new Button("Filter!");
		filterButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {
				//read the selected values for update
				vizPanel.clear();
				vizPanel.add(header);
				state.setCountry(countryList.getValue(countryList.getSelectedIndex()));
				
				Integer myYear=new Integer(year.getValue(year.getSelectedIndex()));
				Integer myUntilYear=new Integer(yearUntil.getValue(yearUntil.getSelectedIndex()));
				
				if(myYear<=myUntilYear) {
					//valid range
					state.setYear(year.getValue(year.getSelectedIndex()));
					state.setUntilYear(yearUntil.getValue(yearUntil.getSelectedIndex()));
				} else {
					//inverse selection
					state.setYear(yearUntil.getValue(yearUntil.getSelectedIndex()));
					state.setUntilYear(year.getValue(year.getSelectedIndex()));
				}
				
				state.setDataSet(dataSet.getValue(dataSet.getSelectedIndex()));
				state.setGoods(goodList.getValue(goodList.getSelectedIndex()));
				/*String stateDebug="State ist: ";
				stateDebug+="state: "+state.getState()+" (0=table, 1=map, 2=chart), "
						+ "dataSet: "+state.getDatSet()+" (0=population, 1=production, 2=trade)"
						+ "country: "+state.getCountry()+" "
						+ "goods: "+state.getGoods()+" "
						+ "year: "+state.getYear()+"";
				*/
				if(state.getState()==0) {
						//table
						if(state.getDatSet()==0) {
								//population
								vizPanel.clear();
								vizPanel.add(header);
								greetingService.getPopulation(state.getCountry(), state.getYear(), state.getUntilYear(), new AsyncCallback<String>(){
									
									public void onFailure(Throwable caught) {
										Label c = new Label(caught.getLocalizedMessage());
										Label failure = new Label("Fail");
										vizPanel.add(failure);
										vizPanel.add(c);
									}
									
									public void onSuccess(String result) {
										FlexTable t = new FlexTable();
										t.setText(0,0,"Country");
										t.getCellFormatter().addStyleName(0, 0, "listHeader");
										t.setText(0,1,"Year");
										t.getCellFormatter().addStyleName(0, 1, "listHeader");
										t.setText(0,2,"Population (in Thousands)");
										t.getCellFormatter().addStyleName(0, 2, "listHeader");
									    t.getRowFormatter().addStyleName(0, "listHeader");
										
										String[] lines =result.split("#");
										for(int i=0;i<lines.length;++i) {
											String[] fetched = lines[i].split(",");
											int column=0;
											for (int j=0;j<fetched.length;++j) {
													if(j==3 || j==8 || j==10) {
														//+1: offset from header
														t.getCellFormatter().addStyleName(i+1, column, "listRow");
														t.setText(i+1, column, fetched[j].replace("\"",""));
														column++;
													}
											}
										}
										t.addStyleName("table");
										vizPanel.add(t);
									}
								});

						} else if(state.getDatSet()==1) {
							//production
							vizPanel.clear();
							vizPanel.add(header);
							greetingService.getProduction(state.getCountry(), state.getGoods(), state.getYear(), state.getUntilYear(), new AsyncCallback<String>(){
								
								public void onFailure(Throwable caught) {
									Label c = new Label(caught.getLocalizedMessage());
									Label failure = new Label("Fail");
									vizPanel.add(failure);
									vizPanel.add(c);
								}

								
								public void onSuccess(String result) {
									FlexTable t = new FlexTable();
								    t.getRowFormatter().addStyleName(0, "listHeader");
									t.setText(0,0,"Country");
									t.getCellFormatter().addStyleName(0, 0, "listHeader");
									t.setText(0,1, "Goods");
									t.getCellFormatter().addStyleName(0, 1, "listHeader");
									t.setText(0,2,"Year");
									t.getCellFormatter().addStyleName(0, 2, "listHeader");
									t.setText(0,3,"Production Value");	
									t.getCellFormatter().addStyleName(0, 3, "listHeader");

									//vizPanel.add(new Label(result));
									String[] lines =result.split("#");
									for(int i=0;i<lines.length;++i) {
										if(!lines[i].equals("")) {
											String[] fetched = lines[i].split(",");
											int column=0;
											for (int j=0;j<fetched.length;++j) {
													if(j==3 || j==7 || j==8 || j==10) {
														//+1: offset from header
														t.getCellFormatter().addStyleName(i+1, column, "listRow");
														String appendTonnes=new String();
														if(j==10) {
															appendTonnes=" tonnes";
														} else {
															appendTonnes="";
														}
														t.setText(i+1, column, fetched[j].replace("\"","")+appendTonnes);
														column++;
													}
											}
										}
									}
									vizPanel.add(t);
									t.addStyleName("table");
								}
							});
							
					} else if(state.getDatSet()==2) {
								//trade
								vizPanel.clear();
								vizPanel.add(header);
								greetingService.getTrade(state.getCountry(), state.getGoods(), state.getYear(), state.getUntilYear(), new AsyncCallback<String>() {
									public void onFailure(Throwable caught) {
										Label c = new Label(caught.getLocalizedMessage());
										Label failure = new Label("Fail");
										vizPanel.add(failure);
										vizPanel.add(c);
									}

									
									public void onSuccess(String result) {
										FlexTable t = new FlexTable();
										t.setText(0,0,"Country");
										t.getCellFormatter().addStyleName(0, 0, "listHeader");
										t.setText(0,1, "Good");
										t.getCellFormatter().addStyleName(0, 1, "listHeader");
										t.setText(0,2,"Year");
										t.getCellFormatter().addStyleName(0, 2, "listHeader");
										t.setText(0,3,"Import (in tons)");
										t.getCellFormatter().addStyleName(0, 3, "listHeader");
										t.setText(0,4,"Export (in tons)");
										t.getCellFormatter().addStyleName(0, 4, "listHeader");

									    t.getRowFormatter().addStyleName(0, "listHeader");
										//vizPanel.add(new Label(result));
										
										String[] lines =result.split("#");
										for(int i=0;i<lines.length;++i) {
										    t.getRowFormatter().addStyleName(i+1, "listRow");
											String[] fetched = lines[i].split(",");
											int column=0;
											for (int j=0;j<fetched.length;++j) {
													if(
															j==3 /*country*/ ||
															j==7 /*good*/ ||
															j==8 /*year*/ ||
															j==10 /*import value*/||
															j==22 /*export value*/
													) {
														//+1: offset from header 
														t.getCellFormatter().addStyleName(i+1, column, "listRow");
														t.setText(i+1, column, fetched[j].replace("\"",""));
														column++;
													}
											}
										}
										vizPanel.add(t);
										t.addStyleName("table");
									}
								});
							
						}//end if getDataSet
						
				} else if(state.getState()==1) {
						//map
						vizPanel.clear();
						vizPanel.add(header);
						vizPanel.add(new Label("To be implemented."));
				} else if(state.getState()==2) {
						//graph
						if(state.getDatSet()==0) {
							//population
							vizPanel.clear();
							vizPanel.add(header);
							greetingService.getPopulation(state.getCountry(), state.getYear(), state.getUntilYear(), new AsyncCallback<String>(){
	
								public void onFailure(Throwable caught) {
									Label c = new Label(caught.getLocalizedMessage());
									Label failure = new Label("Fail");
									vizPanel.add(failure);
									vizPanel.add(c);
								}
	
										
								public void onSuccess(String result) {
									String[] lines =result.split("#");
									//vizPanel.add(new Label(result));
									
									vizPanel.add(new HTML("<h2 style=\"font-size:2em;position:absolute;top:20%;left:2em;\">"+state.getCountry()+"</h2>"));
									
									//fetch maximum & minimum
									Float min = new Float(0);
									Float max = new Float(0);
									
									int goneThrough=0;
									for (int i=0; i<lines.length;++i) {
										if (!lines[i].equals("")) {
											String[] values=lines[i].replace("\"","").split(",");
											Float val=new Float(values[10].replace("\"",""));
											//4: delete decimal point, two decimals and calculate -1 because values[] starting at zero
											//Integer val = new Integer(values[10].substring(0,values[10].length()-1));
											if(goneThrough==0) {
												min=max=val;
											} else {
												//test on maximum
												if (val > max) {
													max = val;
												}
												//test on minimum
												if (val < min) {
													max = val;
												}
											}
											goneThrough++;
										}
									}
									
									if(min>max) {
										Float tmp=new Float(0);
										tmp=max;
										max=min;
										min=tmp;
									}
									
									//hint about scaled
									vizPanel.add(new HTML("<span style=\"font-size:1em;position:absolute;top:28%;left:2em;\">Scaled from "+min+" persons in 1000 up to "+max+" persons in 1000</div>"));
									
									goneThrough=0;
									for(int i=0;i<lines.length;++i) {
										if (!lines[i].equals("")) {
											String myLine=lines[i];
											String[] values=myLine.split(",");
											if (values.length > 10) {
	
											Float popValue=new Float(values[10].replace("\"",""));
											Integer yearValue=new Integer(values[8].replace("\"",""));
											
											StringBuilder sb = new StringBuilder();
											sb.append("<div style='position:absolute;vertical-align:bottom;bottom:20%;width:3em;background-color:#a");
											sb.append(goneThrough%10);
											sb.append("0;left:");
											sb.append((goneThrough*3)+2);
											sb.append("em;height:");
											
											//40: maximum height in percent of the document height
											Float percentFromBottonLine=((popValue-min)/(max-min)*40)+5;
											
											sb.append(percentFromBottonLine);
											//vizPanel.add(new Label(new String(percentFromBottonLine+"")));
											sb.append("%;'>");
											sb.append(yearValue);
											sb.append("</div>");
											vizPanel.add(new HTML(sb.toString()));
											//vizPanel.add(new Label(percentFromBottonLine.toString()));
											}
											goneThrough++;
										}
									}
									
								}
							});
	
						} else if(state.getDatSet()==1) {
							//production
							vizPanel.clear();
							vizPanel.add(header);
							greetingService.getProduction(state.getCountry(),state.getGoods(), state.getYear(), state.getUntilYear(), new AsyncCallback<String>(){
	
								public void onFailure(Throwable caught) {
									Label c = new Label(caught.getLocalizedMessage());
									Label failure = new Label("Fail");
									vizPanel.add(failure);
									vizPanel.add(c);
								}
	
										
								public void onSuccess(String result) {
									String[] lines =result.split("#");
									//vizPanel.add(new Label(result));
									
									vizPanel.add(new HTML("<h2 style=\"font-size:2em;position:absolute;top:20%;left:2em;\">"+state.getCountry()+": "+state.getGoods()+"</h2>"));
									
									//fetch maximum & minimum
									Float min = new Float(0);
									Float max = new Float(0);

									int goneThrough=0;
									for (int i=0; i<lines.length;++i) {
										if (!lines[i].equals("")) {
											String[] values=lines[i].replace("\"","").split(",");
											Float val=new Float(values[10].replace("\"",""));
											//4: delete decimal point, two decimals and calculate -1 because values[] starting at zero
											//Integer val = new Integer(values[10].substring(0,values[10].length()-1));
											if(goneThrough==0) {
												min=max=val;
											} else {
												//test on maximum
												if (val > max) {
													max = val;
												}
												//test on minimum
												if (val < min) {
													max = val;
												}
											}
											goneThrough++;
										}
									}

									if(min>max) {
										Float tmp=new Float(0);
										tmp=max;
										max=min;
										min=tmp;
									}
									
									//hint about scaled
									vizPanel.add(new HTML("<span style=\"font-size:1em;position:absolute;top:28%;left:2em;\">Scaled from "+min+" tonnes up to "+max+" tonnes of "+state.getGoods()+"</div>"));
									
									goneThrough=0;
									for(int i=0;i<lines.length;++i) {
										if (!lines[i].equals("")) {
											String myLine=lines[i];
											String[] values=myLine.split(",");
											if (values.length > 10) {
	
											Float popValue=new Float(values[10].replace("\"",""));
											Integer yearValue=new Integer(values[8].replace("\"",""));
											
											StringBuilder sb = new StringBuilder();
											sb.append("<div style='position:absolute;vertical-align:bottom;bottom:20%;width:3em;background-color:#a");
											sb.append(goneThrough%10);
											sb.append("0;left:");
											sb.append((goneThrough*3)+2);
											sb.append("em;height:");
											
											//40: maximum height in percent of the document height
											Float percentFromBottonLine=((popValue-min)/(max-min)*40)+5;
											
											sb.append(percentFromBottonLine);
											//vizPanel.add(new Label(new String(percentFromBottonLine+"")));
											sb.append("%;'>");
											sb.append(yearValue);
											sb.append("</div>");
											vizPanel.add(new HTML(sb.toString()));
											}
											goneThrough++;
										}
									}
									
								}
							});
						} else if(state.getDatSet()==2) {
							//trade
							vizPanel.clear();
							vizPanel.add(header);
							greetingService.getTrade(state.getCountry(),state.getGoods(), state.getYear(), state.getUntilYear(), new AsyncCallback<String>(){
	
								public void onFailure(Throwable caught) {
									Label c = new Label(caught.getLocalizedMessage());
									Label failure = new Label("Fail");
									vizPanel.add(failure);
									vizPanel.add(c);
								}
								
								
								public void onSuccess(String result) {
									String[] lines =result.split("#");
									//vizPanel.add(new Label(result));
									
									vizPanel.add(new HTML("<h2 style=\"font-size:2em;position:absolute;top:20%;left:2em;\">"+state.getCountry()+": "+state.getGoods()+"</h2>"));
									
									//fetch maximum & minimum
									Float min = new Float(0);
									Float max = new Float(0);

									int goneThrough=0;
									for (int i=0; i<lines.length;++i) {
										if (!lines[i].equals("")) {
											String[] values=lines[i].replace("\"","").split(",");
											Float val=new Float(values[10].replace("\"",""));
											//4: delete decimal point, two decimals and calculate -1 because values[] starting at zero
											//Integer val = new Integer(values[10].substring(0,values[10].length()-1));
											if(goneThrough==0) {
												min=max=val;
											} else {
												//test on maximum
												if (val > max) {
													max = val;
												}
												//test on minimum
												if (val < min) {
													max = val;
												}
											}
											goneThrough++;
										}
									}

									if(min>max) {
										Float tmp=new Float(0);
										tmp=max;
										max=min;
										min=tmp;
									}
									
									//hint about scaled
									vizPanel.add(new HTML("<span style=\"font-size:1em;position:absolute;top:28%;left:2em;\">Scaled from "+min+" tonnes up to "+max+" tonnes of "+state.getGoods()+"</div>"));
									
									goneThrough=0;
									for(int i=0;i<lines.length;++i) {
										if (!lines[i].equals("")) {
											String myLine=lines[i];
											String[] values=myLine.split(",");
											if (values.length > 10) {
	
											Float popValue=new Float(values[10].replace("\"",""));
											Integer yearValue=new Integer(values[8].replace("\"",""));
											
											StringBuilder sb = new StringBuilder();
											sb.append("<div style='position:absolute;vertical-align:bottom;bottom:20%;width:3em;background-color:#a");
											sb.append(goneThrough%10);
											sb.append("0;left:");
											sb.append((goneThrough*3)+2);
											sb.append("em;height:");
											
											//40: maximum height in percent of the document height
											Float percentFromBottonLine=((popValue-min)/(max-min)*40)+5;
											
											sb.append(percentFromBottonLine);
											//vizPanel.add(new Label(new String(percentFromBottonLine+"")));
											sb.append("%;'>");
											sb.append(yearValue);
											sb.append("</div>");
											vizPanel.add(new HTML(sb.toString()));
											}
											goneThrough++;
										}
									}
									
								}
							});
						}//end if getDataSet
				}
				
			}//onclick
			
			
		});//ClickHandler callback
		settingsPanel.add(filterButton);

		HorizontalPanel stateChange = new HorizontalPanel();
		stateChange.addStyleName("stateChange");
		
		final Button tableButton = new Button("Table");
		final Button mapButton = new Button("Map");
		final Button chartButton = new Button("Histogram");
		
		tableButton.setStyleName("buttonActive");
		mapButton.setStyleName("buttonInactive");
		chartButton.setStyleName("buttonInactive");
		
		tableButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {
				vizPanel.clear();
				vizPanel.add(header);
				tableButton.setStyleName("buttonActive");
				mapButton.setStyleName("buttonInactive");
				chartButton.setStyleName("buttonInactive");
				
				state.setState(0);
				//TODO: add table according to state
				
			}
		});
		tableButton.addStyleName("visualizeTable");
		stateChange.add(tableButton);
		
		mapButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {
				vizPanel.clear();
				vizPanel.add(header);
				tableButton.setStyleName("buttonInactive");
				mapButton.setStyleName("buttonActive");
				chartButton.setStyleName("buttonInactive");
				state.setState(1);
				//TODO: add map according to state
				vizPanel.add(new HTML("<span style=\"color:#a00;text-decoration:blink;font-size:3em;font-weight:bold;position:absolute;left:0em;top:50%;\">To be implemented!</span>"));
				
			}
		});
		mapButton.addStyleName("visualizeMap");
		stateChange.add(mapButton);
		
		chartButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {
				vizPanel.clear();
				vizPanel.add(header);
				tableButton.setStyleName("buttonInactive");
				mapButton.setStyleName("buttonInactive");
				chartButton.setStyleName("buttonActive");
				state.setState(2);
				//TODO: add histogram according to state
				
			}
		});
		chartButton.addStyleName("Charts");
		stateChange.add(chartButton);
		
		
		
		//vizPanel.add(tradeDemo);
		//vizPanel.add(prodDemo);
		//vizPanel.add(popDemo);
		RootPanel.get().add(vizPanel);
		RootPanel.get().add(settingsPanel);
		RootPanel.get().add(stateChange);
		/*
		RootPanel.get().add(tradeDemo);
		RootPanel.get().add(popDemo);
		RootPanel.get().add(prodDemo);
		*/
	}
}
