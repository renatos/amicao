package br.com.capela.amicao.modelo.pet


import br.com.capela.amicao.servico.cliente.ClienteService
import br.com.capela.amicao.servico.pet.PetService

import br.com.capela.amicao.modelo.pet._
import br.com.capela.amicao.modelo.cliente.Cliente

import org.junit._
import org.junit.Assert._

import org.springframework.beans.factory.annotation.Autowired


class PetServiceTest extends AbstractAppEngineJpaTests{
 
    private var clienteService:ClienteService = _
    private var petService:PetService = _

    @Autowired
    def setClienteService(service:ClienteService) = this.clienteService = service

    @Autowired
    def setPetService(service:PetService) = this.petService = service
    
    @Test
    def persistirPet{
        var pet:Pet = new Pet();
        pet.proprietario = new Cliente()
        pet.proprietario.nome = "Renato"
        pet.nome = "Ian"
        petService salvar pet
        assertTrue(petService.listarTodos().size > 0)
    }

    @Test
    def recuperarPet{
        var pet:Pet = new Pet();
        pet.proprietario = new Cliente()
        pet.nome = "Veludo"
        petService salvar pet
        var petRecuperado = petService.getById(pet id)
        assertEquals("Veludo",petRecuperado.nome)
        assertEquals(SexoEnum.indefinido,petRecuperado.sexo)
        assertEquals(EspecieEnum.indefinida,petRecuperado.especie)

    }

    @Test
    def removerPet{
        var pet:Pet = new Pet();
        pet.proprietario = new Cliente()
        pet.nome = "Pink"
        petService salvar pet
        var numeroDePetsAntesDaExclusao = petService.listarTodos().size
        var petRecuperado = petService.getById(pet id)
        petService excluir pet
        assertTrue(numeroDePetsAntesDaExclusao > petService.listarTodos().size)
    }

}
