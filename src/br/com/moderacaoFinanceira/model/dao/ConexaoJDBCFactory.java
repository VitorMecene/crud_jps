package br.com.moderacaoFinanceira.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBCFactory {
	
	public static Connection getConexao() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","mecene");
			
	}

}
