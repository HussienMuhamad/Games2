package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtWriterProduct extends WriterProduct {
		BufferedWriter writer;
	public ConcreteTxtWriterProduct() throws IOException {
			writer=new BufferedWriter(new FileWriter("Freizeitbaeder.txt"));
		}
	@Override
	
	public void fuegeInDateiHinzu(Object object) throws IOException {
			Freizeitbad bad=(Freizeitbad)object;
			//writer=new BufferedWriter(new FileWriter("Freizeitbaeder.txt"));
			writer.write("Daten des Freizeitbades\n"
					+"Name des Freizeitbads:\t\t\t"+bad.getName()
					+"\n÷ffnungzeit des Freizeitbads:\t"+bad.getGeoeffnetVon()+"_"+bad.getGeoeffnetBis()
					+"\nBeckenl‰nge des Freizeitbads:\t"+bad.getBeckenlaenge()
					+"\nWassertemperatur des Freizeitbads:"+bad.getTemperatur()+"\n");
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		writer.flush();
		writer.close();
		
	}

}
