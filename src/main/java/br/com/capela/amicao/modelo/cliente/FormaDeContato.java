package br.com.capela.amicao.modelo.cliente;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import br.com.capela.amicao.modelo.base.Entidade_old;

public class FormaDeContato extends Entidade_old<FormaDeContato> {

	private String telefone1;
	private String telefone2;
	private String celular;
	private String email;

	@Override
	public Boolean isMesmaEntidade(FormaDeContato outro) {
		return new EqualsBuilder().append(telefone1, outro.telefone1)
				.append(celular, outro.celular).append(email, outro.email).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(telefone1).append(celular).append(email).toHashCode();
	}

}
