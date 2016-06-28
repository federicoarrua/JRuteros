package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clasesDAO.ActividadDAO;
import clasesJruteros.Actividad;
import hibernate.EntityHandler;

public class TestActividadDAO {
	
	public ActividadDAO pruebaActividadDAO;
	public String tipo="unTipo";
	public boolean borrada=false;
	
	
	@Before
	public void setUp() throws Exception {
		EntityHandler.setUp("jruteros");
		pruebaActividadDAO=new ActividadDAO();
	}
	
	@Test
	public void testGetActividades() {
		try{
			List<Actividad> resultList = pruebaActividadDAO.getActividades();
			if(resultList == null)
				fail("Fallo al guardar la actividad");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetActividadesPorID() {
		try{
			Actividad act = crearActividadPrueba();
			pruebaActividadDAO.guardarActividad(act);
			if(pruebaActividadDAO.getActividadPorId(act.getId()) == null)
				fail("No recuperó la actividad");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetActividadesPorTipo() {
		try{
			Actividad act = crearActividadPrueba();
			pruebaActividadDAO.guardarActividad(act);
			if(pruebaActividadDAO.getActividadPorTipo(act.getTipo()) == null)
				fail("No recuperó la actividad");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testModificarActividad() {
		try{
			Actividad act = crearActividadPrueba();
			if(!pruebaActividadDAO.guardarActividad(act))
				fail("No guardó la actividad");
			act.setTipo("NuevoTipo");
			if(!pruebaActividadDAO.modificarActividad(act))
				fail("No modificó la actividad");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testEliminarActividad() {
		try{
			Actividad act = crearActividadPrueba();
			if(!pruebaActividadDAO.guardarActividad(act))
				fail("No guardó la actividad");

			if(!pruebaActividadDAO.eliminarActividad(act))
				fail("No eliminó la actividad");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGuardarActividad() {
		try{
			Actividad act = crearActividadPrueba();
			if(!pruebaActividadDAO.guardarActividad(act))
				fail("Fallo al guardar la actividad");
			
		}
		catch(Exception e){
			
		}

	}
	
	public Actividad crearActividadPrueba(){
		Actividad a = new Actividad();
		a.setTipo(tipo);
		a.setBorrada(borrada);
		return a;
	}
}
