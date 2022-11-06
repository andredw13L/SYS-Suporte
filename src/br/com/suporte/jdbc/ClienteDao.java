package br.com.suporte.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


	public class ClienteDao {
		
		public void cadastrar(Cliente cliente) {
			
			Connection con = ConexaoSysSuporte.obterConexao();
			
			String sql = "INSERT INTO cliente (nome, cpf, endereco, numEndereco, cep, ddd, telefone, email, datasuporte, atendimento) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
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
				
				System.out.println("Cliente cadastrado com sucesso!");
				
			} catch (SQLException e) {
				System.err.println("Erro ao cadastrar Cliente!");
				e.printStackTrace();
			}
		}
		
		public ArrayList<Cliente> mostrarTodosClientes(){
			
			Connection con = ConexaoSysSuporte.obterConexao();
			ArrayList<Cliente> clientes = new ArrayList<>();
			String sql = "SELECT * from cliente";
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				ResultSet resultado = preparador.executeQuery();
				
				while(resultado.next()) {
					
					Cliente cliente = new Cliente();
					cliente.setCodigo(resultado.getInt("codigo"));
					cliente.setNome(resultado.getString("nome"));
					cliente.setCpf(resultado.getString("cpf"));
					cliente.setEndereco(resultado.getString("endereco"));
					cliente.setNumEndereco(resultado.getString("numEndereco"));
					cliente.setCep(resultado.getString("cep"));
					cliente.setDdd(resultado.getString("ddd"));
					cliente.setTelefone(resultado.getString("telefone"));
					cliente.setEmail(resultado.getString("email"));
					cliente.setDataSuporte(resultado.getString("datasuporte"));
					cliente.setTipoAtendimento(resultado.getString("atendimento"));
				
					clientes.add(cliente);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return clientes;
		}
		
		public void excluirClientePorCodigo(int codigo) {
			
			Connection con = ConexaoSysSuporte.obterConexao();
			
			String sql = "DELETE FROM cliente WHERE codigo =?";
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				preparador.setInt(1, codigo);
				
				preparador.execute();
				System.out.println("Cliente excluido com sucesso!!!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public Cliente mostrarClientePorCodigo(int codigo) {
			
			Connection con = ConexaoSysSuporte.obterConexao();
			Cliente cliente = null;
			
			String sql = "SELECT * FROM cliente WHERE codigo=?";
			
			PreparedStatement preparador;
			try {
				preparador = con.prepareStatement(sql);
				preparador.setInt(1, codigo);
				
				ResultSet resultado = preparador.executeQuery();
				
				if (resultado.next()) {
					cliente = new Cliente();
					cliente.setCodigo(resultado.getInt("codigo"));
					cliente.setNome(resultado.getString("nome"));
					cliente.setCpf(resultado.getString("cpf"));
					cliente.setEndereco(resultado.getString("endereco"));
					cliente.setNumEndereco(resultado.getString("numEndereco"));
					cliente.setCep(resultado.getString("cep"));
					cliente.setDdd(resultado.getString("ddd"));
					cliente.setTelefone(resultado.getString("telefone"));
					cliente.setEmail(resultado.getString("email"));
					cliente.setDataSuporte(resultado.getString("datasuporte"));
					cliente.setTipoAtendimento(resultado.getString("atendimento"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return cliente;
		}
		
		public void alterarClientePorCodigo (Cliente cliente) {
			
			Connection con = ConexaoSysSuporte.obterConexao();
			
			String sql = "UPDATE cliente SET nome=?, cpf=?, endereco=?, numEndereco=?, cep=?, ddd=?, telefone=?, email=?, datasuporte=?, atendimento=? WHERE codigo = ?";
			
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
				preparador.setInt(11, cliente.getCodigo());
				
				preparador.execute();
				
				System.out.println("Cliente alterado com sucesso!!!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
