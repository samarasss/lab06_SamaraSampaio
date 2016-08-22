package exceptions;

public class ScoreInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ScoreInvalidoException() {
		super("Score nao pode ser maior do que 100000");
		}
}
