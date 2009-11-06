package br.com.capela.amicao.servico;

import br.com.capela.amicao.modelo.base.Entidade

import br.com.capela.persistencia.Repository;

import br.com.capela.amicao.modelo.pet.PetRepository
import org.springframework.beans.factory.annotation.Autowired


class Service[T <: Entidade[_]]{
    
    var repository:Repository[T] = null

    def salvar(entidade:T) = this.repository.salvar(entidade)    

    def excluir(entidade:T) = this.repository.excluir(entidade)    

    def listarTodos():java.util.List[T] = this.repository.listarTodos()    
    
    def getById(id:Int):T = this.repository.getById(id)
	
}
