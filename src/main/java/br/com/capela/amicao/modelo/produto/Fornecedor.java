package br.com.capela.amicao.modelo.produto;

import java.util.Set;

import br.com.capela.amicao.modelo.base.Entidade;

public class Fornecedor extends Entidade<Fornecedor> {

	private String codigo;

	private String razaoSocial;

	private Set<Produto> produdos;

	public Long getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isMesmaEntidade(Fornecedor outraEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
