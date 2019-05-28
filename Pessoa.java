package entidades;

public class Pessoa {
	// Atributos
	public int id;
	public int maxLivros; // numero max de livros que a pessoa pode emprestar
	public ETipoConta PessoaConta;
	public String nome; // nome da pessoa
	
	
	public ETipoConta getPessoaConta() {
		return PessoaConta;
	}
	public void setPessoaConta(ETipoConta pessoaConta) {
		PessoaConta = pessoaConta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMaxLivros() {
		return maxLivros;
	}
	public void setMaxLivros(int maxLivros) {
		this.maxLivros = maxLivros;
	}
	public static Pessoa get(int conta) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
