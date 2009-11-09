package br.com.capela.amicao.servico.cliente;

import br.com.capela.amicao.modelo.cliente.Cliente

import br.com.capela.amicao.servico.Service

import br.com.capela.amicao.modelo.cliente.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired

import scala.reflect._

@org.springframework.stereotype.Service
class ClienteService extends Service[Cliente]{
    @Autowired
    def setRepository(repository:ClienteRepository)= this.repository = repository
}

