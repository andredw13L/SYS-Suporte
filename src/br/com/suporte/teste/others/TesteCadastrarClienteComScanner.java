package br.com.suporte.teste.others;

import java.util.Scanner;
import br.com.suporte.jdbc.Cliente;
import br.com.suporte.jdbc.ClienteDao;

public class TesteCadastrarClienteComScanner {
	
	public static void main (String[] args) throws Exception {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("======= CADASTRO DE CLIENTE =======");
		System.out.println();
		System.out.println("NOME: ");
		String nome = leitor.nextLine();
		
		if (Cliente.validarNome(nome) == true) {
			
			System.out.println("Digite seu CPF:");
			String cpf = leitor.next();
			
			if (Cliente.validaCPF(cpf) == true) {
			
				System.out.println("ENDEREÇO: ");
				String endereco = leitor.next();
				
				if (Cliente.validarEND(endereco) == true) {
					
					System.out.println("Nº DO ENDEREÇO: ");
					String numEndereco = leitor.next();
					
					if (Cliente.validarNumEND(numEndereco) == true) {
						
						System.out.println("Digite seu CEP: ");
						String cep = leitor.next();
						
						if (Cliente.validarCEP(cep) == true) {
							
							System.out.println("Digite seu DDD:  ex: 11");
							String ddd = leitor.next();
							
							if (Cliente.validarDDD(ddd) == true) {
								
								System.out.println("Digite seu TELEFONE: ");
								String telefone = leitor.next();
								
								if (Cliente.validarTEL(telefone) == true) {
									
									System.out.println("Digite seu Email: ");
									String eMail = leitor.next();
								
									if (Cliente.validarEmail(eMail) == true) {
										
										System.out.println("Digite a DATA/MES/ANO para suporte   ex: 30/11/2020: ");
										String dataSuporte = leitor.next();
										
										if (Cliente.validarData(dataSuporte) == true) {
										
											System.out.println("Digite o tipo de atendimento que precisa: (Presencial ou Remoto).");
											String tipoAtendimento = leitor.next();
											
											if (Cliente.validarATDM(tipoAtendimento) == true) {
										
												Cliente cliente = new Cliente (nome, cpf, endereco, numEndereco, cep, ddd, telefone, eMail, dataSuporte, tipoAtendimento);
					
												ClienteDao clienteDao = new ClienteDao();
												clienteDao.cadastrar(cliente);
												
											}else {
												System.out.println("Erro, Tipo de Atendimento invalido!");
											}
											
										}else {
											System.out.println("Erro, Formato de Data invalido!");
										}
								
									}else {
										System.out.println("Erro, Endere�o de Email invalido!");
									}
									
								}else {
									System.out.println("Erro, Telefone invalido!");
								}
							
							}else {
								System.out.println("Erro, DDD invalido!");
							}
							
						}else {
							System.out.println("Erro, CEP invalido!");
						}
					
					}else {
						System.out.println("Erro, Numero de Endere�o invalido!");
					}	
					
				}else {
					System.out.println("Erro, Endere�o invalido!");
				}
					
			}else {
				System.out.println("Erro, CPF invalido!");
			} 
			
		}else {
			System.out.println("Erro, Nome invalido!");
		}
		
		leitor.close();
	}
}
