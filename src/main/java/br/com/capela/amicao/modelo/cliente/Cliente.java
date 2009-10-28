package br.com.capela.amicao.modelo.cliente;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import br.com.capela.amicao.modelo.base.Entidade;
import br.com.capela.amicao.modelo.pet.Pet;

public class Cliente extends Entidade<Cliente> {

	private String nome;
	private Endereco endereco;
	private FormaDeContato formaDeContato;
	private List<Pet> pets;

	@Override
	public Boolean isMesmaEntidade(Cliente outro) {
		return new EqualsBuilder().append(nome, outro.nome).append(endereco, outro.endereco)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nome).append(endereco).toHashCode();
	}

}
