package br.com.suporte.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSysSuporte {
	
	public static Connection obterConexao() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dbclientes?useSSl=false","root","root");
			System.out.println("Banco de Dados conectado com sucesso!");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Nao foi possível conectar ao banco de dados. =/");
			e.printStackTrace();
		}
		return con;
	}

}
