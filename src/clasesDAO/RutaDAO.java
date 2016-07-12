package clasesDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesJruteros.Punto;
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
	
	/**
	 * Retorna la lista de puntos del recorrido de la ruta con id 'id'
	 * @param id
	 */
	@Override
	public List<Punto> getPuntosRuta(Long id){
		try{
			EntityManager em = EntityHandler.getEntityManager();
			Query q = em.createQuery("SELECT p FROM Ruta r JOIN"
					+ " r.puntosRecorrido p"
					+ " WHERE r.Id = ?1");
			q.setParameter(1, id);
			
			@SuppressWarnings("unchecked")
			List<Punto> resultList = q.getResultList();
			
			return resultList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Elimina toda la lista de puntos del recorrido de la ruta con id
	 * 'id'
	 * @param id
	 */
	@Override
	public boolean eliminarRecorrido(Long id){
		try{
			Ruta ruta = this.getRutaPorId(id);
			ruta.setPuntosRecorrido(new ArrayList<Punto>());
			return this.modificarRuta(ruta);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Elimina el punto con id 'idPunto' de la lista de puntos del recorrido
	 * de la ruta con id 'idRuta'
	 * @param idRuta
	 * @param idPunto
	 */
	@Override
	public boolean eliminarPuntoRuta(Long idRuta,Long idPunto){
		try{
			Ruta ruta = this.getRutaPorId(idRuta);
			List<Punto> listaRecorrido = ruta.getPuntosRecorrido();
			Iterator<Punto> iterador = listaRecorrido.iterator();
			
			while(iterador.hasNext()){
				Punto p = iterador.next();
				if(p.getId() == idPunto){
					listaRecorrido.remove(p);
					break;
				}
			}
			
			return this.modificarRuta(ruta);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Agrega el punto 'p' a la ruta con id 'id', si no está
	 * en la base de datos crea uno sino utiliza uno con la misma
	 * latitud y longitud que 'p'
	 * @param p
	 * @param id
	 */
	@Override
	public boolean agregarPuntoRuta(Punto p,Long id){
		try{
			Ruta ruta = this.getRutaPorId(id);
			PuntoDAO puntoDAO = new PuntoDAO();
			List<Punto> puntos = puntoDAO.getPuntoPorLugar(p.getLat(),p.getLng());
			Punto punto;
			
			if(puntos.isEmpty()){
				punto = p;
				puntoDAO.guardarPunto(punto);
			}
			else{
				punto = puntos.get(0);
			}
			
			ruta.getPuntosRecorrido().add(punto);
			
			return this.modificarRuta(ruta);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
