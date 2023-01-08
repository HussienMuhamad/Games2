package business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ownUtil.Observable;
import ownUtil.Observer;
import ownUtil.PlausiException;

public class SporthallenModel implements Observable{
	private static SporthallenModel instance;
	private ArrayList<Sporthalle> sporthallen = new ArrayList<Sporthalle>();
	private ArrayList<Observer> observer =new  ArrayList<Observer>();
	
	private SporthallenModel() {
		super();
	}
	
	public static SporthallenModel getInstance() {
		if(instance ==null) {
			instance =new SporthallenModel();
		}
		return instance;
	}
	
	public ArrayList<Sporthalle> getSporthallen(){
		return sporthallen;
	}
	public void leseSporthallenAusCsvDatei()
			throws IOException, PlausiException{
			BufferedReader ein = new BufferedReader(
		 		new FileReader("Sporthallen.csv"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
		           ergebnis.add( 
					new Sporthalle(zeile[0], zeile[1], zeile[2]));
		           zeileStr = ein.readLine();
			}    
		 	ein.close();
		 	this.sporthallen = ergebnis;
		}
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		observer.add(obs);
	}
	@Override
	public void removeObservre(Observer obs) {
		// TODO Auto-generated method stub
		observer.remove(obs);
	}
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Observer obs:observer) {
			obs.update();
		}
	}

}
