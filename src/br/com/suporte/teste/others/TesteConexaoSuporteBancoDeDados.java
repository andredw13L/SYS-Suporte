package br.com.suporte.teste.others;

import java.sql.SQLException;

import br.com.suporte.jdbc.ConexaoSysSuporte;

public class TesteConexaoSuporteBancoDeDados {
	
	public static void main (String[] args) throws SQLException {
		ConexaoSysSuporte.obterConexao();
	}

}
