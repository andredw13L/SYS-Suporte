package br.com.suporte.teste.others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.suporte.jdbc.ClienteDao;
import br.com.suporte.jdbc.ConexaoSysSuporte;

public class TesteExcluirClientePorCodigo {
	
	public static void main (String[] args) {
		
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("Digite o Codigo: ");
		int codigoCli = leitor.nextInt();
		
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.excluirClientePorCodigo(codigoCli);  //escolher codigo
	}
	
	public void excluirClientePorCodigo (int codigo) {
		
		Connection con = ConexaoSysSuporte.obterConexao();
		
		String sql = "DELETE FROM cliente WHERE codigo=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(2, codigo);
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cliente excluido com sucesso!!!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
