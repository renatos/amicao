package br.com.capela.amicao.modelo.cliente;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import br.com.capela.amicao.modelo.base.Entidade;
import br.com.capela.amicao.modelo.pet.Pet;

import java.io.Serializable;

import javax.persistence._

import scala.reflect._

@Entity
class Endereco extends Entidade[Endereco] {
	
	@Column{val name="logradouro"}
    @BeanProperty var logradouro:String = _
    
    @Column{val name="numero"}
    @BeanProperty var numero:String = _
    
    @Column{val name="bairro"}
    @BeanProperty var bairro:String = _
    
    @Column{val name="cidade"}
    @BeanProperty var cidade:String = _
    
    @Column{val name="cep"}
    @BeanProperty var cep:String = _
	
	def isMesmaEntidade(outro:Endereco):Boolean =  {
		new EqualsBuilder()
			.append(numero, outro.numero)
			.append(bairro, outro.bairro)
			.append(cep, outro.cep)
			.isEquals();
	}

	override def hashCode():Int = {
		new HashCodeBuilder()
			.append(logradouro)
			.append(numero)
			.append(bairro)
			.append(cep)
			.toHashCode();
	}
}
