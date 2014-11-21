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
import com.google.gwt.user.client.ui.Label;
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
	
//	private ArrayList<String> data = new ArrayList();
	public void onModuleLoad() {
		
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
					*/
					}


				});

			}
		});
		
		
		
		
		Button tradeDemo = new Button("Trade Demo");
		tradeDemo.addClickHandler(new ClickHandler()
		
		{
			public void onClick(ClickEvent event) {			
				greetingService.getTrade("Armenia", "Barley", "2002", new AsyncCallback<String>(){

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
						
					}


				});

			}
		});

		
		Button popDemo = new Button("Population Demo");
		popDemo.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event) {			
				greetingService.getPopulation("Armenia", "2002", new AsyncCallback<String>(){

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
						t.setText(0,1,"year");
						t.setText(0,2,"population");	
						String[] data = v.parseProd(result);
						v.addRow(t, data);
						RootPanel.get().add(t);
											}


				});

			}
		});


		//RootPanel.get().add(tradeDemo);
		RootPanel.get().add(popDemo);
		RootPanel.get().add(prodDemo);
		
	}
}
