package entidades;



public class pessoaConta {

	public int id;
	public ETipoConta PessoaConta;
	public double Emprestimo;
	public String nomep;
	public double saldo;
	
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ETipoConta getPessoaConta() {
		return PessoaConta;
	}
	public void setPessoaConta(ETipoConta pessoaConta) {
		PessoaConta = pessoaConta;
	}
	public double getEmprestimo() {
		return Emprestimo;
	}
	public void setEmprestimo(double pessoaConta2) {
		Emprestimo = pessoaConta2;
	}
	
	
	public String getNomep() {
		return nomep;
	}
	public void setNomep(String nomep) {
		this.nomep = nomep;
	}
	
}

