package br.com.capela.amicao.modelo.venda.formaDePagamento;

import java.util.Date;

import br.com.capela.amicao.modelo.venda.FormaDePagamento;

public class CartaoDeDebito extends FormaDePagamento<CartaoDeDebito> {

	@Override
	public void calcularDataDeFaturamento(Date dataDaVenda) {
		// data da venda + dois dias uteis

	}
}
