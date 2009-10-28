package br.com.capela.amicao

import org.junit._
import Assert._
  
class TestList  {
  @Test	
  def testLength = {
    assertTrue(List(1,2,3).length == 3)
    assertTrue(Nil.length == 0)
  }
}

import org.specs._
import org.specs.runner.JUnit4

class mySpecTest extends JUnit4(helloWorld)
object helloWorld extends Specification {
  "'hello world' has 11 characters" in {
     "hello world".size must_== 11
  }
  "'hello world' matches 'h.* w.*'" in {
	  println(this)
     "hello world" must be matching("h.* w.*")
  }
}
