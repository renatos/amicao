package br.com.capela.amicao.modelo.venda.formaDePagamento;

import java.util.Date;

import br.com.capela.amicao.modelo.venda.FormaDePagamento;

public class Cheque extends FormaDePagamento<Cheque> {

	@Override
	public void calcularDataDeFaturamento(Date dataDaVenda) {
		// data deposito + dois dias uteis

	}

}
