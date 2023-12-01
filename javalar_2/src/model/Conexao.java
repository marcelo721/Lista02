package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {

	private String host;
	private String user;
	private String password;
	private String Database;

	public Conexao() {

		this.host = "da_java.mysql.dbaas.com.br";
		this.Database = "da_java";
		this.user = "da_java";
		this.password = "Tecnicas*2023@";
	}

	public Connection getConexao(){

		String url = "jdbc:mysql://" + this.host + "/" + this.Database
				+ "?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";

		try {

			return DriverManager.getConnection(url, user, password);

		} catch (SQLException ex) {
			System.out.println("ConexAo com MYSQL nao realizada");
			ex.printStackTrace();
		}
		return null;
	}

}
