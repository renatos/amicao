package br.com.capela.amicao.persistencia.pet

import br.com.capela.persistencia._
import br.com.capela.amicao.modelo.pet._

import org.springframework.stereotype.Repository

@Repository
class PetDao extends Dao[Pet]  with PetRepository {

    def listarTodos():List[Pet] = {
        super.listarTodos(classOf[Pet])
    }
    
    def getById(id:Long):Pet = {
    	var pet = super.getById(classOf[Pet],id)
        if(pet != null)
            pet.proprietarios.iterator
        pet
    }

}

