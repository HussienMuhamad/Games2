package fabrik;

import java.io.IOException;

public abstract class WriterProduct {
	public abstract void fuegeInDateiHinzu(Object object) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
}
