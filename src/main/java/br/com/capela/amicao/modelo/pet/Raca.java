package br.com.capela.amicao.modelo.pet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.capela.amicao.modelo.base.Entidade;

@Entity
public class Raca extends Entidade<Raca> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private String codigo;

	@Column
	private String nome;

	public Raca() {
	}

	public Raca(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;

	}

	@Override
	public Boolean isMesmaEntidade(Raca outraEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
