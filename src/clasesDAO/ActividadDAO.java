package clasesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesJruteros.Actividad;
import hibernate.EntityHandler;
import interfacesDAO.IActividadDAO;

public class ActividadDAO implements IActividadDAO{

	@Override
	public boolean guardarActividad(Actividad act) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.persist(act);
			etx.commit();
			
			em.close();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Actividad> getActividades() {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("FROM Actividad");
			List resultList = q.getResultList();
			return resultList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Actividad getActividadPorId(Long id) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Actividad result = em.find(Actividad.class, id);
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Retorna una lista de actividades con el campo tipo igual 
	 * al pasado por parámetro
	 * @param tipo
	 */
	@Override
	public List<Actividad> getActividadPorTipo(String tipo) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("SELECT a FROM Actividad a WHERE a.tipo=?1");
			q.setParameter(1, tipo);
			
			@SuppressWarnings("unchecked")
			List<Actividad> result = q.getResultList();
			
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modificarActividad(Actividad act) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.merge(act);
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
	public boolean eliminarActividad(Actividad act) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.remove(em.contains(act) ? act : em.merge(act));
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
