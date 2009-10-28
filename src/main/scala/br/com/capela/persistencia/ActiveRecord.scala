package br.com.capela.persistencia;

import javax.persistence._

trait ActiveRecord[T]{
	
	def salvar():Unit = { 
		var em = EntityManager get()
		var et:EntityTransaction = em getTransaction()
		et begin()
		em persist(this);
		em flush()
		et commit()
	}
	
	def deletar():Unit = {
		var em = EntityManager get()
		var et:EntityTransaction = em getTransaction()
		et begin()
		em remove(this);
		em flush()
		et commit()
	}
	
	def get(id:Int): T = {
		var em = EntityManager get()
		var et:EntityTransaction = em getTransaction()
		et begin()
		var entidade = em find(this.getClass(), id);
		em flush()
		et commit()
		entidade.asInstanceOf[T]
	}
}