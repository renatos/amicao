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

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration{val locations = Array("applicationContext-dataSourceCommon.xml")}
class PersistenciaCouchDBSpec{
	@Test
	def raca{
			var c:Cliente = new Cliente();
			c.pets.add(new Pet())
			c salvar() 
			println(c.id)
		}
}
