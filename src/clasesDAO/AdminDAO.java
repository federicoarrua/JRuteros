package clasesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesJruteros.Admin;
import hibernate.EntityHandler;
import interfacesDAO.IAdminDAO;

public class AdminDAO implements IAdminDAO{

	@Override
	public boolean guardarAdmin(Admin admin) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.persist(admin);
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
	public Admin getAdmin(Long id) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Admin result = em.find(Admin.class, id);
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Admin> getAdmins() {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("FROM Admin");
			List resultList = q.getResultList();
			return resultList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modificarAdmin(Admin admin) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.merge(admin);
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
	public boolean eliminarAdmin(Admin admin) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.remove(em.contains(admin) ? admin : em.merge(admin));
			etx.commit();
			
			em.close();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Admin> getAdminPorUsername(String username) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("SELECT a FROM Admin a WHERE a.username=?1");
			q.setParameter(1, username);
			
			@SuppressWarnings("unchecked")
			List<Admin> result = q.getResultList();
			
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean validarAdmin(String username,String password) {
		try{
			Admin a = this.getAdminPorUsername(username).get(0);
			if(a.getPassword().equals(password))
				return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
