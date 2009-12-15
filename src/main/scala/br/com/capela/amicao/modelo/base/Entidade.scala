package br.com.capela.amicao.modelo.base;

import javax.persistence._

import scala.reflect._

import _root_.com.google.appengine.api.datastore.Key;

@MappedSuperclass
trait Entidade[T]{

	@Id
	@GeneratedValue{ val strategy=GenerationType.IDENTITY }
   	@BeanProperty var id:Key = _
	
	override def equals(outraEntidade:Any) = outraEntidade match { 
	  case outra: Entidade[T] => outra.getClass == getClass && this.isMesmaEntidade(outra.asInstanceOf[T]);
   	  case _ => false
	}
	
	def isMesmaEntidade(outraEntidade: T):Boolean;
}

