package br.com.capela.amicao.servico

;

import br.com.capela.amicao.modelo.base.Entidade

import br.com.capela.persistencia.Repository
import org.springframework.security.access.annotation.Secured;

import org.springframework.transaction.annotation.Transactional
import org.springframework.flex.remoting.RemotingDestination;

import org.springframework.flex.remoting.RemotingInclude;

import javax.persistence.Query

import _root_.com.google.appengine.api.datastore.Key;

@Transactional
@org.springframework.stereotype.Service
@RemotingDestination {val channels = Array("amf", "secure-amf")}
class Service[T <: Entidade[_]] {
  var repository: Repository[T] = null

  @Transactional
  @RemotingInclude
  @Secured {val value = Array("IS_AUTHENTICATED_ROLE_GOOGLE_APP_USER")}
  def salvar(entidade: T) = this.repository.salvar(entidade)

  @Transactional
  @RemotingInclude
  @Secured {val value = Array("IS_AUTHENTICATED_ROLE_GOOGLE_APP_ADMIN")}
  def excluir(entidade: T) = this.repository.excluir(entidade)

  @Transactional {val readOnly = true}
  @RemotingInclude
  @Secured {val value = Array("IS_AUTHENTICATED_ROLE_GOOGLE_APP_USER")}
  def listarTodos(): java.util.List[T] = {var entidades = this.repository.listarTodos(); println("ENTIDADES: " + entidades); return entidades}

  @Transactional {val readOnly = true}
  @RemotingInclude
  @Secured {val value = Array("IS_AUTHENTICATED_ROLE_GOOGLE_APP_USER")}
  def getById(id: Key): T = this.repository.getById(id)

  @Transactional {val readOnly = true}
  @RemotingInclude
  @Secured {val value = Array("IS_AUTHENTICATED_ROLE_GOOGLE_APP_USER")}
  def findByQuery(consulta: Query): java.util.List[T] = this.repository.findByQuery(consulta)
}

