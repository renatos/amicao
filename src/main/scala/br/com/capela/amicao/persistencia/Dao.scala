package br.com.capela.amicao.persistencia;

import br.com.capela.amicao.modelo.base.Entidade

import javax.persistence._

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class Dao[T <: Entidade[_]] {

	var em:EntityManager = null

	@PersistenceContext
	def setEntityManager(em:EntityManager)={
		this.em = em
	}

	
	def salvar(entidade:T):Unit = {
		if (entidade.id < 0)
			em persist(entidade)
		else
			em merge(entidade)
	}

	def excluir(entidade:T) {
		em remove(em.merge(entidade))
	}
	
	def getById(clazz:Class[T], id:Long):T = {
		em.find(clazz,id).asInstanceOf[T]
	}

	def listarTodos(clazz:Class[_]):List[T] = {
		implicit def toQueryString(clazz:Class[_]):String = {String.format("select e from %s e order by e.id", clazz.getSimpleName())}

		var entidades:java.util.List[_] = em createQuery(clazz) getResultList()
		List.fromArray(entidades.toArray()).asInstanceOf[List[T]]
	}

	def findByQuery(consulta:Query):java.util.List[T] = {
		var entidades:java.util.List[_] = consulta getResultList()
		entidades.asInstanceOf[java.util.List[T]]
	}
}

