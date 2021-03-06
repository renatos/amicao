package br.com.capela.amicao.modelo.cliente

import br.com.capela.amicao.servico.cliente.ClienteService
import br.com.capela.amicao.servico.pet.PetService

import br.com.capela.amicao.modelo.pet.Pet

import org.junit._
import org.junit.Assert._

import org.springframework.beans.factory.annotation.Autowired

import br.com.capela.amicao.AbstractAppEngineJpaTests

class ClienteServiceTest extends AbstractAppEngineJpaTests {
  private var clienteService: ClienteService = _
  private var petService: PetService = _

  @Autowired
  def setClienteService(service: ClienteService) = this.clienteService = service

  @Autowired
  def setPetService(service: PetService) = this.petService = service

  @Test
  def persistirCliente {
    var cliente: Cliente = new Cliente();
    cliente.pets.add(new Pet())
    cliente.nome = "Renato"
    clienteService salvar cliente
    assertTrue(clienteService.listarTodos().size() > 0)
  }

  @Test
  def recuperarCliente {
    var cliente: Cliente = new Cliente();
    cliente.pets.add(new Pet())
    cliente.nome = "Renato"
    clienteService salvar cliente
    var clienteRecuperado = clienteService.getById(cliente id)
    assertEquals(clienteRecuperado.nome, "Renato")
    assertEquals(clienteRecuperado.pets.size, 1)
  }

  @Test
  def removerCliente {
    var cliente: Cliente = new Cliente();
    cliente.pets.add(new Pet())
    cliente.nome = "Renato"
    clienteService salvar cliente
    var numeroDeClientesAntesDaExclusao = clienteService.listarTodos().size()
    var clienteRecuperado = clienteService.getById(cliente.id)
    clienteService excluir cliente
    assertTrue(numeroDeClientesAntesDaExclusao > clienteService.listarTodos().size())
  }

  @Test
  def removeClienteENaoRemovePet {
    var renato: Cliente = new Cliente();
    var toby: Pet = new Pet();
    var leao: Pet = new Pet();

    renato.pets.add(toby)
    renato.pets.add(leao)

    clienteService salvar renato
    var clienteRecuperado = clienteService.getById(renato.id)

    assertTrue(petService.listarTodos().size() == 2)
    assertTrue(clienteRecuperado.pets.size == 2)

  }


}

