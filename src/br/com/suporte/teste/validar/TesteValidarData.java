package br.com.suporte.teste.validar;

import java.util.Scanner;

import br.com.suporte.jdbc.Cliente;

public class TesteValidarData {
	
	public static void main (String[] args) throws Exception {
		
		
		//ESSE TESTE NAO TEM CONEXAO COM O CADASTRO NO BANCO DE DADOS ! � APENAS UMA VALIDA��O DO CODIGO (DATA) ! 
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("[1]- TESTAR  ||   [2]- SAIR");
		int opcao = leitor.nextInt();
		
		do {
			
			switch (opcao) {
			
			case 1:
				
				Scanner leitor2 = new Scanner (System.in);
				System.out.println("Digite a data para teste     ex:30/12/2020 : ");
				
				String dataSuporte = leitor2.next();
				
				if (Cliente.validarData(dataSuporte) == true){
					
					System.out.println("DATA, valida!  ");
					
				}else {
					System.out.println("Erro, DATA invalida! ");
				}
				System.out.println();
				
				System.out.println("TESTAR NOVAMENTE? [1]- SIM  ||  [2]- NAO");
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
				System.out.println("opcao invalida!");
				System.exit(0);
				break;
				
			}
				
		}while (opcao != 3);
		
		leitor.close();
	}
}
