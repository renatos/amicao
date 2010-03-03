package br.com.capela.amicao.modelo.produto;

import br.com.capela.amicao.modelo.base.Entidade_old;

import java.util.Set;

public class Fornecedor extends Entidade_old<Fornecedor> {

    private String codigo;

    private String razaoSocial;

    private Set<Produto> produdos;

    public Long getCodigo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean isMesmaEntidade(Fornecedor outraEntidade) {
        // TODO Auto-generated method stub
        return null;
    }

}
