package br.com.capela.amicao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Main {
	@Temporal(TemporalType.DATE)
	public static void main(String[] args) throws IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesteAmicao");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		B test = new B();
		System.out.println(test);
		Base base = test;
		System.out.println(base);
	}
}

class Base {
}

class B extends Base {

}
