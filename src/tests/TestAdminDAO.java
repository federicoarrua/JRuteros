package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clasesDAO.AdminDAO;
import clasesJruteros.Admin;
import hibernate.EntityHandler;

public class TestAdminDAO {

	public AdminDAO pruebaAdminDAO;	
	
	@Before
	public void setUp() throws Exception {
		EntityHandler.setUp("jruteros");
		pruebaAdminDAO=new AdminDAO();
	}
	
	@Test
	public void testGuardarAdmin() {
		try{
			Admin adm = crearAdminPrueba();
			if(!pruebaAdminDAO.guardarAdmin(adm))
				fail("Fallo al guardar la Admin");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetAdmins() {
		try{
			List<Admin> resultList = pruebaAdminDAO.getAdmins();
			if(resultList == null)
				fail("Fallo al guardar la Admin");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetAdminsPorID() {
		try{
			Admin adm = crearAdminPrueba();
			pruebaAdminDAO.guardarAdmin(adm);
			if(pruebaAdminDAO.getAdmin(adm.getId()) == null)
				fail("No recuperó la Admin");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testModificarAdmin() {
		try{
			Admin adm = crearAdminPrueba();
			if(!pruebaAdminDAO.guardarAdmin(adm))
				fail("No guardó la Admin");
			adm.setMail("nuevoMail@jruteros.com");
			if(!pruebaAdminDAO.modificarAdmin(adm))
				fail("No modificó la Admin");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testEliminarAdmin() {
		try{
			Admin adm = crearAdminPrueba();
			if(!pruebaAdminDAO.guardarAdmin(adm))
				fail("No guardó al admin");

			if(!pruebaAdminDAO.eliminarAdmin(adm))
				fail("No eliminó un admin");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public Admin crearAdminPrueba(){
		Admin a = new Admin();
		a.setMail("admin@jruteros.com");
		a.setPassword("admin");
		a.setUsername("admin");
		return a;
	}

}
