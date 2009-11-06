package br.com.capela.amicao.modelo.servico;

import br.com.capela.amicao.modelo.pet.Pet

import org.springframework.stereotype.{Service,Component}
import br.com.capela.amicao.modelo.pet.PetRepository
import org.springframework.beans.factory.annotation.Autowired

import scala.reflect._

@Service
class PetService{


    private var repository:PetRepository = _

    @Autowired
    def setRepository(repository:PetRepository) = this.repository = repository

    def salvar(pet:Pet)={
        this.repository.salvar(pet);
    }

}

