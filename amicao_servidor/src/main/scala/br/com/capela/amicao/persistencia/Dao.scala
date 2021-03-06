package br.com.capela.amicao.persistencia

;

import br.com.capela.amicao.modelo.base.Entidade

import javax.persistence._

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import _root_.com.google.appengine.api.datastore.Key;

@Repository
class Dao[T <: Entidade[_]] {
  var entityManager: EntityManager = null

  @PersistenceContext
  def setEntityManager(em: EntityManager) = this.entityManager = em

  def salvar(entidade: T): Unit = entidade.id match {
    case null => entityManager persist (entidade)
    case _ => entityManager merge (entidade)
  }

  def excluir(entidade: T) = entityManager remove (entityManager.merge(entidade))

  def getById(clazz: Class[T], id: Key): T = entityManager.find(clazz, id).asInstanceOf[T]

  @Transactional {val readOnly = true}
  def listarTodos(clazz: Class[_]): java.util.List[T] = {
    implicit def toQueryString(clazz: Class[_]): String = {String.format("select e from %s e order by e.id", clazz.getName())}

    var entidades: java.util.List[_] = entityManager createQuery (clazz) getResultList ()

    return entidades.asInstanceOf[java.util.List[T]]
  }

  def findByQuery(consulta: Query): java.util.List[T] = {
    var entidades: java.util.List[_] = consulta getResultList ()
    entidades.asInstanceOf[java.util.List[T]]
  }
}

