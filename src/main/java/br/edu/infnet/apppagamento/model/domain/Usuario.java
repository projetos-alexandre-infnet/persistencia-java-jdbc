package br.edu.infnet.apppagamento.model.domain;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

import java.util.List;


public class Usuario implements IPrinter {

	private Integer id;
	private String nome;
	private String email;
	private String senha;


	private List<Cliente> clientes;


	private List<Pagamento> produtos;


	private List<Conta> contas;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}



	public String getSenha() {
		return senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public void impressao() {
		System.out.println("#usuario");
		System.out.println(this);
		
	}
	

}
