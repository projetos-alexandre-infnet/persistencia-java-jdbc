package br.edu.infnet.apppagamento.model.domain;

import br.edu.infnet.apppagamento.interfaces.IPrinter;
import br.edu.infnet.apppagamento.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ImpostoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.QuantidadeDeParcelasInvalidaException;

import java.util.List;
import java.util.Objects;

public abstract class Conta implements IPrinter {


	private Integer id;
	private String descricao;
	private boolean contaAtiva;

	private Usuario usuario;

	private List<Pagamento> pagamentos;

	public Conta() {}
	public abstract boolean mostraContaAtiva() throws ConsumoInvalidoException, ImpostoInvalidoException, QuantidadeDeParcelasInvalidaException;

	public Conta(Integer id, String descricao, boolean contaAtiva) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.contaAtiva = contaAtiva;
	}

	@Override
	public String toString() {
		return "id: " + id + "\n" + "descrição: " + descricao + "\n" + "Conta Ativa? " + contaAtiva + "\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void impressao() {
		System.out.println("#Conta");
		System.out.println(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}

}
