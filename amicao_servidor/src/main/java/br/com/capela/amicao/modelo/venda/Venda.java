package br.com.capela.amicao.modelo.venda;

import br.com.capela.amicao.modelo.base.Entidade_old;
import br.com.capela.amicao.modelo.comum.Dinheiro;

import java.util.Date;
import java.util.Set;

public class Venda extends Entidade_old<Venda> {

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
