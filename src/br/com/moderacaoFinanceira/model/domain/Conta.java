package br.com.moderacaoFinanceira.model.domain;


import util.ValidacaoException;

public class Conta {

	private Integer codigoConta;
	private String codigoUsuario;
	private String nomeConta;
	private String tipoConta;
	private String valorConta;
	
	public void valida() throws ValidacaoException {
		if(nomeConta == null || nomeConta.equals("")) {
			throw new ValidacaoException("O campo Nome Conta eh obrigatorio");
		}
		if(tipoConta == null || tipoConta.equals("")) {
			throw new ValidacaoException("O campo Tipo Conta eh obrigatorio");
		}
		if(valorConta.equals("")) {
			throw new ValidacaoException("O campo Valor eh obrigatorio");
		}
	}
	
	public Conta() {
		super();
	}

	public Conta(Integer codigoConta, String codigoUsuario, String nomeConta, String tipoConta, String valor) {
		super();
		this.codigoConta = codigoConta;
		this.codigoUsuario = codigoUsuario;
		this.nomeConta = nomeConta;
		this.tipoConta = tipoConta;
		this.valorConta = valor;
	}

	public Integer getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(Integer codigoConta) {
		this.codigoConta = codigoConta;
	}
	
	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getValorConta() {
		return valorConta;
	}

	public void setValorConta(String valor) {
		this.valorConta = valor;
	}
	
}
