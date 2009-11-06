package br.com.capela.amicao.servico.pet;

import br.com.capela.amicao.modelo.pet.Pet

import br.com.capela.amicao.servico.Service

import br.com.capela.amicao.modelo.pet.PetRepository
import org.springframework.beans.factory.annotation.Autowired

import scala.reflect._

@org.springframework.stereotype.Service
class PetService extends Service[Pet]{
	
    @Autowired
    def setRepository(repository:PetRepository)= this.repository = repository
	

}

