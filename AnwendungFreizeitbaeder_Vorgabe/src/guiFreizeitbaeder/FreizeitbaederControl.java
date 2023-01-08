package guiFreizeitbaeder;

import java.io.IOException;


import business.FreizeitbaederModel;
import javafx.stage.Stage;
import ownUtil.Observer;


public class FreizeitbaederControl implements Observer{
	private FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel freizeitbaederModel;
	
	public FreizeitbaederControl (Stage primaryStage) {
		this.freizeitbaederModel=FreizeitbaederModel.getInstance();
		this.freizeitbaederView=new FreizeitbaederView(this, primaryStage, freizeitbaederModel);
		freizeitbaederModel.addObserver(this);
	}
	public void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				freizeitbaederModel.schreibFreizeitbaederInCsvDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Die Datei wurde gespeichert");
			}else if("txt".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Die Datei wurde gespeichert");
			}
			else {
				freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert");
			}
		}catch (IOException exc) {
			freizeitbaederView.zeigeFehlermeldungAn("IOEexception beim speichern");
		}catch (Exception exc) {
			freizeitbaederView.zeigeFehlermeldungAn("unbakannter Feahler beim Speichern");
			exc.printStackTrace();
		}
	}
	@Override
	public void update() {
		freizeitbaederView.zeigeFreizeitbaederAn();
		
	}

}
