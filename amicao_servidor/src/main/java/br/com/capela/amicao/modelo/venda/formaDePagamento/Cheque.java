package br.com.capela.amicao.modelo.venda.formaDePagamento;

import br.com.capela.amicao.modelo.venda.FormaDePagamento;

import java.util.Date;

public class Cheque extends FormaDePagamento<Cheque> {

    @Override
    public void calcularDataDeFaturamento(Date dataDaVenda) {
        // data deposito + dois dias uteis

    }

}
