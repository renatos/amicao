package br.com.capela.amicao.modelo;

import javax.persistence._

object EntityManager {
	private var em:EntityManager = Persistence createEntityManagerFactory "TesteAmicao" createEntityManager;
	
	def get(): EntityManager = em
}