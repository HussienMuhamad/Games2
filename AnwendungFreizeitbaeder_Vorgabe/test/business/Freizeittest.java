package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Freizeittest {
	Freizeitbad fzb;
	@BeforeEach
	void setUp() throws Exception {
		fzb = new Freizeitbad("Stadtbad", "7.00", "17.00", "25", "24");
	}

	/*@AfterEach
	void tearDown() throws Exception {
	}*/

	@Test
	void test() {
		Assertions.assertTrue(() ->this.fzb.getBeckenlaenge()==25, "Das Ergebnis");
	}

}
