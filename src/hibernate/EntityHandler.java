package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityHandler {
    private static EntityManagerFactory emf;
    private static EntityManager entityManager;
    private static String up = "jruteros";
    
    public static EntityManager getEntityManager(){
    	if (emf == null){      
        	emf = Persistence.createEntityManagerFactory(getUp());
        }
        entityManager = emf.createEntityManager();    
        return entityManager;
    }


	public static String getUp() {
		return up;
	}

	public static void setUp(String up) {
		EntityHandler.up = up;
	}
    
}
