package br.com.capela.amicao.modelo.venda.formaDePagamento;

import br.com.capela.amicao.modelo.venda.FormaDePagamento;

import java.util.Date;

public class CartaoDeDebito extends FormaDePagamento<CartaoDeDebito> {

    @Override
    public void calcularDataDeFaturamento(Date dataDaVenda) {
        // data da venda + dois dias uteis

    }
}
