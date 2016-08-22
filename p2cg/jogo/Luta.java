package jogo;


import exceptions.ScoreInvalidoException;

/**
 * Subclasse de Jogo que contem metodos responsaveis pelo
 * comportamento de jogos de Luta.
 * @author Samara Sonale Santos Sampaio
 */
public class Luta extends Jogo {
	
	/** Construtor da classe que apenas chama o construtor da superclasse
	 */
	public Luta(String nome, double preco) throws Exception{
		super(nome, preco);
	}
	
	/** Chama o metodo da superclasse e o calculax2p de sua propria classe.
	 * @score se for maior que 100000, o maiorScore continuara 100000, visto que eh o valor maximo.
	 */
	
	@Override
	public int registraJogada(int score, boolean zerou) throws Exception {
		if((score) > 100000) {
			throw new ScoreInvalidoException();
		}
		int x2p = calculax2p(score, zerou);
		super.registraJogada(score, zerou);
		return x2p;
	}
	
	/** Metodo que calcula o x2p a ser retornado;
	 * @score se for maior que o maiorScore, o metodo retorna 1 para cada
	 * 1000 pontos de diferenca entre o score e o maiorScore. Se nao for maior,
	 * retorna zero.
	 */
	
	@Override
	public int calculax2p(int score, boolean zerou) {
		if(score > getMaiorScore()) {
			return score / 1000;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		String texto = String.format("+ %s - Luta\n", getNome());
		texto += super.toString();
		return texto;
	}
	
}
