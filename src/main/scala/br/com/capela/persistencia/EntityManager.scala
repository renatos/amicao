package br.com.capela.persistencia;

import br.com.capela.amicao.modelo.base.Entidade

import javax.persistence._

object EntityManager {
	private var em:EntityManager = Persistence createEntityManagerFactory "TesteAmicao" createEntityManager;
	
	def apply(): EntityManager = em
	
	def salvar(entidade:Entidade[_]):Unit = {
		if (entidade.id < 0)
			em persist(entidade) 
		else 
			em merge(entidade)
	}
	
	def excluir(entidade:Entidade[_]) {
		em remove(entidade)
	}
	
	def find(clazz:Class[_], id:Int):Entidade[_] = {
		var entidade = find(clazz,id)
		entidade.asInstanceOf[Entidade[_]]
	}
	
	def findAll(clazz:Class[_]):java.util.List[Entidade[_]] = {
		implicit def toQueryString(clazz:Class[_]):String = {String.format("select e from %s e order by e.id", clazz.getSimpleName())}
		
		var entidades:java.util.List[_] = em createQuery(clazz) getResultList()
		entidades.asInstanceOf[java.util.List[Entidade[_]]]
	}
	
	def findByQuery(umaConsulta:Query):java.util.List[Entidade[_]] = {
		var entidades:java.util.List[_] = em createQuery(umaConsulta) getResultList()
		entidades.asInstanceOf[java.util.List[Entidade[_]]]
	}
}

class ExecutarEmTransacao(et:EntityTransaction){
	def usando(codeBlock: (EntityManager, Entidade[_]) => Unit): Unit = {
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
