package br.com.capela.amicao.modelo.base;

import javax.persistence._

import scala.reflect._

@MappedSuperclass
abstract class Entidade[T] {
	
	@Id
	@GeneratedValue{ val strategy=GenerationType.IDENTITY }
   	@BeanProperty val id:Int= -1
    
}
