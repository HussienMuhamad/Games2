package fabrik;

import java.io.IOException;

public class ConcreteTxtWriterCreator extends WriterCreator{

	@Override
	public WriterProduct factoryMethod() throws IOException {
		return new ConcreteTxtWriterProduct();
	}

}
