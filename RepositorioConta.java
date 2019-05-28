package dados;

import java.util.ArrayList;
import java.util.List;

import entidades.pessoaConta;

public class RepositorioConta {
	List<pessoaConta> contas;
	
	public RepositorioConta(){
		
		contas = new ArrayList<pessoaConta>();
	}
	public pessoaConta get(int id) {
		for (pessoaConta conta : contas) {
		
			if (conta.getId() == id){
		
				return conta;
			}
		}
		
		throw new RuntimeException("Conta não encontrada");
	}
	public List<pessoaConta> list(){
		
		return contas;
	}
	public int salvar(pessoaConta conta) {
		if(conta.getId() == 0){
			
			int max = 0;
			for (pessoaConta conta2 : contas) {
				max = Math.max(max, conta2.getId());
			}
			conta.setId(max+1);
			contas.add(conta);
		} else {
			pessoaConta c = get(conta.getId());
			c.setSaldo(conta.getSaldo());
			c.setNomep(conta.getNomep());
		}
		return conta.getId();
	}
	
	public void deleteConta(int id){
		contas.remove(get(id));
	}
}