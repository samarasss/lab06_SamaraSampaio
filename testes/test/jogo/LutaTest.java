package test.jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Luta;

public class LutaTest {
	private Jogo mortalKombat;
	
	@Before
	public void criaJogo() throws Exception {
		mortalKombat = new Luta("Mortal Kombat", 100);
	}
	

	@Test
	public void testConstrutor() {
		try { // nome null
			Jogo nomeInvalido = new Luta(null, 100);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser null ou vazio", e.getMessage());
		}
		
		try { // nome vazio
			Jogo nomeVazio = new Luta("", 100);
		} catch(Exception e) {
			assertEquals("Nome nao pode ser null ou vazio", e.getMessage());
		}
		
		try { // preco negativo
			Jogo precoNegativo = new Luta("Preco Negativo", -1);
		} catch (Exception e) {
			assertEquals("Valor invalido", e.getMessage());
		}
	}
	
	@Test
	public void testRegistraJogada() {
		
		try {
			assertEquals(7, mortalKombat.registraJogada(7000, false));
			assertEquals(0, mortalKombat.registraJogada(5000, true));
			assertEquals(3, mortalKombat.registraJogada(10000, false));
			assertEquals(0, mortalKombat.registraJogada(9000, true));
			assertEquals(10000, mortalKombat.getMaiorScore());
			assertEquals(2, mortalKombat.getQuantidadeVezesZerada());
			assertEquals(4, mortalKombat.getQuantidadeJogada());
		} catch(Exception e) {
			fail();
		}
		
		try {
			assertEquals(50, mortalKombat.registraJogada(120000, false));
			fail();
		} catch(Exception e) {
			assertEquals("Score nao pode ser maior do que 100000", e.getMessage());
		}
	}

}
