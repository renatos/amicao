package br.com.capela.amicao.modelo.venda;

import br.com.capela.amicao.modelo.base.Entidade_old;

import java.util.Date;

public abstract class FormaDePagamento<T> extends Entidade_old<FormaDePagamento<T>> {

    private String codigo;

    private String descricao;

    protected Date faturarEm;

    public abstract void calcularDataDeFaturamento(Date dataDaVenda);

    public Long getCodigo() {
        return null;
    }

    @Override
    public Boolean isMesmaEntidade(FormaDePagamento<T> outraEntidade) {
        return codigo.equals(outraEntidade);
    }
}
