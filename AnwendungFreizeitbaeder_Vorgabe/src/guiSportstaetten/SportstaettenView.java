package guiSportstaetten;

import java.io.IOException;

import business.Freizeitbad;
import business.FreizeitbaederModel;
import business.Sporthalle;
import business.SporthallenModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class SportstaettenView {
	
	// Hier ergaenzen
		private FreizeitbaederModel fbm;
		private SportstaettenControl sc;
		private SporthallenModel spM;
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane     				       
 		= new  Pane();
    	private Label lblAnzeigeFreizeitbaeder     
 		= new Label("Anzeige Freizeitbäder");
    	private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
    	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
    	
    	private Label lblAnzeigesporthallen= new Label ("Anzeige Sporthallen");
    	private TextArea txtAnzeigeSporthallen =new TextArea();
    	private Button btnAnzeigeSporthallen= new Button("csv-import und anzeigen");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public SportstaettenView(Stage primaryStage,SportstaettenControl sc,FreizeitbaederModel fbm,SporthallenModel spM){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Sportstätten");
    		primaryStage.show();
    		// Hier ergaenzen
    		this.fbm=fbm;
    		this.sc=sc;
    		this.spM=spM;


    		this.initKomponentenFreizeitbaeder();
    		this.initKomponentenSporthallen();
    		//this.initListener();
    		this.initListenerFreizeitbaeder();
    		this.initListenerSporthallen();
    		
        	}
        	private void initKomponentenFreizeitbaeder(){
        		// Label
     		Font font = new Font("Arial", 20);
           	lblAnzeigeFreizeitbaeder.setLayoutX(310);
        		lblAnzeigeFreizeitbaeder.setLayoutY(40);
        		lblAnzeigeFreizeitbaeder.setFont(font);
        		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
           	pane.getChildren().add(lblAnzeigeFreizeitbaeder); 
           /*	Font font2 = new Font("Arial", 20);
           	lblAnzeigesporthallen.setLayoutX(31);
        		lblAnzeigesporthallen.setLayoutY(40);
        		lblAnzeigesporthallen.setFont(font2);
        		lblAnzeigesporthallen.setStyle("-fx-font-weight: bold;"); 
           	pane.getChildren().add(lblAnzeigesporthallen); */  
            	// Textbereich	
            	txtAnzeigeFreizeitbaeder.setEditable(false);
         		txtAnzeigeFreizeitbaeder.setLayoutX(310);
        		txtAnzeigeFreizeitbaeder.setLayoutY(90);
         		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
        		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
           	pane.getChildren().add(txtAnzeigeFreizeitbaeder);  
           	
        	/*txtAnzeigeSporthallen.setEditable(false);
     		txtAnzeigeSporthallen.setLayoutX(31);
    		txtAnzeigeSporthallen.setLayoutY(90);
     		txtAnzeigeSporthallen.setPrefWidth(220);
    		txtAnzeigeSporthallen.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeSporthallen);  */
           	
           	
            	// Button
              	btnAnzeigeFreizeitbaeder.setLayoutX(310);
            	btnAnzeigeFreizeitbaeder.setLayoutY(290);
            	pane.getChildren().add(btnAnzeigeFreizeitbaeder); 
            	
            	
            /*	btnAnzeigeSporthallen.setLayoutX(31);
            	btnAnzeigeSporthallen.setLayoutY(290);
            	pane.getChildren().add(btnAnzeigeSporthallen); */
            	
            	
       }
        	private void initKomponentenSporthallen() {
        		Font font2 = new Font("Arial", 20);
               	lblAnzeigesporthallen.setLayoutX(31);
            		lblAnzeigesporthallen.setLayoutY(40);
            		lblAnzeigesporthallen.setFont(font2);
            		lblAnzeigesporthallen.setStyle("-fx-font-weight: bold;"); 
               	pane.getChildren().add(lblAnzeigesporthallen); 
               	
               	txtAnzeigeSporthallen.setEditable(false);
         		txtAnzeigeSporthallen.setLayoutX(31);
        		txtAnzeigeSporthallen.setLayoutY(90);
         		txtAnzeigeSporthallen.setPrefWidth(220);
        		txtAnzeigeSporthallen.setPrefHeight(185);
           	pane.getChildren().add(txtAnzeigeSporthallen); 
           	
           	btnAnzeigeSporthallen.setLayoutX(31);
        	btnAnzeigeSporthallen.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeSporthallen); 
        	}
       
       private void initListenerFreizeitbaeder() {
    	    /*btnAnzeigeFreizeitbaeder.setOnAction(
     			new EventHandler<ActionEvent>() {
    	    		@Override
    	        	public void handle(ActionEvent e) {
    	            	zeigeFreizeitbaederAn();
    	        	} 
     	   	    });*/
    	   btnAnzeigeFreizeitbaeder.setOnAction(e ->zeigeFreizeitbaederAn());
       }
      
       /*public void zeigeFreizeitbaederAn(){
       		if(fbm.getFreizeitbad() != null){
       			txtAnzeigeFreizeitbaeder.setText(
       				fbm.getFreizeitbad()
    				.gibFreizeitbadZurueck(' '));
       		}
       		else{
       			zeigeInformationsfensterAn(
    				"Bisher wurde kein Freizeitbad aufgenommen!");
       		}
       }*/
       
       private void initListenerSporthallen() {
    	   btnAnzeigeSporthallen.setOnAction(
                   new EventHandler<ActionEvent>() {
                       @Override
                       public void handle(ActionEvent e) {
                           
                           try {
   							spM.leseSporthallenAusCsvDatei();
   							zeigeSporthallenAn();
   						} catch (IOException | PlausiException e1) {
   							// TODO Auto-generated catch block
   							e1.printStackTrace();
   						}
                       }
                   });
       }
       public void zeigeFreizeitbaederAn(){
       	if(fbm.getFreizeitbad().size()>0) {
       		StringBuffer text = new StringBuffer();
       		
       		for(Freizeitbad fzb:fbm.getFreizeitbad()) 
       		{
       			text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
       		}
       		this.txtAnzeigeFreizeitbaeder.setText(text.toString());
       	}else {
       		zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
       	}
       			
       }
       public void zeigeSporthallenAn(){
          	if(spM.getSporthallen().size()>0) {
          		StringBuffer text = new StringBuffer();
          		
          		for(Sporthalle fzb:spM.getSporthallen()) 
          		{
          			text.append(fzb.gibSporthalleZurueck(' ') + "\n");
          		}
          		this.txtAnzeigeSporthallen.setText(text.toString());
          	}else {
          		zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
          	}
          			
          }
      
       private void zeigeInformationsfensterAn(String meldung){
       	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
                  	"Information", meldung).zeigeMeldungsfensterAn();
       }	
       
   }


