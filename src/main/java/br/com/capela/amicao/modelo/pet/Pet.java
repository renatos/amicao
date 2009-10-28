package br.com.capela.amicao.modelo.pet;

import java.util.List;

import br.com.capela.amicao.modelo.base.Entidade;
import br.com.capela.amicao.modelo.cliente.Cliente;
import br.com.capela.amicao.modelo.servico.Servico;

public class Pet extends Entidade<Pet> {

	private String nome;
	private EspecieEnum especie;
	private Integer idade;
	private SexoEnum sexo;
	private List<Cliente> proprietarios;
	private Raca raca;
	private Cor corPredominante;
	private List<Servico> servicosPrestados;

	@Override
	public Boolean isMesmaEntidade(Pet outraEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
