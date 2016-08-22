package exceptions;

public class ValorInvalidoException extends DadosInvalidosException {
	private static final long serialVersionUID = 1L;
	
	public ValorInvalidoException() {
		super("Valor invalido");
		}
}
