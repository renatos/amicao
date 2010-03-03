package br.com.capela.amicao.modelo.venda.formaDePagamento;

import br.com.capela.amicao.modelo.venda.FormaDePagamento;

import java.util.Date;

public class CartaoDeCredito extends FormaDePagamento<CartaoDeCredito> {

    @Override
    public void calcularDataDeFaturamento(Date dataDaVenda) {
        // dataDaVenda + 30 dias
    }
}
