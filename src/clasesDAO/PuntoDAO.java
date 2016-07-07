package clasesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesJruteros.Punto;
import hibernate.EntityHandler;
import interfacesDAO.IPuntoDAO;

public class PuntoDAO implements IPuntoDAO {
	
	@Override
	public boolean guardarPunto(Punto punto) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.persist(punto);
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
	public Punto getPuntoPorId(Long id) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Punto result = em.find(Punto.class, id);
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Punto> getPuntos() {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("FROM Punto");
			List resultList = q.getResultList();
			return resultList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modificarPunto(Punto Punto) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.merge(Punto);
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
	public boolean eliminarPunto(Punto punto) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.remove(em.contains(punto) ? punto : em.merge(punto));
			etx.commit();
			
			em.close();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Retorna una lista de puntos con la misma longitud y latitud de los
	 * parámetros 'latitud' y 'longitud'
	 * @param latitud
	 * @param longitud
	 */
	@Override
	public List<Punto> getPuntoPorLugar(Float latitud, Float longitud) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("SELECT p FROM Punto p "
					+ "WHERE p.lat=?1 AND p.lng=?2");
			q.setParameter(1,latitud);
			q.setParameter(2, longitud);
			List<Punto> resultList = q.getResultList();
			return resultList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
