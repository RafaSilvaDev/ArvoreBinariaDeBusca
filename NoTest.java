import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoTest {

	@Test
	void deveRetornarEhFolhaSoFilhoDireito() {
		
		No noUm = new No(1, null, null);
		No noDois = new No(2, noUm, null);
		assertTrue(noUm.ehFolha());
		assertFalse(noDois.ehFolha());
	
	}
	
	@Test
	void deveRetornarEhFolhaDoisFilhos() {
		
		No noUm = new No(1, null, null);
		No noTres = new No(3, null, null);
		No noDois = new No(2, noUm, noTres);
		assertTrue(noUm.ehFolha());
		assertTrue(noTres.ehFolha());
		assertFalse(noDois.ehFolha());
	
	}

}
