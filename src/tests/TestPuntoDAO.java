package tests;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clasesDAO.PuntoDAO;
import clasesJruteros.Punto;
import hibernate.EntityHandler;

public class TestPuntoDAO {

public PuntoDAO pruebaPuntoDAO;	
	
	@Before
	public void setUp() throws Exception {
		EntityHandler.setUp("jruteros");
		pruebaPuntoDAO=new PuntoDAO();
	}
	
	@Test
	public void testGuardarPunto() {
		try{
			Punto punto = crearPuntoPrueba();
			if(!pruebaPuntoDAO.guardarPunto(punto))
				fail("Fallo al guardar la Punto");
			
		}
		catch(Exception e){
			
		}

	}
	
	@Test
	public void testGetPuntos() {
		try{
			List<Punto> resultList = pruebaPuntoDAO.getPuntos();
			if(resultList == null)
				fail("Fallo al guardar la Punto");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPuntoPorID() {
		try{
			Punto punto = crearPuntoPrueba();
			pruebaPuntoDAO.guardarPunto(punto);
			if(pruebaPuntoDAO.getPuntoPorId(punto.getId()) == null)
				fail("No recuperó la Punto");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testModificarPunto() {
		try{
			Punto punto = crearPuntoPrueba();
			if(!pruebaPuntoDAO.guardarPunto(punto))
				fail("No guardó la Punto");
			punto.setLatitud(new Float(1000));
			if(!pruebaPuntoDAO.modificarPunto(punto))
				fail("No modificó la Punto");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testEliminarPunto() {
		try{
			Punto punto = crearPuntoPrueba();
			if(!pruebaPuntoDAO.guardarPunto(punto))
				fail("No guardó al Punto");

			if(!pruebaPuntoDAO.eliminarPunto(punto))
				fail("No eliminó un Punto");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public Punto crearPuntoPrueba(){
		Punto punto = new Punto();
		punto.setLatitud(new Float(2));
		punto.setLongitud(new Float(5));
		return punto;
	}
	
}
