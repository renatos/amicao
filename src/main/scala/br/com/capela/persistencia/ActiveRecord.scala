package br.com.capela.persistencia;

import br.com.capela.amicao.modelo.base.Entidade
import javax.persistence._

/*
object ExecutarTransacao{

	implicit def activeRecordToEntidade(activeRecord: ActiveRecord[_]):Entidade[_] = {
		activeRecord.asInstanceOf[Entidade[_]]
	}
	
	def usando(entidade:ActiveRecord[_])(codeBlock: (EntityManager, Entidade[_]) => Unit): Unit = {
		var em = EntityManager()
		var et:EntityTransaction = em getTransaction()
		et begin()
		try{
			codeBlock(em,entidade)
			em flush()
			et commit()	
		}
		catch {
			case ex : Exception => et rollback
		}
	}	
}

object Comando{
	def persistir(em:EntityManager, entidade: Entidade[_])={
		if (entidade.id < 0)
			em persist(entidade) 
		else 
			em merge(entidade)
	}
	def deletar(em:EntityManager, entidade: Entidade[_])={em remove(entidade)}
} 
*/

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
@Service
object teste {
	
	@scala.reflect.BeanProperty
	var entityManager:ApplicationEntityManager = null 
	
}

trait ActiveRecord[T <: Entidade[_]]{
	
	
	def salvar():Unit = { 
		println(teste.entityManager)//.entityManager.salvar(this.asInstanceOf[T])
	}
	
	def deletar():Unit = {
	}
	
}
