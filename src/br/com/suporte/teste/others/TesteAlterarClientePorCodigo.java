package br.com.suporte.teste.others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.suporte.jdbc.Cliente;
import br.com.suporte.jdbc.ClienteDao;
import br.com.suporte.jdbc.ConexaoSysSuporte;

public class TesteAlterarClientePorCodigo {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner (System.in);
		
		Cliente cliente = new Cliente();
		
		System.out.println("Digite o codigo do cliente que deseja alterar: ");
		int codCli = leitor.nextInt();
		cliente.setCodigo(codCli);
		
		System.out.println("Digite o Nome do cliente: ");
		String nomeCli = leitor.next();
		cliente.setNome(nomeCli);
		
		if (Cliente.validarNome(nomeCli) == true) {
		
			System.out.println("Digite o CPF do cliente:");
			String cpfCli = leitor.next();
			cliente.setCpf(cpfCli);
			
			if (Cliente.validaCPF(cpfCli) == true) {
				
				System.out.println("Digite o Endere�o do cliente:");
				String endCli = leitor.next();
				cliente.setEndereco(endCli);
				
				if (Cliente.validarEND(endCli) == true) {
				
					System.out.println("Digite o numero do endere�o do cliente:");
					String numEndCli = leitor.next();
					cliente.setNumEndereco(numEndCli);
					
					if (Cliente.validarNumEND(numEndCli) == true) {
					
						System.out.println("Digite o CEP do cliente:");
						String cepCli = leitor.next();
						cliente.setCep(cepCli);
						
						if (Cliente.validarCEP(cepCli) == true) {
						
							System.out.println("Digite o DDD do cliente:");
							String dddCli = leitor.next();
							cliente.setDdd(dddCli);
							
							if (Cliente.validarDDD(dddCli) == true) {
							
								System.out.println("Digite o Telefone do cliente:");
								String telCli = leitor.next();
								cliente.setTelefone(telCli);
								
								if (Cliente.validarTEL(telCli) == true) {
								
									System.out.println("Digite o Email do cliente:");
									String emailCli = leitor.next();
									cliente.setEmail(emailCli);
									
									if (Cliente.validarEmail(emailCli) == true) {
									
										System.out.println("Digite a Data do Atendimento do cliente:        ex: 30/12/2020");
										String dataCli = leitor.next();
										cliente.setDataSuporte(dataCli);
										
										if (Cliente.validarData(dataCli) == true) {
										
											System.out.println("Digite o tipo de atendimento do cliente:    (Remoto ou Presencial)");
											String atendCli = leitor.next();
											cliente.setTipoAtendimento(atendCli);
											
											if (Cliente.validarATDM(atendCli) == true) {
											
												ClienteDao clienteDao = new ClienteDao();
												clienteDao.alterarClientePorCodigo(cliente);
												
											}else {
												System.out.println("Erro, Tipo de Atendimento invalido!");
											}
										}else {
											System.out.println("Erro, Data invalida!");
										}
									}else {
										System.out.println("Erro, Email invalido!");
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
					System.out.println("Erro, Nome de Endere�o invalido!");
				}
			}else {
				System.out.println("Erro, CPF invalido!");
			}
		}else {
			System.out.println("Erro, Nome invalido!");
		}
	}
	
	public void alterarClientePorCodigo (Cliente cliente) {
		
		Connection con = ConexaoSysSuporte.obterConexao();
		
		String sql = "UPDATE cliente SET nome=?, cpf=?, endereco=?, num_end=?, cep=?, ddd=?, telefone=?, e_mail=?, suporte=?, atendimento=? WHERE codigo=?";
	
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3, cliente.getEndereco());
			preparador.setString(4, cliente.getNumEndereco());
			preparador.setString(5, cliente.getCep());
			preparador.setString(6, cliente.getDdd());
			preparador.setString(7, cliente.getTelefone());
			preparador.setString(8, cliente.getEmail());
			preparador.setString(9, cliente.getDataSuporte());
			preparador.setString(10, cliente.getTipoAtendimento());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("O cliente foi alterado com sucesso!");
			
		} catch (SQLException e) {
			System.err.println("Erro ao alterar cliente!");
			e.printStackTrace();
		}
	}

}
