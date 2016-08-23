package exception.exceptions;

public class NomeInvalidoException extends DadosInvalidosException {
	
	
	public NomeInvalidoException() {
		super("Nome nao pode ser null ou vazio");
	}
	
	public NomeInvalidoException(String mensagem) {
		super(mensagem);
	}
}
