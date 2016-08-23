package usuario;

import java.util.ArrayList;

import jogo.Jogo;
import exception.exceptions.JogoInexistenteException;
import exception.exceptions.NomeInvalidoException;
import exception.exceptions.ValorInvalidoException;

/** Classe responsavel por abstrair os atributos e metodos inerentes as
 * classes Noob e Veterano.
 *  @author Samara Sonale Santos Sampaio
 */
public abstract class Usuario {
	
	private String nome;
	private String login;
	private ArrayList<Jogo> jogosComprados;
	private double dinheiro;
	private int x2pTotal;
	
	/**
	 * Construtor que recebe um nome, cria um ArrayList vazia de jogosComprados e atribui zero
	 * a quantidade de dinheiro disponivel e ao x2pTotal.
	 * @param nome recebe o nome o atribui a variavel do objeto.
	 */
	
	public Usuario(String nome, String login) throws Exception {
		
		if(nome == null || nome.trim().equals("")) {
			throw new NomeInvalidoException();
		}
		
		this.nome = nome;
		jogosComprados = new ArrayList<Jogo>();
		dinheiro = 0;
		x2pTotal = 0;
	}
	
	public abstract boolean compraJogo(Jogo game) throws Exception;
	
	/** Metodo que registra a jogada, chamando o metodo homonimo referente ao nome do jogo
	 * recebido (caso exista) e atribui a quantidade de x2p retornada a variavel x2ptotal.
	 * @param nomeJogo recebe o nome e verifica se o mesmo eh valido.
	 * @return [true] se a jogada foi registrada com sucesso.
	 * @throws Exception caso nome recebido seja invalido ou caso nao exista um.
	 * jogo com o nome recebido na lista de Jogos do usuario.
	 */
	
	public boolean registraJogada(String nomeJogo, int score, boolean zerou)  throws Exception {
		if(nomeJogo == null || nomeJogo.trim().equals("")) {
			throw new NomeInvalidoException();
		}
		setX2pTotal(getX2pTotal() + existeJogo(nomeJogo).registraJogada(score, zerou));
		return true;
	}
	
	/** Metodo que percorre na lista de jogos do usuario por um jogo que tenha
	 * o mesmo nome que o nome recebido como parametro.
	 * @param nomeJogo recebe o nome a ser verificado.
	 * @return o objeto do tipo Jogo encontrado.
	 * @throws Exception caso nao exista um jogo com o nome especificado.
	 */

	public Jogo existeJogo(String nomeJogo) throws Exception {
		for(Jogo jogo: getJogosComprados()) {
			if(nomeJogo.equals(jogo.getNome())) {
				return jogo;
			}
		}
		throw new JogoInexistenteException();
	}
	
	/** Metodo que percorre toda a lista de jogosComprados e guarda
	 * o preco de cada um.
	 * @return a soma do preco de todos os jogos.
	 */
	public double calculaPreco() {
		double total = 0;
		for(Jogo jogo: jogosComprados) {
			total += jogo.getPreco();
		}
		return total;
	}
	
	public boolean adicionaDinheiro(double quantia) throws Exception {
		if(quantia < 0) {
			throw new ValorInvalidoException();
		}
		this.dinheiro = dinheiro + quantia;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Jogo> getJogosComprados() {
		return jogosComprados;
	}

	public void setJogosComprados(ArrayList<Jogo> jogosComprados) {
		this.jogosComprados = jogosComprados;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public int getX2pTotal() {
		return x2pTotal;
	}

	public void setX2pTotal(int x2pTotal) {
		this.x2pTotal = x2pTotal;
	}
	
	@Override
	public String toString() {
		String texto = "";
		for(Jogo jogo: getJogosComprados()) {
			texto += jogo;
		}
		texto += "Total de preco dos Jogos: R$" + calculaPreco();
		return texto;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(dinheiro);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Usuario) {
			Usuario outroUsuario = (Usuario) obj;
			if(nome.equals(outroUsuario.getNome()) && dinheiro == outroUsuario.getDinheiro()) {
				return true;
			}
		}
		return false;
	}

	
}
