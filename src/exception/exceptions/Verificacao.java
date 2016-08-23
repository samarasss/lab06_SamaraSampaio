package exception.exceptions;

public class Verificacao {
	
	public void verificaTexto(String texto) throws DadosInvalidosException {
		if(texto == null || texto.trim().equals(""));
			throw new NomeInvalidoException();
	}
	

	
	
	
}
