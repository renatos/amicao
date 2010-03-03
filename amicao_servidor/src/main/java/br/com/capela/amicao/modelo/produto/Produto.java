package br.com.capela.amicao.modelo.produto;

import br.com.capela.amicao.modelo.comum.Dinheiro;
import br.com.capela.amicao.modelo.venda.ItemDeVenda;

import java.util.Date;

public class Produto extends ItemDeVenda<Produto> {

    private Dinheiro custo;

    private Date entrada;

    private Integer quantidadeEmEstoque;

    private Fornecedor fornecedor;

    @Override
    public Boolean isMesmaEntidade(ItemDeVenda<Produto> outraEntidade) {
        // TODO Auto-generated method stub
        return null;
    }

}
