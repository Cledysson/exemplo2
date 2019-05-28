package interfaceConsole;

import java.util.Scanner;
import dados.RepositorioConta;

import entidades.ETipoConta;
import entidades.Pessoa;
import entidades.pessoaConta;

public class App {
		
	public static void main(String[] args) {
		ServicoConta servico = new ServicoConta();
		Scanner scanner = new Scanner(System.in);
	

		int i = 0;

		while (i != 7) {
			menu();

			i = Integer.parseInt(scanner.nextLine());
			try {
				switch (i) {
				case 1:
					// Criar uma Conta NovaPessoa
					criarConta(servico, scanner);
					break;
				case 2:
					// Alterar uma Pessoa
					alterarCadastro(servico, scanner);
					break;
				case 3:
					// Deletar uma Pessoa
					deletarCadastro(servico, scanner);
					break;
				case 4:
					// Pegar um Livro
					pegarLivro(servico, scanner);
					break;
				case 5:
					// Emprestimo de Livro
					emprestimodeLivro(servico, scanner);
					break;
				case 6:
					// Devolução de Livro
					devolverLivro(servico, scanner);
					break;
				case 7:
					// sair
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	private static void menu() {
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Criar Conta Pessoa");
		System.out.println("2 - Alterar Cadastro");
		System.out.println("3 - Deletar Cadastro");
		System.out.println("4 - Pegar Livro");
		System.out.println("5 - Emprestimo de Livro");
		System.out.println("6 - Devolver Livro");
		System.out.println("7 - Sair");
	}

	
	private static void alterarCadastro(ServicoConta servico, Scanner scanner) {
		System.out.println("Qual Cadastro Deseja Alterar?");
		int conta = Integer.parseInt(scanner.nextLine());
		System.out.println("Informe qual o Novo Nome para o Cadastro");
		String nome = scanner.nextLine();
		servico.alterarDadosCadastrais(conta, nome);
	}

	private static void deletarCadastro(ServicoConta servico, Scanner scanner) {
		System.out.println("Deletar o Cadastro");
		int contaPessoa = Integer.parseInt(scanner.nextLine());
		System.out.println("Deletar o Cadastro com Id");
		int contaEscolhida = Integer.parseInt(scanner.nextLine());
		System.out.println("Informe qual Id deseja Deletar");
		double valor = Double.parseDouble(scanner.nextLine());
		servico.transferir(contaPessoa, contaEscolhida, valor);
	}

	private static void pegarLivro(ServicoConta servico, Scanner scanner) {
		System.out.println("Quantos Livros deseja alocar?");
		int contaPessoa = Integer.parseInt(scanner.nextLine());
		
		servico.pegarLivro(contaPessoa, null);
	}

	private static void emprestimodeLivro(ServicoConta servico, Scanner scanner) {
		System.out.println("Veja a Conta para Emprestimo dos Livros");
		int conta = Integer.parseInt(scanner.nextLine());
		
		Pessoa p = servico.recuperar(conta);
		System.out.println("Pessoa: " + p.getNome());
		System.out.println("conta: " + p.getId());

	}

	private static void devolverLivro(ServicoConta servico, Scanner scanner) {
		System.out.println("quantos livros serão devolvidos?");
		int contaPessoa = Integer.parseInt(scanner.nextLine());
		servico.devolverlivro(contaPessoa, null);
	}

	private static void criarConta(ServicoConta servico, Scanner scanner) {
		System.out.println("Informe o nome da Pessoa");
		String nome = scanner.nextLine();
		
		ETipoConta tipo = null;
		
		while (tipo == null) {
			System.out.println("Informe o tipo de conta (p)pessoa ou (l)livro");
			String s = scanner.nextLine();
			if (s.equalsIgnoreCase("p")) {
				tipo = ETipoConta.pessoa;
			}
			if (s.equalsIgnoreCase("l")) {
				tipo = ETipoConta.livro;
			}
		}
		
		int novaConta = servico.criarConta(nome, tipo);
		System.out.println("A nova conta possui id igual a " + novaConta);
	}
}
