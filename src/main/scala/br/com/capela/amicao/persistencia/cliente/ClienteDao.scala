package br.com.capela.amicao.persistencia.cliente

import br.com.capela.amicao.modelo.cliente._

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class ClienteDao extends ClienteRepository{

    def salvar(entidade:Cliente) = {}

    def excluir(entidade:Cliente) = {}

    def listarTodos():java.util.List[Cliente] = { new java.util.ArrayList[Cliente]}
	
    def getById(id:Int):Cliente = {
    	new Cliente
    }
}

