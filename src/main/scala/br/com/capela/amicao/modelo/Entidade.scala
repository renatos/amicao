package br.com.capela.amicao.modelo;

import javax.persistence._

import scala.reflect._

@MappedSuperclass
abstract class Entidade[T] {
	@Id
	@GeneratedValue{ val strategy=GenerationType.IDENTITY }
    @BeanProperty var id:Int= _
}