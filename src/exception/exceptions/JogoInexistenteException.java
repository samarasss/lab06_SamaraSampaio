package exception.exceptions;

public class JogoInexistenteException extends Exception {
	
	public JogoInexistenteException() {
		super("Jogo nao existe na biblioteca de jogos");
	}

}
