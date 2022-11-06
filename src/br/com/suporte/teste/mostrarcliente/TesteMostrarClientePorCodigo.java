package br.com.suporte.teste.mostrarcliente;

import java.util.Scanner;

import br.com.suporte.jdbc.Cliente;
import br.com.suporte.jdbc.ClienteDao;

public class TesteMostrarClientePorCodigo {
	
	public static void main (String[] args) {
		
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("Digite o Codigo do Cliente: ");
		int recebecodigo = leitor.nextInt();
	
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.mostrarClientePorCodigo(recebecodigo);
		
		System.out.println("Codigo: " + cliente.getCodigo());
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Endereco: " + cliente.getEndereco());
		System.out.println("Numero de Endereco: " + cliente.getNumEndereco());
		System.out.println("CEP: " + cliente.getCep());
		System.out.println("DDD: " + cliente.getDdd());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("E_Mail: " + cliente.getEmail());
		System.out.println("Data do suporte: " + cliente.getDataSuporte());
		System.out.println("Tipo de Atendimento: " + cliente.getTipoAtendimento());
		System.out.println();
	
	}
}
	