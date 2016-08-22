package test.usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;
import usuario.Usuario;
import usuario.Veterano;

public class VeteranoTest {
	private Usuario samara;
	private Jogo mortalKombat;
	private Jogo theWitcher;
	private Jogo raymanLegends;
	
	@Before
	public void criaUsuarioEJogos() throws Exception {
		samara = new Veterano("Samara");
		mortalKombat = new Luta("Mortal Kombat", 100);
		theWitcher = new RPG("The Witcher", 100);
		raymanLegends = new Plataforma("Rayman Legends", 50);
	}

	@Test
	public void testCompraJogo() {
		try {
			samara.adicionaDinheiro(250);
			
			samara.compraJogo(mortalKombat);
			samara.compraJogo(raymanLegends);
			samara.compraJogo(theWitcher);
			
			assertEquals(50,00, samara.getDinheiro());
			assertEquals(3750, samara.getX2pTotal()); 
		} catch(Exception e) {
			fail();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
