package br.com.capela.amicao.modelo.cliente

import org.scalatest.Spec;
import org.scalatest.BeforeAndAfter;
import org.scalatest.matchers._;
import org.scalatest.verb._;

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit._

import br.com.capela.amicao.modelo.pet._
import br.com.capela.amicao.modelo.cliente._

@RunWith(classOf[JUnitRunner])
class ClienteSpec extends Spec with MustMatchers{
	
	describe("Cliente") {
		it("deve ser persistido"){
			var cliente:Cliente = new Cliente();
			
		}
	}
}
