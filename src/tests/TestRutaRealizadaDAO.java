package tests;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clasesDAO.ActividadDAO;
import clasesDAO.RutaDAO;
import clasesDAO.RutaRealizadaDAO;
import clasesDAO.UsuarioDAO;
import clasesJruteros.Actividad;
import clasesJruteros.Ruta;
import clasesJruteros.RutaRealizada;
import clasesJruteros.Usuario;
import enumJruteros.Dificultad;
import enumJruteros.Formato;
import enumJruteros.Genero;
import enumJruteros.Privacidad;
import hibernate.EntityHandler;

public class TestRutaRealizadaDAO {

	public RutaRealizadaDAO pruebaRutaRealizadaDAO;
	
	@Before
	public void setUp() throws Exception {
		EntityHandler.setUp("jruteros");
		pruebaRutaRealizadaDAO=new RutaRealizadaDAO();
	}
	
	@Test
	public void testEliminarRutaRealizada() {
		try{
			RutaRealizada RutaRealizada = crearRutaRealizadaPrueba();
			if(!pruebaRutaRealizadaDAO.guardarRutaRealizada(RutaRealizada))
				fail("No guardó la RutaRealizada");

			if(!pruebaRutaRealizadaDAO.eliminarRutaRealizada(RutaRealizada))
				fail("No eliminó la RutaRealizada");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetRutasRealizadas() {
		try{
			List<RutaRealizada> resultList = pruebaRutaRealizadaDAO.getRutasRealizadas();
			if(resultList == null)
				fail("Fallo al guardar la RutaRealizada");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetRutaRealizadaPorID() {
		try{
			RutaRealizada ruta = crearRutaRealizadaPrueba();
			pruebaRutaRealizadaDAO.guardarRutaRealizada(ruta);
			if(pruebaRutaRealizadaDAO.getRutaRealizadaPorId(ruta.getId()) == null)
				fail("No recuperó la RutaRealizada");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testModificarRutaRealizada() {
		try{
			RutaRealizada RutaRealizada = crearRutaRealizadaPrueba();
			if(!pruebaRutaRealizadaDAO.guardarRutaRealizada(RutaRealizada))
				fail("No guardó la RutaRealizada");
			RutaRealizada.setValoracion(5);
			if(!pruebaRutaRealizadaDAO.modificarRutaRealizada(RutaRealizada))
				fail("No modificó la RutaRealizada");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	
	@Test
	public void testGuardarRutaRealizada() {
		try{
			RutaRealizada RutaRealizada = crearRutaRealizadaPrueba();
			if(!pruebaRutaRealizadaDAO.guardarRutaRealizada(RutaRealizada))
				fail("Fallo al guardar la RutaRealizada");
			
		}
		catch(Exception e){
			
		}

	}
	
	public RutaRealizada crearRutaRealizadaPrueba(){
		RutaRealizada rutaRealizada = new RutaRealizada();
		Ruta ruta = new Ruta();
		Actividad a = new Actividad();
		Usuario usr = new Usuario();
		
		ActividadDAO actDAO = new ActividadDAO();
		UsuarioDAO usrDAO= new UsuarioDAO();
		RutaDAO rutaDAO= new RutaDAO();
		
		a.setBorrada(true);
		a.setTipo("actividad test rutaRealizada");
		actDAO.guardarActividad(a);
		
		usr.setApellido("apellido");
		usr.setDni(12345678);
		usr.setDomicilio("1 entre 60 y 61");
		usr.setFechaNac(new Date(1990,11,11));
		usr.setEmail("usr@jruteros.com");
		usr.setNombres("nombres");
		usr.setPassword("contrasena");
		usr.setSexo(Genero.M);
		usr.setUsername("usr test rutaRealizada");
		usrDAO.guardarUsuario(usr);
		
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
		rutaDAO.guardarRuta(ruta);
		
		rutaRealizada.setRuta(ruta);
		rutaRealizada.setUsuario(usr);
		rutaRealizada.setValoracion(10);
		
		return rutaRealizada;

	}

}
