package br.com.capela.amicao.modelo.pet

import org.scalatest.Spec;
import org.scalatest.BeforeAndAfter;
import org.scalatest.matchers.MustMatchers;

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit._

import br.com.capela.amicao.modelo.pet._
import br.com.capela.amicao.modelo.cliente._
import br.com.capela.persistencia._

import br.com.capela.amicao.modelo.base.Entidade

/*
@RunWith(classOf[JUnitRunner])
@ContextConfiguration
class PetSpec extends Spec with MustMatchers{

	describe("Pet") {
		it("deve ser persistida"){
			var pet:Pet = new Pet();
			pet salvar() ;
			pet.id must be > 0
			//ClienteRepository.listarTodos()
			pet nome = "Teste"
			pet salvar
		}
	}
}
*/
