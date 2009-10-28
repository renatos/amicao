package br.com.capela.amicao.modelo.servico;

import br.com.capela.amicao.modelo.venda.ItemDeVenda;

public class Servico extends ItemDeVenda<Servico> {

	private TipoDeServico tipoDeServico;

	@Override
	public Boolean isMesmaEntidade(ItemDeVenda<Servico> outraEntidade) {
		return null;
	}
}
