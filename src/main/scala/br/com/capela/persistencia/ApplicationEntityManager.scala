package br.com.capela.persistencia;

import br.com.capela.amicao.modelo.base.Entidade

import javax.persistence._

import org.hibernate.SessionFactory 

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class ApplicationEntityManager {
	
	@PersistenceContext
	var em:EntityManager = _
	
	@Transactional
	def salvar(entidade:Entidade[_]):Unit = {
		if (entidade.id < 0)
			em persist(entidade) 
		else 
			em merge(entidade)
	}
	
	@Transactional
	def excluir(entidade:Entidade[_]) {
		em remove(entidade)
	}
	
	@Transactional{val readOnly = true}
	def find(clazz:Class[_], id:Int):Entidade[_] = {
		var entidade = find(clazz,id)
		entidade.asInstanceOf[Entidade[_]]
	}
	
	@Transactional{val readOnly = true}
	def findAll(clazz:Class[_]):java.util.List[Entidade[_]] = {
		implicit def toQueryString(clazz:Class[_]):String = {String.format("select e from %s e order by e.id", clazz.getSimpleName())}
		
		var entidades:java.util.List[_] = em createQuery(clazz) getResultList()
		entidades.asInstanceOf[java.util.List[Entidade[_]]]
	}
	
	@Transactional{val readOnly = true}
	def findByQuery(consulta:Query):java.util.List[Entidade[_]] = {
		var entidades:java.util.List[_] = consulta getResultList()
		entidades.asInstanceOf[java.util.List[Entidade[_]]]
	}
}
	
