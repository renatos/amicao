package br.com.capela.amicao.persistencia;

import br.com.capela.amicao.modelo.base.Entidade

import javax.persistence._

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class Dao[T <: Entidade[_]] {

	var em:EntityManager = null

	@PersistenceContext
	def setEntityManager(em:EntityManager)={
		this.em = em
	}

	@Transactional
	def salvar(entidade:T):Unit = {
		if (entidade.id < 0)
			em persist(entidade)
		else
			em merge(entidade)
	}

	@Transactional
	def excluir(entidade:T) {
		em remove(entidade)

	}

	@Transactional{val readOnly = true}
	def getById(clazz:Class[T], id:Int):T = {
		em.find(clazz,id).asInstanceOf[T]
	}

	@Transactional{val readOnly = true}
	def listarTodos(clazz:Class[_]):java.util.List[T] = {
		implicit def toQueryString(clazz:Class[_]):String = {String.format("select e from %s e order by e.id", clazz.getSimpleName())}

		var entidades:java.util.List[_] = em createQuery(clazz) getResultList()
		entidades.asInstanceOf[java.util.List[T]]
	}

	@Transactional{val readOnly = true}
	def findByQuery(consulta:Query):java.util.List[T] = {
		var entidades:java.util.List[_] = consulta getResultList()
		entidades.asInstanceOf[java.util.List[T]]
	}
}

