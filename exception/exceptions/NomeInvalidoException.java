package exceptions;

public class NomeInvalidoException extends DadosInvalidosException {
	private static final long serialVersionUID = 1L;
	
	public NomeInvalidoException() {
		super("Nome nao pode ser null ou vazio");
	}
	
	public NomeInvalidoException(String mensagem) {
		super(mensagem);
	}
}
