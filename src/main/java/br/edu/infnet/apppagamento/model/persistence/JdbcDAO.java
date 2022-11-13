package br.edu.infnet.apppagamento.model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class JdbcDAO<T> implements IDAO<T> {

	protected Connection con;
	protected PreparedStatement pstm;
	protected Statement stm;
	protected ResultSet rs;

	public JdbcDAO() {
		super();
		con = JdbcUtil.getConnection();
	}

}