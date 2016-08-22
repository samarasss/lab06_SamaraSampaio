package exceptions;

public class JogoJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	
		public JogoJaExisteException() {
			super("Jogo ja existe na biblioteca");
		}
}

