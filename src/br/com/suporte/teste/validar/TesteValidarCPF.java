package br.com.suporte.teste.validar;

import java.util.Scanner;

import br.com.suporte.jdbc.Cliente;

public class TesteValidarCPF {
	
	public static void main (String[] args) {
		
		//ESSE TESTE NAO TEM CONEXAO COM O CADASTRO NO BANCO DE DADOS ! ? APENAS UMA VALIDA??O DO CODIGO (CPF) ! 
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("[1]- TESTAR  ||   [2]- SAIR");
		int opcao = leitor.nextInt();
		
		do {
			
			switch (opcao) {
			
			case 1:
				
				Scanner leitor2 = new Scanner (System.in);
				System.out.println("Digite o CPF para teste: ");
				
				String cpf = leitor2.next();
				
				if (Cliente.validaCPF(cpf) == true) {
					
					System.out.println("CPF, valido!");
					
				}else {
					System.out.println("Erro, CPF invalido! ");
				}
				System.out.println();
				
				System.out.println("TESTAR NOVAMENTE? [1]- SIM  ||  [2]- N?O");
				opcao = leitor.nextInt();
				break;
			
			case 2:
				System.out.println(".");
				System.out.println(".");
				System.out.println(".");
				System.out.println("SISTEMA DE CHECAGEM FINALIZADO COM SUCESSO!");
				opcao = 3;
				System.exit(0);
				break;
				
			default :
				System.out.println("op??o invalida!");
				System.exit(0);
				break;
				
			}
				
		}while (opcao != 3);
		
		leitor.close();
		
	}

}
