package tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clasesDAO.UsuarioDAO;
import clasesJruteros.Usuario;
import enumJruteros.Genero;
import hibernate.EntityHandler;

public class TestUsuarioDAO {
	
	public UsuarioDAO pruebaUsuarioDAO;
	
	@Before
	public void setUp() throws Exception {
		EntityHandler.setUp("jruteros");
		pruebaUsuarioDAO=new UsuarioDAO();
	}


	@Test
	public void testGetUsuarios() {
		try{
			List<Usuario> resultList = pruebaUsuarioDAO.getUsuarios();
			if(resultList == null)
				fail("Fallo al guardar el usuario");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModificarActividad() {
		try{
			Usuario usr = crearUsuarioPrueba();
			if(!pruebaUsuarioDAO.guardarUsuario(usr))
				fail("No guardó la actividad");
			usr.setUsername("UsuarioMod");
			if(!pruebaUsuarioDAO.modificarUsuario(usr))
				fail("No modificó la actividad");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testEliminarUsuario() {
		try{
			Usuario usr = crearUsuarioPrueba();
			if(!pruebaUsuarioDAO.guardarUsuario(usr))
				fail("No guardó al usuario");

			if(!pruebaUsuarioDAO.eliminarUsuario(usr))
				fail("No elimino al usuario");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetUsuariosPorUsername() {
		try{
			Usuario usr = crearUsuarioPrueba();
			pruebaUsuarioDAO.guardarUsuario(usr);
			if(pruebaUsuarioDAO.getUsuarioPorUsername(usr.getUsername()).isEmpty())
				fail("No recuperó al usuario");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetUsuariosPorID() {
		try{
			Usuario usr = crearUsuarioPrueba();
			pruebaUsuarioDAO.guardarUsuario(usr);
			if(pruebaUsuarioDAO.getUsuarioPorId(usr.getId()) == null)
				fail("No recuperó al usuario");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGuardarUsuario() {
		try{
			Usuario act = crearUsuarioPrueba();
			if(!pruebaUsuarioDAO.guardarUsuario(act))
				fail("Fallo al guardar la Usuario");
			
		}
		catch(Exception e){
			
		}

	}
	
	public Usuario crearUsuarioPrueba(){
		Usuario usr = new Usuario();
		usr.setApellido("apellido");
		usr.setDni(12345678);
		usr.setDomicilio("1 entre 60 y 61");
		usr.setFechaNac(new Date(1990,11,11));
		usr.setEmail("usr@jruteros.com");
		usr.setNombres("nombres");
		usr.setPassword("contrasena");
		usr.setSexo(Genero.M);
		usr.setUsername("username");
		
		return usr;
	}
	
}
