package br.com.capela.amicao.modelo.pet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

//import br.com.capela.amicao.modelo.base.Entidade;
import scala.reflect._

@Entity
class Raca2(first: String, last: String) extends Entidade[Raca2] with ActiveRecord[Raca2]{
	
	def this() = this("","");
	
    @Column{val name="firstname"}
    @BeanProperty var firstname: String = first

    @Column{val name="lastname"}
    @BeanProperty var lastname:String = last
}

