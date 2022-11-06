package br.com.suporte.teste.validar;

import java.util.Scanner;

import br.com.suporte.jdbc.Cliente;

public class TesteValidarNome {
	
	public static void main (String[] args) {
		
		//ESSE TESTE NAO TEM CONEXAO COM O CADASTRO NO BANCO DE DADOS ! É APENAS UMA VALIDAÇÃO DO CODIGO (DATA) ! 
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("[1]- TESTAR  ||   [2]- SAIR");
		int opcao = leitor.nextInt();
		
		do {
			
			switch (opcao) {
			
			case 1:
				
				Scanner leitor2 = new Scanner (System.in);
				System.out.println("Digite o Nome para teste: ");
				
				String nome = leitor2.next();
				
				if (Cliente.validarNome(nome) == true) {
					
					System.out.println("Nome, valido!");
				}else {
					System.out.println("Erro, Nome invalido! ");
				}
				System.out.println();
				
				System.out.println("TESTAR NOVAMENTE? [1]- SIM  ||  [2]- NÃO");
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
				System.out.println("opção invalida!");
				System.exit(0);
				break;
				
			}
				
		}while (opcao != 3);
		
		leitor.close();
		
	}

}
