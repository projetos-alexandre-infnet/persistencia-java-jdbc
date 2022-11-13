package br.edu.infnet.apppagamento.model.persistence;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.exceptions.CpfOuCnpjInvalidoException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends JdbcDAO<Cliente>  {

	public ClienteDAO() {
	}
	
	@Override
	public Boolean save(Cliente cliente) {
		String sql = "insert into cliente(nome, email, cpfOuCnpj) values (?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(1, cliente.getEmail());
			pstm.setString(1, cliente.getCpfOuCpnj());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public Boolean update(Cliente cliente) {
		String sql = "update cliente set nome = ? where id = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome()); 
			pstm.setInt(2, cliente.getId());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Boolean delete(Integer id) {
		String sql = "delete from cliente where id = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cliente getById(Integer id) {
		String sql = "select * from cliente where id = ?";
		Cliente cliente = new Cliente();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String cpfOuCnpj = rs.getString("cpfOuCnpj");
				cliente = new Cliente(null, nome, email, cpfOuCnpj);
			}
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (CpfOuCnpjInvalidoException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	
	@Override
	public List<Cliente> listAll(){
		String sql = "select * from cliente";
		List<Cliente> clientes = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String cpfOuCnpj = rs.getString("cpfOuCnpj");
				Cliente cliente = new Cliente(id, nome, email, cpfOuCnpj);
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (CpfOuCnpjInvalidoException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}