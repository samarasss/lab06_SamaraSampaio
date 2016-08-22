package usuario;

import jogo.Jogo;

/**
 * Subclasse de Usuario que contem metodos responsaveis pelo
 * comportamento de Usuarios Noob.
 * @author Samara Sonale Santos Sampaio
 */
public class Veterano extends Usuario {
	
	/** Construtor da classe que apenas chama o construtor da superclasse
	 */
	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
	}
	
	/**
	 * Metodo que recebe o objeto do jogo a ser comprado e verifica se o usuario
	 * pode compra-lo (se tem dinheiro o suficiente). Tambem adiciona 15 x2p ao usuario
	 * a cada 1 real do preco do jogo.
	 * @jogo recebe e calcula o preco com 20% de desconto.
	 * @return se a compra foi realizada com sucesso
	 */
	@Override
	public boolean compraJogo(Jogo jogo) {
		if(getDinheiro() > (jogo.getPreco() * 0.8)) {
			getJogosComprados().add(jogo);
			setDinheiro(getDinheiro() - (jogo.getPreco() * 0.8));
			setX2pTotal(getX2pTotal() + (jogo.getPreco().intValue() * 15));
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String texto = "";
		texto += getNome() + " - Jogador Veterano\nLista de Jogos:\n";
		return texto;
	}

}
