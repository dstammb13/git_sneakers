package com.test.RPC.client;

import java.util.ArrayList;

import com.test.RPC.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
//blabla
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RpcTest implements EntryPoint {
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	
//	private ArrayList<String> data = new ArrayList();
	public void onModuleLoad() {
		
		AppState state = new AppState();
		/*
		Button prodDemo = new Button("Production Demo");
		prodDemo.addClickHandler(new ClickHandler()
		{
			

			public void onClick(ClickEvent event) {			
				greetingService.getProduction("Switzerland", "Potatoes", "1992", new AsyncCallback<String>(){

					public void onFailure(Throwable caught) {
						Label c = new Label(caught.getLocalizedMessage());
						Label failure = new Label("Fail");
						RootPanel.get().add(failure);
						RootPanel.get().add(c);
					}

					
					public void onSuccess(String result) {
						VisualizeTable v = new VisualizeTable();
						FlexTable t = new FlexTable();
						t.setText(0,0,"country");
						t.setText(0,1,"goods");
						t.setText(0,2,"year");
						t.setText(0,3,"Production Value");	
						String[] data = v.parseProd(result);
						v.addRow(t, data);
						RootPanel.get().add(t);
						/*
						Label data = new Label(result);
						RootPanel.get().add(data);
					* /
					}


				});

			}
		});
		
		*/
		/*
		//TODO: getTrade, not getData()
		Button tradeDemo = new Button("Trade Demo");
		tradeDemo.addClickHandler(new ClickHandler()
		
		{
			public void onClick(ClickEvent event) {			
			//	greetingService.getTrade("Armenia", "Barley", "2002", new AsyncCallback<String>(){
				greetingService.getData("grep", new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						Label c = new Label(caught.getLocalizedMessage());
						Label failure = new Label("Fail");
						RootPanel.get().add(failure);
						RootPanel.get().add(c);
					}

					
					public void onSuccess(String result) {
						/*VisualizeTable v = new VisualizeTable();
						FlexTable t = new FlexTable();
						t.setText(0,0,"country");
						t.setText(0,1,"goods");
						t.setText(0,2,"year");
						t.setText(0,3,"Production Value");	
						String[] data = v.parseProd(result);
						v.addRow(t, data); * /
						Label t = new Label(result);
						RootPanel.get().add(t);
						
					}


				});

			}
		});*/
		/*
		Button popDemo = new Button("Population Demo");
		popDemo.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {			
				greetingService.getPopulation("Armenia", "", new AsyncCallback<String>(){

					public void onFailure(Throwable caught) {
						Label c = new Label(caught.getLocalizedMessage());
						Label failure = new Label("Fail");
						RootPanel.get().add(failure);
						RootPanel.get().add(c);
					}

					
					public void onSuccess(String result) {
						VisualizeTable stubTable = new VisualizeTable();
						FlexTable t = new FlexTable();
						t.setText(0,0,"Country");
						t.setText(0,1,"Year");
						t.setText(0,2,"Population");	
						
						String[] lines =result.split("\n");
						for(String iterate: lines ) {
							String[] fetched = stubTable.parseProd(iterate);
							stubTable.addRow(t, fetched);
						}
						RootPanel.get().add(t);
					}


				});

			}
		});
*/
		
		HorizontalPanel vizPanel = new HorizontalPanel();
		vizPanel.setWidth("80%");
		vizPanel.setHeight("100%");
		vizPanel.setStyleName("vizPanel");
		vizPanel.add(new Label("AGRAR VISUALIZER"));
		HorizontalPanel settingsPanel = new HorizontalPanel();
		settingsPanel.setWidth("20%");
		settingsPanel.setHeight("100%");
		settingsPanel.setStyleName("settingsPanel");
		settingsPanel.add(new Label("Settings"));
/*
		ListBox countryList= new ListBox();
		String countryData = "Armenia:Afghanistan:Albania:Algeria:American Samoa:Andorra:Angola:Antigua and Barbuda:Argentina:Australia:Austria:Bahamas:Bahrain:Barbados:Belgium-Luxembourg:Bangladesh:Bermuda:Bhutan:Bolivia (Plurinational State of):Botswana:Brazil:Aruba:Belize:Solomon Islands:Brunei Darussalam:Bulgaria:Myanmar:Burundi:Cameroon:Canada:Cabo Verde:Cayman Islands:Central African Republic:Sri Lanka:Chad:Chile:China:Colombia:Comoros:Congo:Cook Islands:Costa Rica:Cuba:Cyprus:Czechoslovakia:Azerbaijan:Benin:Denmark:Dominica:Dominican Republic:Belarus:Ecuador:Egypt:El Salvador:Equatorial Guinea:Ethiopia PDR:Estonia:Faroe Islands:Falkland Islands (Malvinas):Fiji:Finland:France:French Guiana:French Polynesia:Djibouti:Georgia:Gabon:Gambia:Germany:Bosnia and Herzegovina:Ghana:Gibraltar:Kiribati:Greece:Greenland:Grenada:Guadeloupe:Guam:Guatemala:Guinea:Guyana:Haiti:Holy See:Honduras:Hungary:Croatia:Iceland:India:Indonesia:Iran (Islamic Republic of):Iraq:Ireland:Israel:Italy:Côte d'Ivoire:Kazakhstan:Jamaica:Japan:Jordan:Kyrgyzstan:Kenya:Cambodia:Democratic People's Republic of Korea:Republic of Korea:Kuwait:Latvia:Lao People's Democratic Republic:Lebanon:Lesotho:Liberia:Libya:Liechtenstein:Lithuania:Marshall Islands:Madagascar:Malawi:Malaysia:Maldives:Mali:Malta:Martinique:Mauritania:Mauritius:Mexico:Monaco:Mongolia:Montserrat:Morocco:Mozambique:Micronesia (Federated States of):Republic of Moldova:Namibia:Nauru:Nepal:Netherlands:Netherlands Antilles:New Caledonia:The former Yugoslav Republic of Macedonia:Vanuatu:New Zealand:Nicaragua:Niger:Nigeria:Niue:Norway:Northern Mariana Islands:Pacific Islands Trust Territory:Pakistan:Panama:Czech Republic:Papua New Guinea:Paraguay:Peru:Philippines:Poland:Portugal:Guinea-Bissau:Timor-Leste:Puerto Rico:Eritrea:Qatar:Palau:Zimbabwe:Réunion:Romania:Rwanda:Russian Federation:Serbia and Montenegro:Saint Helena:Saint Kitts and Nevis:Saint Lucia:Saint Pierre and Miquelon:Saint Vincent and the Grenadines:San Marino:Sao Tome and Principe:Saudi Arabia:Senegal:Seychelles:Sierra Leone:Slovenia:Slovakia:Singapore:Somalia:South Africa:Spain:Western Sahara:Sudan (former):Suriname:Tajikistan:Swaziland:Sweden:Switzerland:Syrian Arab Republic:Turkmenistan:United Republic of Tanzania:Thailand:Togo:Tokelau:Tonga:Trinidad and Tobago:Oman:Tunisia:Turkey:Turks and Caicos Islands:United Arab Emirates:Uganda:Tuvalu:USSR:United Kingdom:Ukraine:United States of America:Burkina Faso:Uruguay:Uzbekistan:Venezuela (Bolivarian Republic of):Viet Nam:Ethiopia:British Virgin Islands:United States Virgin Islands:Wallis and Futuna Islands:Samoa:Yugoslav SFR:Yemen:Democratic Republic of the Congo:Zambia:Belgium:Luxembourg:Anguilla:Mayotte:Serbia:Montenegro:Sudan:South Sudan:Occupied Palestinian Territory:World:Africa:Eastern Africa:Middle Africa:Northern Africa:Southern Africa:Western Africa:Americas:Northern America:Central America:Caribbean:South America:Asia:Central Asia:Eastern Asia:Southern Asia:South-Eastern Asia:Western Asia:Europe:Eastern Europe:Northern Europe:Southern Europe:Western Europe:Oceania:Australia & New Zealand:Melanesia:Micronesia:Polynesia:European Union:Least Developed Countries:Land Locked Developing Countries:Small Island Developing States:Low Income Food Deficit Countries:Net Food Importing Developing Countries";
		String[] countries = countryData.split(":");
		for(String country : countries) {
			countryList.addItem(country);
		}
		settingsPanel.add(countryList);
		
		settingsPanel.add(new Label(""));
		ListBox year = new ListBox();
		for (int i = 1990; i <2012; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			year.addItem(sb.toString());
			
		}
		settingsPanel.add(year);
		
		
		ListBox dataSet= new ListBox();
		
		String[] dataSetPossibilities = {"Production","Population","Trade"};
		for(String dataSetIter : dataSetPossibilities) {
			dataSet.addItem(dataSetIter);
		}
		settingsPanel.add(dataSet);
		*/
		
		Button filterButton = new Button("Filter!");
		filterButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {
				//read the selected values for update

				//state.setCountry(countryList.getValue(countryList.getSelectedIndex()));
				//state.setYear(year.getValue(year.getSelectedIndex()));
				//state.setDataSet(dataSet.getValue(dataSet.getSelectedIndex()));
				
				switch(state.getState()) {
					default:
					case 0:
						//table
						switch(state.getDatSet()) {
							default:
							case 0:
								//production
								/*greetingService.getProduction(state.getCountry(), state.getGoods(), state.getYear(), new AsyncCallback<String>(){

									public void onFailure(Throwable caught) {
										Label c = new Label(caught.getLocalizedMessage());
										Label failure = new Label("Fail");
										RootPanel.get().add(failure);
										RootPanel.get().add(c);
									}

									
									public void onSuccess(String result) {
										VisualizeTable v = new VisualizeTable();
										FlexTable t = new FlexTable();
										t.setText(0,0,"country");
										t.setText(0,1,"goods");
										t.setText(0,2,"year");
										t.setText(0,3,"Production Value");	
										String[] data = v.parseProd(result);
										v.addRow(t, data);
										RootPanel.get().add(t);
										/*
										Label data = new Label(result);
										RootPanel.get().add(data);
									* /
									}


								});*/
							break;
							case 1:
								//population
								greetingService.getPopulation(state.getCountry(), state.getYear(), new AsyncCallback<String>(){
									
									public void onFailure(Throwable caught) {
										Label c = new Label(caught.getLocalizedMessage());
										Label failure = new Label("Fail");
										RootPanel.get().add(failure);
										RootPanel.get().add(c);
									}

									
									public void onSuccess(String result) {
										VisualizeTable stubTable = new VisualizeTable();
										FlexTable t = new FlexTable();
										t.setText(0,0,"Country");
										t.setText(0,1,"Year");
										t.setText(0,2,"Population");	
										
										String[] lines =result.split("\n");
										for(String iterate: lines ) {
											String[] fetched = stubTable.parseProd(iterate);
											stubTable.addRow(t, fetched);
										}
										RootPanel.get().add(t);
									}
								});
							break;
							case 2:
								//trade
								/*greetingService.getTrade(state.getCountry(), state.getGoods(), state.getYear(), new AsyncCallback<String>() {
									public void onFailure(Throwable caught) {
										Label c = new Label(caught.getLocalizedMessage());
										Label failure = new Label("Fail");
										RootPanel.get().add(failure);
										RootPanel.get().add(c);
									}

									
									public void onSuccess(String result) {
										/*VisualizeTable v = new VisualizeTable();
										FlexTable t = new FlexTable();
										t.setText(0,0,"country");
										t.setText(0,1,"goods");
										t.setText(0,2,"year");
										t.setText(0,3,"Production Value");	
										String[] data = v.parseProd(result);
										v.addRow(t, data); * /
										Label t = new Label(result);
										RootPanel.get().add(t);
										
									}


								});*/
							break;
							
						}//end switch getDataSet
						
					break;
					case 1:
						//map
						
					break;
					case 2:
						//graph
						
					break;
				
				}//switch state.state
				
			}//onclick
			
			
		});//ClickHandler callback
		settingsPanel.add(filterButton);
		
		
		Button tableButton = new Button("Table");
		tableButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {
				//vizPanel.clear();
				//TODO: add table according to state
				
			}
		});
		settingsPanel.addStyleName("visualizeTable");
		settingsPanel.add(tableButton);
		/*
		Button mapButton = new Button("Map");
		mapButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {
				vizPanel.clear();
				//TODO: add map according to state
				
			}
		});
		settingsPanel.addStyleName("visualizeMap");
		settingsPanel.add(mapButton);
		
		Button chartButton = new Button("Chart");
		chartButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {
				vizPanel.clear();
				//TODO: add table according to state
				
			}
		});
		settingsPanel.addStyleName("Charts");
		settingsPanel.add(chartButton);
		*/
		//vizPanel.add(tradeDemo);
		//vizPanel.add(prodDemo);
		//vizPanel.add(popDemo);
		RootPanel.get().add(vizPanel);
		RootPanel.get().add(settingsPanel);
		RootPanel.get().add(new Label("Test"));
		
		/*
		RootPanel.get().add(tradeDemo);
		RootPanel.get().add(popDemo);
		RootPanel.get().add(prodDemo);
		*/
	}
}
