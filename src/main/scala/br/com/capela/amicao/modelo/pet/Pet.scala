package br.com.capela.amicao.modelo.pet;

import java.util.List;

import br.com.capela.amicao.modelo.base.Entidade
import br.com.capela.persistencia._

import java.io.Serializable;

import javax.persistence._

import scala.reflect._

import br.com.capela.amicao.modelo.cliente.Cliente;
import br.com.capela.amicao.modelo.servico.Servico;

class Pet extends Entidade[Pet] with ActiveRecord[Pet] {

	@Column{val name="nome"}
    @BeanProperty var nome:String = _
    
    @Column{val name="idade"}
    @BeanProperty var idade:Int = _
    
    @Column{val name="proprietarios"}
    @BeanProperty var proprietarios: List[Cliente] = _
    
    @ManyToOne{
    	val cascade = Array(CascadeType.PERSIST),
	    val targetEntity = classOf[Raca]
    }
    @JoinColumn{val name="id"}
    @BeanProperty var raca: Raca = _
    
    @ManyToOne{
    	val cascade = Array(CascadeType.PERSIST),
	    val targetEntity = classOf[Cor]
    }
    @JoinColumn{val name="id"}
    @BeanProperty var corPredominante: Cor = _
    
	//private EspecieEnum especie;
	//private SexoEnum sexo;
	
	//sprivate List<Servico> servicosPrestados;

}
