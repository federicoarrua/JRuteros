package clasesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesJruteros.Ruta;
import hibernate.EntityHandler;
import interfacesDAO.IRutaDAO;

public class RutaDAO implements IRutaDAO{


	@Override
	public boolean guardarRuta(Ruta ruta) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.persist(ruta);
			etx.commit();
			
			em.close();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Ruta getRutaPorId(Long id) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Ruta result = em.find(Ruta.class, id);
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Ruta> getRutas() {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("FROM Ruta");
			List resultList = q.getResultList();
			return resultList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modificarRuta(Ruta ruta) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.merge(ruta);
			etx.commit();
			
			em.close();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean eliminarRuta(Ruta ruta) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.remove(em.contains(ruta) ? ruta : em.merge(ruta));
			etx.commit();
			
			em.close();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
