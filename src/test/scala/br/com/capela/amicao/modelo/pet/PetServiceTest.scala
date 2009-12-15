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
        assertTrue(pet.id != null)
        assertTrue(petService.listarTodos().size > 0)
    }

    @Test
    def recuperarPet{
        var pet:Pet = new Pet();
        var renato:Cliente = new Cliente()
        renato.nome = "Renato"
        pet.proprietario = renato
        pet.especie = EspecieEnum.canina
        pet.sexo = SexoEnum.macho
        pet.nome = "Veludo"
        petService salvar pet
        var petRecuperado = petService.getById(pet id)
        assertEquals("Veludo",petRecuperado.nome)
        assertEquals("Renato",petRecuperado.proprietario.nome)
        assertEquals(SexoEnum.macho,petRecuperado.sexo)
        assertEquals(EspecieEnum.canina,petRecuperado.especie)

    }

    @Test
    def alterarPet{
        var pet:Pet = new Pet();
        var renato:Cliente = new Cliente()
        renato.nome = "Renato"
        pet.proprietario = renato
        pet.especie = EspecieEnum.canina
        pet.sexo = SexoEnum.macho
        pet.nome = "Veludo"
        petService salvar pet
        var petRecuperado = petService.getById(pet id)
        assertEquals("Veludo",petRecuperado.nome)
        assertEquals("Renato",petRecuperado.proprietario.nome)
        assertEquals(SexoEnum.macho,petRecuperado.sexo)
        assertEquals(EspecieEnum.canina,petRecuperado.especie)
        
        petRecuperado
        petRecuperado.proprietario.nome = "Renato 2"
        petRecuperado.especie = EspecieEnum.felina
        petRecuperado.sexo = SexoEnum.femea
        petRecuperado.nome = "Lina"

	petService salvar petRecuperado
	
	petRecuperado = petService.getById(petRecuperado id)
        assertEquals("Lina",petRecuperado.nome)
        assertEquals("Renato 2",petRecuperado.proprietario.nome)
        assertEquals(SexoEnum.femea,petRecuperado.sexo)
        assertEquals(EspecieEnum.felina,petRecuperado.especie)
	
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
