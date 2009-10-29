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

@RunWith(classOf[JUnitRunner])
class PersistenciaCouchDBSpec extends Spec with ShouldMatchers with BeforeAndAfter {
	describe("Raca") {
		it("deve persistir uma nova raca"){
			var c:Cliente = new Cliente();
			c.pets.add(new Pet())
			c salvar() 
			println(c.id)
		}
	}
}
