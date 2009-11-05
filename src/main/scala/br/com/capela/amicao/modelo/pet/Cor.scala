package br.com.capela.amicao.modelo.pet;

import br.com.capela.amicao.modelo.base.Entidade
import br.com.capela.persistencia._

import java.io.Serializable;

import javax.persistence._

import scala.reflect._

@Entity
class Cor(_codigo:String, _nome:String) extends Entidade[Cor] with ActiveRecord[Cor] {

	def this() = this("","");
	
    	@Column{val name="codigo"}
    	@BeanProperty var codigo: String = _codigo

    	@Column{val name="nome"}
    	@BeanProperty var nome:String = _nome

}
