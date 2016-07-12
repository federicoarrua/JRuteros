package tests;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clasesDAO.ActividadDAO;
import clasesDAO.ImagenDAO;
import clasesDAO.PuntoDAO;
import clasesDAO.RutaDAO;
import clasesDAO.UsuarioDAO;
import clasesJruteros.Actividad;
import clasesJruteros.Imagen;
import clasesJruteros.Punto;
import clasesJruteros.Ruta;
import clasesJruteros.Usuario;
import enumJruteros.Dificultad;
import enumJruteros.Formato;
import enumJruteros.Genero;
import enumJruteros.Privacidad;
import hibernate.EntityHandler;

public class TestRutaDAO {
	
	public RutaDAO pruebaRutaDAO;
	
	@Before
	public void setUp() throws Exception {
		EntityHandler.setUp("jruteros");
		pruebaRutaDAO=new RutaDAO();
	}
	
	@Test
	public void testEliminarRuta() {
		try{
			Ruta ruta = crearRutaPrueba();
			if(!pruebaRutaDAO.guardarRuta(ruta))
				fail("No guardó la Ruta");

			if(!pruebaRutaDAO.eliminarRuta(ruta))
				fail("No eliminó la Ruta");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetRutas() {
		try{
			List<Ruta> resultList = pruebaRutaDAO.getRutas();
			if(resultList == null)
				fail("Fallo al guardar la Ruta");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetRutaPorID() {
		try{
			Ruta ruta = crearRutaPrueba();
			pruebaRutaDAO.guardarRuta(ruta);
			if(pruebaRutaDAO.getRutaPorId(ruta.getId()) == null)
				fail("No recuperó la Ruta");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testModificarRuta() {
		try{
			Ruta ruta = crearRutaPrueba();
			if(!pruebaRutaDAO.guardarRuta(ruta))
				fail("No guardó la Ruta");
			ruta.setNombre("Ruta x MOD");
			if(!pruebaRutaDAO.modificarRuta(ruta))
				fail("No modificó la Ruta");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	
	@Test
	public void testGuardarRuta() {
		try{
			Ruta ruta = crearRutaPrueba();
			if(!pruebaRutaDAO.guardarRuta(ruta))
				fail("Fallo al guardar la Ruta");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPuntosRuta(){
		try{
			Ruta ruta = crearRutaPrueba();
			if(!pruebaRutaDAO.guardarRuta(ruta))
				fail("Fallo al guardar la Ruta");
			if(pruebaRutaDAO.getPuntosRuta(ruta.getId()).isEmpty())
				fail("No recupera los puntos de la ruta");
		}
		catch(Exception e){
			
		}
	}
	
	@Test
	public void testEliminarRecorrido(){
		try{
			Ruta ruta = crearRutaPrueba();
			if(!pruebaRutaDAO.guardarRuta(ruta))
				fail("Fallo al guardar la Ruta");
			if(!pruebaRutaDAO.eliminarRecorrido(ruta.getId()))
				fail("Falló al eliminar el recorrido de la ruta");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEliminarPuntoRuta(){
		try{
			Ruta ruta = crearRutaPrueba();
			if(!pruebaRutaDAO.guardarRuta(ruta))
				fail("Fallo al guardar la Ruta");
			if(!pruebaRutaDAO.eliminarPuntoRuta(ruta.getId(), ruta.getPuntosRecorrido().get(0).getId()))
				fail("Falló al eliminar el punto de la ruta");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void agregarPuntoRuta(){
		try{
			Ruta ruta = crearRutaPrueba();
			if(!pruebaRutaDAO.guardarRuta(ruta))
				fail("Fallo al guardar la Ruta");
			
			Punto p = new Punto();
			p.setLat(new Float(1));
			p.setLng(new Float(1));
			
			if(!pruebaRutaDAO.agregarPuntoRuta(p, ruta.getId()))
				fail("Falló al agregar el punto a la ruta");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public Ruta crearRutaPrueba(){
		Ruta ruta = new Ruta();
		Actividad a = new Actividad();
		Usuario usr = new Usuario();
		Imagen img = new Imagen();
		Punto punto1 = new Punto();
		Punto punto2 = new Punto();
		
		UsuarioDAO usrDAO= new UsuarioDAO();
		ActividadDAO actDAO= new ActividadDAO();
		ImagenDAO imgDAO= new ImagenDAO();
		PuntoDAO puntoDAO= new PuntoDAO();
		
		a.setBorrada(true);
		a.setTipo("actividad test ruta");
		actDAO.guardarActividad(a);
		
		img.setNombre("Imagen test ruta");
		img.setUrl("google.com");
		imgDAO.guardarImagen(img);
		List<Imagen> listaImagen = new ArrayList<Imagen>();
		listaImagen.add(img);
		
		
		usr.setApellido("apellido");
		usr.setDni(12345678);
		usr.setDomicilio("1 entre 60 y 61");
		usr.setFechaNac(new Date(1990,11,11));
		usr.setEmail("usr@jruteros.com");
		usr.setNombres("nombres");
		usr.setPassword("contrasena");
		usr.setSexo(Genero.M);
		usr.setUsername("usr test ruta");
		usrDAO.guardarUsuario(usr);
		
		punto1.setLat(new Float(10));
		punto1.setLng(new Float(20));
		List<Punto> listaPunto = new ArrayList<Punto>();
		listaPunto.add(punto1);
		puntoDAO.guardarPunto(punto1);
		
		punto2.setLat(new Float(100));
		punto2.setLng(new Float(200));
		listaPunto.add(punto2);
		puntoDAO.guardarPunto(punto2);
		
		ruta.setActividad(a);
		ruta.setDescripcion("Ruta descripcion");
		ruta.setDificultad(Dificultad.DIFICIL);
		ruta.setDistancia(new Float(2));
		ruta.setDueno(usr);
		ruta.setFecha(new Date(1,1,2012));
		ruta.setFormato(Formato.CIRCULAR);
		ruta.setNombre("Ruta x");
		ruta.setPriv(Privacidad.PRIVADA);
		ruta.setTiempoEstimado(new Time(1,0,0));
		ruta.setImagenesRuta(listaImagen);
		ruta.setPuntosRecorrido(listaPunto);
		
		return ruta;

	}

}
