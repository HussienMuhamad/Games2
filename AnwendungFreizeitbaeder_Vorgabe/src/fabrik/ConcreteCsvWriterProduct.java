package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct{
		BufferedWriter write;
		public ConcreteCsvWriterProduct() throws IOException {
			write=new BufferedWriter(new FileWriter("Freizeitbaeder.csv"));
		}
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		//write =new BufferedWriter(new FileWriter("Freizeitbaeder.csv"));
		
		write.write(((Freizeitbad)object).gibFreizeitbadZurueck(';'));
		write.write("\n");
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		write.flush();
		write.close();
		
	}

}
