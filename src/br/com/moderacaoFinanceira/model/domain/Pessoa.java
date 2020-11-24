package br.com.moderacaoFinanceira.model.domain;

import util.ValidacaoException;

public class Pessoa {

	private Integer codigo;
	private String email;
	private String nome;

	public void valida() throws ValidacaoException {
		if(nome == null || nome.equals("")) {
			throw new ValidacaoException("O campo nome eh obrigatorio");
		}
	}
	
	public Pessoa() {
		super();
	}

	public Pessoa(Integer codigo, String email, String nome) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
