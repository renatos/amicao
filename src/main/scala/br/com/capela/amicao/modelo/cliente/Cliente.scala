package br.com.capela.amicao.modelo.cliente;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import br.com.capela.amicao.modelo.base.Entidade;
import br.com.capela.amicao.modelo.pet.Pet;

import br.com.capela.persistencia._

import java.io.Serializable;

import javax.persistence._

import scala.reflect._

@Entity
class Cliente extends Entidade[Cliente] with ActiveRecord[Cliente] {
	
	@Column{val name="codigo"}
    @BeanProperty var codigo:String = _
	
	@Column{val name="nome"}
    @BeanProperty var nome:String = _
	
    @OneToOne{
		val cascade = Array(CascadeType.ALL),
	    val targetEntity = classOf[Endereco]
    }
	@PrimaryKeyJoinColumn()
	@BeanProperty var endereco:Endereco = _
	
	@OneToOne{
		val cascade = Array(CascadeType.ALL),
	    val targetEntity = classOf[FormaDeContato]
	}
	@PrimaryKeyJoinColumn()
	@BeanProperty var formaDeContato:FormaDeContato = _
	
	@ManyToMany{
		val cascade = Array(CascadeType.ALL),
	    val targetEntity =  classOf[Pet],
	    val fetch = FetchType.LAZY 
	}
	@BeanProperty var pets : java.util.List[Pet] = new java.util.Vector[Pet]


	def isMesmaEntidade(outro:Cliente):Boolean =  {
		new EqualsBuilder()
			.append(nome, outro.nome)
			.append(endereco, outro.endereco)
			.isEquals();
	}

	override def hashCode():Int = {
		new HashCodeBuilder()
			.append(nome)
			.append(endereco)
			.toHashCode();
	}

}
