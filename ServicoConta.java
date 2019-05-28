package interfaceConsole;

import dados.RepositorioConta;
import entidades.ETipoConta;
import entidades.Pessoa;
import entidades.pessoaConta;


public class ServicoConta {

	private RepositorioConta repositorio;
	
	public ServicoConta(){
		//Construtor inicializando o repositorio
		repositorio = new RepositorioConta();
	}
	public int criarConta(String nome, ETipoConta tipoConta){
		validaNome(nome);
		
		//Cria a conta com nome e tipo
		pessoaConta conta = new pessoaConta();
		conta.setNomep(nome);
	
		
		//Salva a conta no repositório
		return repositorio.salvar(conta);
	}
	public void alterarDadosCadastrais(int conta, String nome){
		validaNumeroConta(conta);
		validaNome(nome);
		
		//recupera a conta com o id
		pessoaConta c = repositorio.get(conta);
		
		//altera o nome
		c.setNomep(nome);;
		
		//grava as alterações
		repositorio.salvar(c);
	}
	public void depositar(int conta, double valor){
		validaNumeroConta(conta);
		validaValor(valor);
		
		//recupera a conta
		pessoaConta c = repositorio.get(conta);
		
		//altera o saldo
		c.setSaldo(c.getSaldo() + valor);

		//grava as alterações
		repositorio.salvar(c);
	}
	public void sacar(int conta, double valor){
		validaNumeroConta(conta);
		validaValor(valor);

		//recupera a conta
		pessoaConta c = repositorio.get(conta);
		
		//valida o saldo da conta
		validaSaldo(c,valor);
		
		//altera o saldo
		c.setSaldo(c.getSaldo() - valor);
		
		//grava as alterações
		repositorio.salvar(c);
	}
	public void transferir(int conta, int contaFavorecida, double valor){
		validaNumeroConta(conta);
		validaNumeroConta(contaFavorecida);
		validaValor(valor);

		//recupera as contas
		pessoaConta conta1 = repositorio.get(conta);
		pessoaConta favorecida = repositorio.get(contaFavorecida);

		//valida o saldo da conta
		validaSaldo(conta1,valor);

		//altera o saldo
		conta1.setSaldo(conta1.getSaldo() - valor);
		favorecida.setSaldo(favorecida.getSaldo() + valor);

		//grava as alterações nas duas contas
		repositorio.salvar(conta1);
		repositorio.salvar(favorecida);
	}
	public Pessoa recuperar(int conta) {
		validaNumeroConta(conta);
		//recupera uma conta específica
		return Pessoa.get(conta);
	}
	
	private void validaNome(String nome) {
		if(nome == null || nome.isEmpty()){
			throw new RuntimeException("Nome inválido");			
		}
	}
	private void validaNumeroConta(int conta) {
		if(conta <= 0) {
			throw new RuntimeException("Número de conta inválido");
		}
	}
	private void validaValor(double valor) {
		if(valor <= 0){
			throw new RuntimeException("Valor inválido");			
		}
	}
	private void validaSaldo(pessoaConta conta, double valor) {
		if(conta.getSaldo() < valor) {
			throw new RuntimeException("Saldo insuficiente");
		}
	}
	public void devolverlivro(int contaPessoa, Object object) {
		// TODO Auto-generated method stub
		
	}
	public void pegarLivro(int contaPessoa, Object object) {
		// TODO Auto-generated method stub
		
	}
}
