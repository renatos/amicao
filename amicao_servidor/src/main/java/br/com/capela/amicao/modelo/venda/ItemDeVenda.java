package br.com.capela.amicao.modelo.venda;

import br.com.capela.amicao.modelo.base.Entidade_old;
import br.com.capela.amicao.modelo.comum.Dinheiro;
import org.joda.time.DateTime;

public abstract class ItemDeVenda<T> extends Entidade_old<ItemDeVenda<T>> {

    private String codigo;

    private Dinheiro valorUnitario;

    private Integer quantidade;

    private DateTime dataHora;

    public String getCodigo() {
        return codigo;
    }
}
