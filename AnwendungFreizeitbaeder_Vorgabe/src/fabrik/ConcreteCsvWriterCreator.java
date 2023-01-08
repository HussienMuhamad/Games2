package fabrik;

import java.io.IOException;

public class ConcreteCsvWriterCreator extends WriterCreator{

	@Override
	public WriterProduct factoryMethod() throws IOException {
		return new ConcreteCsvWriterProduct();
	}

}
