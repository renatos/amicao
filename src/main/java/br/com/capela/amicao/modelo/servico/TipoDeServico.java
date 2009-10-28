package br.com.capela.amicao.modelo.servico;

import br.com.capela.amicao.modelo.base.Entidade_old;
import br.com.capela.amicao.modelo.comum.Dinheiro;

public class TipoDeServico extends Entidade_old<TipoDeServico> {

	private String nome;

	private Dinheiro custo;

	public Long getCodigo() {
		return null;
	}

	@Override
	public Boolean isMesmaEntidade(TipoDeServico outraEntidade) {
		return null;
	}

}
