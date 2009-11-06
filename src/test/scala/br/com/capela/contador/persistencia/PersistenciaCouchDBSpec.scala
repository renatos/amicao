package br.com.capela.contador.persistencia

import org.scalatest.Spec;
import org.scalatest.BeforeAndAfter;
import org.scalatest.matchers.ShouldMatchers;
import org.scalatest.verb._;

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit._

import br.com.capela.amicao.modelo.pet._
import br.com.capela.amicao.modelo.cliente._
import br.com.capela.persistencia._
import br.com.capela.amicao.servico.pet.PetService

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration{val locations = Array("classpath*:**applicationContext-jpa.xml")}
class PersistenciaCouchDBSpec{

    private var service:PetService = _

    @Autowired
    def setService(service:PetService) = this.service = service

	@Test
	def raca{
			var c:Cliente = new Cliente();
			c.pets.add(new Pet())
            service.salvar(new Pet())
           	
           	println(service.listarTodos())
           	 
           
			println("service!!!! "+service)
		}
}

