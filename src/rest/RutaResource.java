package rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import clasesDAO.PuntoDAO;
import clasesDAO.RutaDAO;
import clasesJruteros.Punto;

@Path("/rutas")
public class RutaResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	RutaDAO rutaDAO;
	PuntoDAO puntoDAO;
	
	public RutaResource(){
		rutaDAO = new RutaDAO();
	}
	
	/**
	 * Metodo GET que retorna los puntos de la ruta con id 'id'
	 * @param id
	 * @return
	 */
	@GET
	@Path("{ruta}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Punto> getPuntos(@PathParam("ruta") Long id) {
		return rutaDAO.getPuntosRuta(id);
	}	
	
	/**
	 * Metodo DELETE que elimina el punto con id 'idPunto' de la ruta con 
	 * id 'idRuta'. Si 'id' es null elimina todos los puntos de la ruta
	 * @param idRuta
	 * @param idPunto
	 */
	@DELETE
	@Path("{ruta}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void deletePuntoRecorrido(@PathParam("ruta") Long idRuta, 
			@FormParam("id") Long idPunto) {
		if(idPunto!= null)
			rutaDAO.eliminarPuntoRuta(idRuta,idPunto);
		else
			rutaDAO.eliminarRecorrido(idRuta);
	}
	
	
	/**
	 * Método POST que añade un punto a la ruta con id 'id' con la latitud
	 * y longitud recibidos como parámetros.
	 * @param latitud
	 * @param longitud
	 * @param id
	 * @param servletResponse
	 */
	@POST
	@Path("{ruta}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addPunto(@FormParam("lat") Float lat,
			@FormParam("lng") Float lng,
			@PathParam("ruta") Long id,
			@Context HttpServletResponse servletResponse){

		Punto p = new Punto();
		p.setLat(lat);
		p.setLng(lng);
		rutaDAO.agregarPuntoRuta(p, id);
	}
	
}

