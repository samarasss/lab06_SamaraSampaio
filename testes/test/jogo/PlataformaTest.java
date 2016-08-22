package test.jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Plataforma;

public class PlataformaTest {
	private Jogo raymanLegends;
	
	@Before
	public void criaJogo() throws Exception {
		raymanLegends = new Plataforma("Rayman Legends", 50);
	}
	
	@Test
	public void testRegistraJogada() {
		try {
			assertEquals(0, raymanLegends.registraJogada(5000, false));
			assertEquals(20, raymanLegends.registraJogada(4000, true));
			assertNotEquals(20, raymanLegends.registraJogada(4000, false));
		} catch(Exception e) {
			fail();
		}	
	}

}
