package br.com.capela.amicao.modelo.venda;

import java.util.Date;
import java.util.Set;

import br.com.capela.amicao.modelo.base.Entidade;
import br.com.capela.amicao.modelo.comum.Dinheiro;

public class Venda extends Entidade<Venda> {

	private Long codigo;

	private Date data;

	private Dinheiro valorTotal;

	private Set<ItemDeVenda<? extends ItemDeVenda<?>>> itens;

	private FormaDePagamento<? extends FormaDePagamento<?>> formaDePagamento;

	public Long getCodigo() {
		return codigo;
	}

	@Override
	public Boolean isMesmaEntidade(Venda outraEntidade) {
		// TODO Auto-generated method stub
		return null;
	}
}
