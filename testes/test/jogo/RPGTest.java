package test.jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.RPG;

public class RPGTest {
	private Jogo theWitcher;
	
	@Before
	public void criaJogo() throws Exception {
		theWitcher = new RPG("The Witcher", 100);
	}
	
	@Test
	public void testRegistraJogada() {
		try {
			assertEquals(10, theWitcher.registraJogada(2000, true));
			assertEquals(10, theWitcher.registraJogada(5000, false));
			assertEquals(10, theWitcher.registraJogada(10000, true));
			assertNotEquals(20, theWitcher.registraJogada(3000, false));
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testAddJogabilidade() {
		try {
			theWitcher.addJogabilidade(Jogabilidade.OFFLINE);
			theWitcher.addJogabilidade(Jogabilidade.COOPERATIVO);
			assertEquals(2, theWitcher.getJogabilidade().size());
		} catch(Exception e) {
			fail();
		}
	}

}
