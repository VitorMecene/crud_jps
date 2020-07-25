package br.com.callCenterVendas.model.domain;

import util.ValidacaoException;

public class Fornecedor extends Pessoa {

	private String razaoSocial;
	private String cnpj;

	public void valida() throws ValidacaoException {
		super.valida();
		if(razaoSocial == null || razaoSocial.equals("")) {
			throw new ValidacaoException("O campo Razao Social eh obrigatorio");
		}
		if(cnpj == null || cnpj.equals("")) {
			throw new ValidacaoException("O campo CNPJ eh obrigatorio");
		}
	}
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(Integer codigo, String nome, String email, String razaoSocial, String cnpj) {
		super(codigo, email, nome);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
