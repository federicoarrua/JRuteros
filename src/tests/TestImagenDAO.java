package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clasesDAO.ImagenDAO;
import clasesJruteros.Imagen;
import hibernate.EntityHandler;

public class TestImagenDAO {


	public ImagenDAO pruebaImagenDAO;	
	
	@Before
	public void setUp() throws Exception {
		EntityHandler.setUp("jruteros");
		pruebaImagenDAO=new ImagenDAO();
	}
	
	@Test
	public void testGuardarImagen() {
		try{
			Imagen img = crearImagenPrueba();
			if(!pruebaImagenDAO.guardarImagen(img))
				fail("Fallo al guardar la Imagen");
			
		}
		catch(Exception e){
			
		}

	}
	
	@Test
	public void testGetImagenes() {
		try{
			List<Imagen> resultList = pruebaImagenDAO.getImagenes();
			if(resultList == null)
				fail("Fallo al guardar la Imagen");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetImagenPorID() {
		try{
			Imagen img = crearImagenPrueba();
			pruebaImagenDAO.guardarImagen(img);
			if(pruebaImagenDAO.getImagenPorId(img.getId()) == null)
				fail("No recuperó la Imagen");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testModificarImagen() {
		try{
			Imagen img = crearImagenPrueba();
			if(!pruebaImagenDAO.guardarImagen(img))
				fail("No guardó la Imagen");
			img.setNombre("Imagen ruta cambiada");
			if(!pruebaImagenDAO.modificarImagen(img))
				fail("No modificó la Imagen");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testEliminarImagen() {
		try{
			Imagen img = crearImagenPrueba();
			if(!pruebaImagenDAO.guardarImagen(img))
				fail("No guardó al Imagen");

			if(!pruebaImagenDAO.eliminarImagen(img))
				fail("No eliminó un Imagen");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public Imagen crearImagenPrueba(){
		Imagen img = new Imagen();
		img.setNombre("Imagen ruta");
		img.setUrl("www.google.com");
		return img;
	}

}
