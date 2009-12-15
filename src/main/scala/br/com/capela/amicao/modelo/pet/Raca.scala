package br.com.capela.amicao.modelo.pet;

import org.apache.commons.lang.builder.{EqualsBuilder, HashCodeBuilder, ReflectionToStringBuilder, ToStringStyle};

import br.com.capela.amicao.modelo.base.Entidade

import java.io.Serializable;

import javax.persistence._

import _root_.com.google.appengine.api.datastore.Key;

import scala.reflect._

@Entity
class Raca(_codigo: String, _nome: String) extends Entidade[Raca] {

    def this() = this("","");

    @Column{val name="codigo"}
    @BeanProperty var codigo: String = _codigo

    @Column{val name="nome"}
    @BeanProperty var nome:String = _nome
    
    def isMesmaEntidade(outro:Raca):Boolean =  {
       new EqualsBuilder()
      .append(codigo, outro.codigo)
      .append(nome, outro.nome)
      .isEquals();
    }

 	override def hashCode():Int = {
 	    new HashCodeBuilder()
        .append(codigo)
        .append(nome)
        .toHashCode();
	}
 	
 	override def toString() = ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE)
}

