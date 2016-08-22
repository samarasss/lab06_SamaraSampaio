package test.usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;
import usuario.Noob;
import usuario.Usuario;

public class NoobTest {
	private Usuario samara;
	private Jogo mortalKombat;
	private Jogo theWitcher;
	private Jogo raymanLegends;
	
	@Before
	public void criaUsuarioEJogos() throws Exception {
		samara = new Noob("Samara");
		mortalKombat = new Luta("Mortal Kombat", 100);
		theWitcher = new RPG("The Witcher", 100);
		raymanLegends = new Plataforma("Rayman Legends", 50);
	}

	@Test
	public void testCompraJogo() {
		try {
			samara.adicionaDinheiro(100);
			samara.compraJogo(mortalKombat);
			
			assertEquals(0,0, samara.getDinheiro());
			assertEquals(1, samara.getJogosComprados().size());
			assertEquals(1000, samara.getX2pTotal());
			
			samara.adicionaDinheiro(50);
			samara.compraJogo(raymanLegends);
			
			assertEquals(1500, samara.getX2pTotal());
			assertEquals(15,00, samara.getDinheiro()); // 150 - 90 - 45 (10% de desconto) = 15
		} catch(Exception e) {
			fail();
		}
		
		try {
			samara.compraJogo(theWitcher);
			fail();
		} catch(Exception e) {
			assertEquals("Dinheiro insuficiente para a compra do jogo", e.getMessage());
		}
		
		try {
			samara.compraJogo(raymanLegends);
			fail();
		} catch(Exception e) {
			assertEquals("Jogo ja existe na biblioteca", e.getMessage());
		}
	}

	@Test
	public void testNoob() {
		try {
			Usuario nomeVazio = new Noob("");
		} catch(Exception e) {
			assertEquals("Nome nao pode ser null ou vazio", e.getMessage());
		}
		
		try {
			Usuario nomeNull = new Noob(null);
		} catch(Exception e){
			assertEquals("Nome nao pode ser null ou vazio", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogada() {
		try {
			samara.adicionaDinheiro(250);
			
			samara.compraJogo(theWitcher);
			samara.compraJogo(mortalKombat);
			samara.compraJogo(raymanLegends);
			
			samara.registraJogada("Rayman Legends", 5000, false); 
			assertEquals(2500, samara.getX2pTotal());
			samara.registraJogada("Rayman Legends", 7000, true); 
			assertEquals(2520, samara.getX2pTotal());
			samara.registraJogada("The Witcher", 1000, false); 
			assertEquals(2530, samara.getX2pTotal());
			samara.registraJogada("Mortal Kombat", 20000, false);
			assertEquals(2550, samara.getX2pTotal());
			samara.registraJogada("Mortal Kombat", 10000, false);
			assertEquals(2550, samara.getX2pTotal());
			samara.registraJogada("Mortal Kombat", 30000, false); 
			assertEquals(2580, samara.getX2pTotal());
			
		} catch(Exception e) {
			fail();
		}	
		
	}

	@Test
	public void testExisteJogo() {
		try {
			samara.registraJogada("Rayman Legends", 1000, false);
			fail();
		} catch(Exception e) {
			assertEquals("Jogo nao existe na biblioteca de jogos", e.getMessage());
		}
	}

	@Test
	public void testCalculaPreco() {
		try {
			samara.adicionaDinheiro(250);
			
			samara.compraJogo(theWitcher);
			samara.compraJogo(mortalKombat);
			samara.compraJogo(raymanLegends);
			
			assertEquals(250,00, samara.calculaPreco());
			
		} catch(Exception e) {
			fail();
		}
	}

	@Test
	public void testEqualsObject() {
		try {
			samara.adicionaDinheiro(100);
			samara.compraJogo(theWitcher);
			
			Usuario samaras = new Noob("Samara");
			samaras.adicionaDinheiro(10);
			
			assertEquals(true, samara.equals(samaras));
			
		} catch(Exception e) {
			fail();
		}
	}

}
