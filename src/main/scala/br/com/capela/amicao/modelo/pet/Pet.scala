package br.com.capela.amicao.modelo.pet;

import java.util.List;

import br.com.capela.amicao.modelo.base.Entidade

import java.io.Serializable;
import java.util.Date

import javax.persistence._

import scala.reflect._

import br.com.capela.amicao.modelo.cliente.Cliente;
import br.com.capela.amicao.modelo.servico.Servico;

@Entity
class Pet extends Entidade[Pet]{
	
    @Column{val name="codigo"}
    @BeanProperty var codigo:String = _
	
    @Column{val name="nome"}
    @BeanProperty var nome:String = _
    
    @Temporal(TemporalType.DATE)
    @Column{val name="dataDeNascimento"}
    @BeanProperty var Date:Date = _
    
    @ManyToMany{val cascade = Array(CascadeType.PERSIST),
                val targetEntity =  classOf[Cliente],
                val fetch = FetchType.LAZY,
                val mappedBy = "pets"
    }
    @BeanProperty var proprietarios : java.util.List[Cliente] = new java.util.Vector[Cliente]
    
    @ManyToOne{
    	val cascade = Array(CascadeType.PERSIST),
        val targetEntity = classOf[Raca]
    }
    @BeanProperty var raca: Raca = _
    
    @ManyToOne{
    	val cascade = Array(CascadeType.PERSIST),
        val targetEntity = classOf[Cor]
    }
    @BeanProperty var corPredominante: Cor = _
    
    @Enumerated(EnumType.STRING)
    @Column{val name="especie"}
    @BeanProperty var especie: EspecieEnum.Value = EspecieEnum.indefinida

    @Enumerated(EnumType.STRING)
    @Column{val name="sexo"}
    @BeanProperty var sexo: SexoEnum.Value = SexoEnum.indefinido
	
    //private List<Servico> servicosPrestados;
}
