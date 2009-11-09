package br.com.capela.amicao.persistencia.cliente

import br.com.capela.amicao.modelo.cliente._

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class ClienteDao extends Dao[Cliente]  with ClienteRepository {

    def listarTodos():List[Cliente] = {
        super.listarTodos(classOf[Cliente])
    }

    def getById(id:Int):Cliente = {
    	var cliente = super.getById(classOf[Cliente],id)
    	if(cliente != null)
            cliente.pets.iterator
    	cliente
    }
}

