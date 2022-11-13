package br.edu.infnet.apppagamento.model.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);
	
	public static Connection getConnection() {
		logger.info("Inciando conexao com o banco de dados");
		String password = "";
		String user= "root";
		String url = "jdbc:mysql://localhost:3306/app?createDatabaseIfNotExist=true";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			logger.error("Erro ao conectar", e);
			throw new RuntimeException(e);
		}
	}
}