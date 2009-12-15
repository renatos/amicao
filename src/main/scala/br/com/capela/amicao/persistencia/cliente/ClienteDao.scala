package br.com.capela.amicao.persistencia.cliente

import br.com.capela.amicao.modelo.cliente._

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import _root_.com.google.appengine.api.datastore.Key

@Repository
class ClienteDao extends Dao[Cliente]  with ClienteRepository {
	
    def listarTodos():List[Cliente] = {
        var clientes:List[Cliente] = super.listarTodos(classOf[Cliente])
        clientes
    }

    def getById(id:Key):Cliente = {
    	var cliente = super.getById(classOf[Cliente],id)
    	cliente.pets.size
    	cliente
    }
    
}

