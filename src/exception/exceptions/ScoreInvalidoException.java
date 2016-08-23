package exception.exceptions;

public class ScoreInvalidoException extends Exception {

	
	public ScoreInvalidoException() {
		super("Score nao pode ser maior do que 100000");
		}
}
