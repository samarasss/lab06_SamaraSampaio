package usuario;

import jogo.Jogo;
import exception.exceptions.DinheiroInsuficienteException;
import exception.exceptions.JogoJaExisteException;

/**
 * Subclasse de Usuario que contem metodos responsaveis pelo
 * comportamento de Usuarios Noob.
 * @author Samara Sonale Santos Sampaio
 */
public class Noob extends Usuario {
	
	/** Construtor da classe que apenas chama o construtor da superclasse
	 * 
	 */
	
	public Noob(String nome, String login) throws Exception {
		super(nome, login);
	}
	
	/**
	 * Metodo que recebe o objeto do jogo a ser comprado e verifica se o usuario
	 * pode compra-lo. Tambem adiciona 10 x2p ao usuario a cada 1 real do preco do jogo.
	 * @jogo recebe e calcula o preco com 10% de desconto
	 * @return se a compra foi realizada 
	 */
	
	@Override
	
	public boolean compraJogo(Jogo game) throws Exception {
	
		if(!getJogosComprados().contains(game)) {
			if(getDinheiro() > (game.getPreco() * 0.9)) {
				getJogosComprados().add(game);
				setDinheiro(getDinheiro() - (game.getPreco() * 0.9));
				setX2pTotal(getX2pTotal() + (game.getPreco().intValue() * 10));
				return true;
			}
			throw new DinheiroInsuficienteException();
		}
		throw new JogoJaExisteException();
	}
	
	/**
	 * Metodo que cria uma String com o nome do Usuario, sua lista de jogos e retorna essa String.
	 */
	
	@Override
	public String toString() {
		String texto = "";
		texto += getNome() + "- Jogador Noob\nLista de Jogos:\n";
		return texto;
	}

}
