package br.com.capela.amicao.modelo.venda.formaDePagamento;

import java.util.Date;

import br.com.capela.amicao.modelo.venda.FormaDePagamento;

public class CartaoDeCredito extends FormaDePagamento<CartaoDeCredito> {

	@Override
	public void calcularDataDeFaturamento(Date dataDaVenda) {
		// dataDaVenda + 30 dias
	}
}
