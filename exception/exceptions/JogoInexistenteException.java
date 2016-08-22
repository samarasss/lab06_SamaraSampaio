package exceptions;

public class JogoInexistenteException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public JogoInexistenteException() {
		super("Jogo nao existe na biblioteca de jogos");
	}

}
