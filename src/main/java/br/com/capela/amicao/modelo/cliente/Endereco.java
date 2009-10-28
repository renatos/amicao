package br.com.capela.amicao.modelo.cliente;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import br.com.capela.amicao.modelo.base.Entidade;

public class Endereco extends Entidade<Endereco> {

	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String cep;

	@Override
	public Boolean isMesmaEntidade(Endereco outro) {
		return new EqualsBuilder().append(logradouro, outro.logradouro)
				.append(numero, outro.numero).append(bairro, outro.bairro).append(cep, outro.cep)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(logradouro).append(numero).append(bairro).append(cep)
				.toHashCode();
	}
}
