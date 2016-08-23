package jogo;

import java.util.HashSet;

import exception.exceptions.NomeInvalidoException;
import exception.exceptions.ValorInvalidoException;


/**
 * Classe responsavel por abstrair os atributos e metodos usados nas
 * classes Luta, Plataforma e RPG.
 * @author Samara Sonale Santos Sampaio
 */
public abstract class Jogo {
	private String nome;
	private double preco;
	private int maiorScore;
	private int qntJogada;
	private int qntZerada;
	private HashSet<Jogabilidade> jogabilidade;
	
	 /** Construtor que recebe nome e preco, atribui 0 as variaveis maiorScore, quantidade de vezes que o jogo
	 * foi jogado, quantidade de vezes que o jogo foi zerado e cria um nova colecao que guarda seu estilo de jogabilidade.
	 * @param nome recebe o nome 
	 * @param preco recebe o preco
	 * 	 @throws Exception caso o nome seja null ou vazio e caso o preco for negativo.
	 */
	
	public Jogo (String nome, double preco) throws Exception, NomeInvalidoException, ValorInvalidoException {
		
		if(nome == null || nome.trim().isEmpty()){
			throw new NomeInvalidoException();
		}
		
		if(preco < 0) {
			throw new ValorInvalidoException();
		}
		
		this.nome = nome;
		this.preco = preco;
	
		maiorScore = 0;
		qntJogada = 0;
		qntZerada = 0;
		jogabilidade = new HashSet<Jogabilidade>();	
	}
	
	/**
	 * Metodo que adiciona um novo estilo de jogo e o adiciona na lista de estilos do objeto
	 * @param estilo recebe o estilo de jogabilidade a ser adicionado na lista
	 * de estilos do jogo.
	 */
	
	public void addJogabilidade (Jogabilidade estilo) {
		jogabilidade.add(estilo);
	}
	
	/**
	 * Metodo que registra a jogada, verifica se o score eh o novo maiorScore e caso tenha
	 * zerado o jogo, incrementa a variavel quantZerada.
	 * @param score se for maior que o maiorScore do jogo, se torna o maiorScore
	 * @param zerou se for [true], aumenta a variavel quantZerada
	 * @throws caso o score for negativo
	 * @return
	 */

	public int registraJogada(int score, boolean zerou) throws Exception {
		
		if(score < 0) {
			throw new ValorInvalidoException();
		}
		if(score > maiorScore) {
			maiorScore = score;
		}
		if(zerou) {
			qntZerada += 1;
		}
		qntJogada += 1;
		return 0;
	}
	
	public abstract int calculax2p(int score, boolean zerou);
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getMaiorScore() {
		return maiorScore;
	}
	
	public void setMaiorScore(int novoScore) {
		this.maiorScore = novoScore;
	}
	
	public HashSet<Jogabilidade> getJogabilidade() {
		return jogabilidade;
	}
	
	public int getQuantidadeVezesZerada() {
		return qntZerada;
	}
	
	public int getQuantidadeJogada() {
		return qntJogada;
	}
	
	/** Metodo que retorna uma String com a quantidade de vezes jogadas,
	 * a quantidade de vezes zeradas e o maior Score no jogo.
	 */
	
	@Override
	public String toString() {
		
		String texto = "";
		texto += "==> Jogou " + qntJogada + " vez(es)\n";
		texto += "==> Zerou " + qntZerada + " vez(es)\n";
		texto += "==> Maior score: " + maiorScore + "n";
		return texto;
	}
	
	/** Hashcode que funciona a partir dos mesmo atributos do Equals.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/** Equals que define se dois objetos do tipo Jogo sao iguais se
	 * ambos tiverem o mesmo nome e mesmo preco.
	 */

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Jogo) {
			Jogo outroJogo = (Jogo) obj;
			if(nome.equals(outroJogo.getNome()) && preco == outroJogo.getPreco()) {
				return true;
			}
		}
		return false;
	}
	
}
