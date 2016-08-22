package jogo;

/**
 * Subclasse de Jogo que contem metodos responsaveis pelo
 * comportamento de jogos de Plataforma.
 * @author Samara Sonale Santos Sampaio
 */
public class Plataforma extends Jogo {

	/** Construtor da classe que apenas chama o construtor da superclasse
	 */
	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	/** Chama o metodo da superclasse e o calculax2p de sua propria classe.
	 */
	@Override
	public int registraJogada(int score, boolean zerou) throws Exception {
		super.registraJogada(score, zerou);
		return calculax2p(score, zerou);
	}
	
	/** Metodo que calcula o x2p a ser retornado;
	 * @zerou se for [true], retorna 20. 
	 */
	@Override
	public int calculax2p(int score, boolean zerou) {
		if(zerou) {
			return 20;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		String texto = String.format("+ %s - Plataforma\n", getNome());
		texto += super.toString();
		return texto;
	}

}
