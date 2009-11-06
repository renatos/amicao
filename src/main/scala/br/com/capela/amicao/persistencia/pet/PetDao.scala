package br.com.capela.amicao.persistencia.pet

import br.com.capela.persistencia._
import br.com.capela.amicao.modelo.pet._

import org.springframework.stereotype.Repository

@Repository
class PetDao extends Dao[Pet]  with PetRepository {

    def listarTodos():java.util.List[Pet] = {
        super.listarTodos(classOf[Pet])
    }
    
    def getById(id:Int):Pet = {
    	super.getById(classOf[Pet],id)
    }

}

