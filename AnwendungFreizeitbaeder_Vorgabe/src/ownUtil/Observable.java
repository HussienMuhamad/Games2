package ownUtil;

public interface Observable {
	
	public void addObserver(Observer obs);
	
	public void removeObservre(Observer obs);
	
	public void notifyObserver();
}	
