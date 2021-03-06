package clasesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesJruteros.Usuario;
import hibernate.EntityHandler;
import interfacesDAO.IUsuarioDAO;

public class UsuarioDAO implements IUsuarioDAO{

	@Override
	public boolean guardarUsuario(Usuario usr) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.persist(usr);
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
	public List<Usuario> getUsuarios() {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("FROM Usuario");
			List resultList = q.getResultList();
			return resultList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario getUsuarioPorId(Long id) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Usuario result = em.find(Usuario.class, id);
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Retorna una lista de usuarios con el mismo username que el
	 * pasado por parámetro.
	 * @param username
	 */
	@Override
	public List<Usuario> getUsuarioPorUsername(String username) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.username=?1");
			q.setParameter(1, username);
			
			@SuppressWarnings("unchecked")
			List<Usuario> result = q.getResultList();
			
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modificarUsuario(Usuario usr) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.merge(usr);
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
	public boolean eliminarUsuario(Usuario usr) {
		try{
			EntityManager em = EntityHandler.getEntityManager();
			EntityTransaction etx = em.getTransaction();
			
			etx.begin();
			em.remove(em.contains(usr) ? usr : em.merge(usr));
			etx.commit();
			
			em.close();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validarUsuario(String username,String password) {
		try{
			Usuario u = this.getUsuarioPorUsername(username).get(0);
			if(u.getPassword().equals(password) && u.getEnable())
				return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}
