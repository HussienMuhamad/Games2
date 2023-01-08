package guiSportstaetten;

import business.FreizeitbaederModel;
import business.SporthallenModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class SportstaettenControl implements Observer{
		private SportstaettenView sw;
		private FreizeitbaederModel fbm;
		private SporthallenModel spM;
		
		
		public SportstaettenControl (Stage primaryStage) {
			
			this.fbm= FreizeitbaederModel.getInstance();
			this.spM= SporthallenModel.getInstance();
			this.sw=new SportstaettenView(primaryStage, this, fbm,spM);
			this.fbm.addObserver(this);
			this.spM.addObserver(this);
		}


		@Override
		public void update() {
			sw.zeigeFreizeitbaederAn();
			
		}
}
