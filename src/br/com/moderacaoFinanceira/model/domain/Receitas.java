package br.com.moderacaoFinanceira.model.domain;

import util.ValidacaoException;

public class Receitas {

	private Integer idReceita;
	private String codigoConta;
	private String tipoConta;
	private String nomeTag;
	private String nomeCategoria;
	private String dataInclusao;
	private String descricao;
	private String valorReceita;
	
	public void valida() throws ValidacaoException {
		
		if(codigoConta == null || codigoConta.equals("")) {
			throw new ValidacaoException("O campo codigoConta eh obrigatorio");
		}
		if(tipoConta == null || tipoConta.equals("")) {
			throw new ValidacaoException("O campo tipoConta eh obrigatorio");
		}
		if(dataInclusao == null || dataInclusao.equals("")) {
			throw new ValidacaoException("O campo dataInclusao eh obrigatorio");
		}
		if(descricao.equals("")) {
			throw new ValidacaoException("O campo descricao eh obrigatorio");
		}
		if(valorReceita.equals("")) {
			throw new ValidacaoException("O campo valorReceita eh obrigatorio");
		}
	}
	
	public Receitas() {

	}
	
	public Receitas(Integer idReceita, String codigoConta, String tipoConta, String nomeTag, String nomeCategoria,
			String dataInclusao, String descricao, String valorReceita) {
		super();
		this.idReceita = idReceita;
		this.codigoConta = codigoConta;
		this.tipoConta = tipoConta;
		this.nomeTag = nomeTag;
		this.nomeCategoria = nomeCategoria;
		this.dataInclusao = dataInclusao;
		this.descricao = descricao;
		this.valorReceita = valorReceita;
	}

	public Integer getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(Integer idReceita) {
		this.idReceita = idReceita;
	}

	public String getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(String codigoConta) {
		this.codigoConta = codigoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getNomeTag() {
		return nomeTag;
	}

	public void setNomeTag(String nomeTag) {
		this.nomeTag = nomeTag;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(String dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(String valor) {
		this.valorReceita = valor;
	}
	
}
