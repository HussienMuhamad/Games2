package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import fabrik.ConcreteCsvWriterCreator;
import fabrik.ConcreteTxtWriterCreator;
import fabrik.WriterCreator;
import fabrik.WriterProduct;
import ownUtil.Observable;
import ownUtil.Observer;

public class FreizeitbaederModel implements Observable{
	//private Freizeitbad freizeitbad;
	private ArrayList<Freizeitbad> fzb = new ArrayList<>();
	private static FreizeitbaederModel instance;
	private ArrayList<Observer> os= new ArrayList<Observer>();
	private FreizeitbaederModel() {
		
	}
	public static FreizeitbaederModel getInstance() {
		if(instance ==null) {
			
			instance =new FreizeitbaederModel();
		}
		return instance;
	}
	
	

	
	public ArrayList<Freizeitbad> getFreizeitbad() {
		return this.fzb;
	}
	/*public void SetFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad=freizeitbad;
		notifyObserver();
	}*/
	
	public void addFreizeitbad(Freizeitbad freizeitbad) {
		fzb.add(freizeitbad);
		notifyObserver();
	}
	
	public void schreibFreizeitbaederInCsvDatei() throws IOException {
		WriterCreator writerCreator=new ConcreteCsvWriterCreator();
		
		WriterProduct writer=writerCreator.factoryMethod();
		for(Freizeitbad fzb:this.getFreizeitbad()) {
		writer.fuegeInDateiHinzu(fzb);
		//writer.schliesseDatei();
		}
		writer.schliesseDatei();
		
	}
	public void schreibeFreizeitbaederInTxtDatei() throws IOException{
		
		WriterCreator writerCreator=new ConcreteTxtWriterCreator();
		
		WriterProduct writer=writerCreator.factoryMethod();
		for(Freizeitbad fzb:this.getFreizeitbad()) {
		writer.fuegeInDateiHinzu(fzb);
		//writer.schliesseDatei();
		}
		writer.schliesseDatei();
		
	}




	@Override
	public void addObserver(Observer obs) {
		os.add(obs);
		
	}




	@Override
	public void removeObservre(Observer obs) {
		os.remove(obs);
		
	}




	@Override
	public void notifyObserver() {
		for(Observer obs:os) {
			obs.update();
		}
		
	}
}
