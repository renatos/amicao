package br.com.capela.contador.persistencia

import org.scalatest.Spec;
import org.scalatest.BeforeAndAfter;
import org.scalatest.matchers.ShouldMatchers;
import org.scalatest.verb._;

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit._

import br.com.capela.amicao.modelo.pet._
import br.com.capela.persistencia._

@RunWith(classOf[JUnitRunner])
class PersistenciaCouchDBSpec extends Spec with ShouldMatchers with BeforeAndAfter {
	describe("Raca") {
		it("deve persistir uma nova raca"){
			var srd:Raca = new Raca();
			srd salvar() 
			println(srd.id)
		}
	}
}
