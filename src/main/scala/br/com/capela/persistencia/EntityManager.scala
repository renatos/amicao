package br.com.capela.persistencia;

import javax.persistence._

object EntityManager {
	private var em:EntityManager = Persistence createEntityManagerFactory "TesteAmicao" createEntityManager;
	
	def apply(): EntityManager = em
}
