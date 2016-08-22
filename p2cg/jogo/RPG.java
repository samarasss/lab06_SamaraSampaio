package jogo;

/**
 * Subclasse de Jogo que contem metodos responsaveis pelo
 * comportamento de jogos de RPG.
 * @author Samara Sonale Santos Sampaio
 */
public class RPG extends Jogo {
	
	/** Construtor da classe que apenas chama o construtor da superclasse 
	 */
	public RPG(String nome, double preco) throws Exception {
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
	 * Retorna sempre 10.
	 */
	@Override
	public int calculax2p(int score, boolean zerou) {
		return 10;
	}
	
	@Override
	public String toString() {
		String texto = String.format("+ %s - RPG\n", getNome());
		texto += super.toString();
		return texto;
	}

}
