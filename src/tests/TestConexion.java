package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import clasesJruteros.Actividad;

public class TestConexion {
	
	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jruteros");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		
		Actividad a = new Actividad();
		a.setBorrada(false);
		a.setTipo("Caminata");
		
		em.persist(a);
		
		a.setTipo("Caminata Persistida");
		
		etx.commit();
		em.close();
	}
}
