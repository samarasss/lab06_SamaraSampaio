package lab6;

import java.util.HashSet;

/**
 * 
 * @author Samara Sonale Santos Sampaio
 *
 */


public class Jogo {

	
	private String nome;
	private double preco;
	private int maiorScore;
	private int qntJogou;
	private int qntZerou;
	private HashSet jogabilidade;
	
	
/**
 * O construdor do jogo eh formado pelo nome e preco
 * @param nome
 * @param preco
 * @throws Exception
 */
	public Jogo(String nome, double preco) throws Exception{
		
		if (nome == null || nome.trim().isEmpty()){
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}
		if (preco < 0){
			throw new Exception("Preco nao pode ser negativo");
		}
		
		nome = this.nome;
		preco = this.preco;
		
		jogabilidade = new HashSet<Jogabilidade>();
		
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getQntJogou() {
		return qntJogou;
	}

	public void setQntJogou(int qntJogou) {
		this.qntJogou = qntJogou;
	}

	public int getQntZerou() {
		return qntZerou;
	}

	public void setQntZerou(int qntZerou) {
		this.qntZerou = qntZerou;
	}
/**
 * O metodo esta registando a quantidade de vezes que o usuario jogou. Comparando qual eh o maior score para atualiza-lo.
 * Tambem esta incrementando a quantidade de vezes que o jogo foi gerado
 * @param score
 * @param zerou
 */
	public void registraJogada(int score, boolean zerou){
		
		setQntJogou(getQntJogou()+1);
		
		if(score > getMaiorScore()){
			setMaiorScore(score) ;
		}
		
		if (zerou == true){
			setQntZerou(getQntZerou()+1);
		}
		
	}
	
	public String toString(){
		final String FIM_LINHA = System.lineSeparator();
		return "O nome do jogo eh " + this.nome + ". " + "Custa R$ " + this.preco + "." + FIM_LINHA
				+ "O usuario jogou " + qntJogou + "vezes." + FIM_LINHA
				+ "Zerou " + qntZerou + "vezes. Obtendo score de " + maiorScore;
							
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maiorScore;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qntJogou;
		result = prime * result + qntZerou;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo){
			Jogo outroJogo = (Jogo) obj;
			if (this.getNome().equalsIgnoreCase(outroJogo.getNome())){
				return true;
			}
		}
		return false;
		
	}
	
	public void adicionaJogabilidade(Jogabilidade jogabilidade){
		
		this.jogabilidade.add(jogabilidade);
	}
	
	public void removeJogabilidade(Jogabilidade jogabilidade){
		
		this.jogabilidade.remove(jogabilidade);
	}
	

}

