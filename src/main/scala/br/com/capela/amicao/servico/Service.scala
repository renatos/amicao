package br.com.capela.amicao.servico;

import br.com.capela.amicao.modelo.base.Entidade

import br.com.capela.persistencia.Repository;

import br.com.capela.amicao.modelo.pet.PetRepository
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.transaction.annotation.Transactional

import javax.persistence.Query

@Transactional
class Service[T <: Entidade[_]]{
    
    var repository:Repository[T] = null
    
    @Transactional
    def salvar(entidade:T) = this.repository.salvar(entidade)    
    
    @Transactional
    def excluir(entidade:T) = this.repository.excluir(entidade)    
    
    @Transactional{val readOnly = true}
    def listarTodos():List[T] = this.repository.listarTodos()    
    
    @Transactional{val readOnly = true}
    def getById(id:Long):T = this.repository.getById(id)
	
    @Transactional{val readOnly = true}
	def findByQuery(consulta:Query):java.util.List[T] = this.repository.findByQuery(consulta)
}
