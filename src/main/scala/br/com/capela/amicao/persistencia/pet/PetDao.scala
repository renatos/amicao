package br.com.capela.amicao.persistencia.pet

import br.com.capela.persistencia._
import br.com.capela.amicao.modelo.pet._

import org.springframework.stereotype.Repository

import _root_.com.google.appengine.api.datastore.Key

@Repository
class PetDao extends Dao[Pet]  with PetRepository {

    def listarTodos():List[Pet] = {
        super.listarTodos(classOf[Pet])
    }
    
    def getById(id:Key):Pet = {
    	var pet = super.getById(classOf[Pet],id)
        pet
    }

}

