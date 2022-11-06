package br.com.suporte.teste.validar;

import java.util.Scanner;

import br.com.suporte.jdbc.Cliente;
import br.com.suporte.jdbc.ClienteDao;

public class TesteValidarCEP {
	
	public static void main (String[] args) {
		
		//ESSE TESTE NAO TEM CONEXAO COM O CADASTRO NO BANCO DE DADOS ! É APENAS UMA VALIDAÇÃO DO CODIGO (CEP) ! 
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("[1]- TESTAR  ||   [2]- SAIR");
		int opcao = leitor.nextInt();
		
		do {
			
			switch (opcao) {
			
			case 1:
				
				Scanner leitor2 = new Scanner (System.in);
				System.out.println("Digite o cep para teste: ");
				
				String cep = leitor2.next();
				
				if (Cliente.validarCEP(cep) == true) {
					System.out.println(cep);
					System.out.println("Cep, valido!");
					
				}else {
					System.out.println("Erro, cep invalido! ");
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
