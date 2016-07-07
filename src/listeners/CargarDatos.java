package listeners;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import clasesDAO.ActividadDAO;
import clasesDAO.ImagenDAO;
import clasesDAO.PuntoDAO;
import clasesDAO.RutaDAO;
import clasesDAO.UsuarioDAO;
import clasesJruteros.*;
import enumJruteros.*;

/**
 * Application Lifecycle Listener implementation class CargarApp
 *
 */
@WebListener
public class CargarDatos implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CargarDatos() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	 
		ServletContext contexto = sce.getServletContext(); 	
		
		RutaDAO rutaDAO = new RutaDAO();
		rutaDAO.guardarRuta(this.crearRutaPrueba());
		
		this.cargarUsuarios(contexto);
		this.cargarActividades(contexto);
		this.cargarRutas(contexto);
    }
    
    /**
     * Carga los usuarios del archivo usuarios.txt.
     * Si no puede cargarlos hace logging del error.
     * @param contexto
     */
    private void cargarUsuarios(ServletContext contexto){
		 try{
			 InputStream usuarios = contexto.getResourceAsStream(contexto.getInitParameter("usuarios"));
			 BufferedReader buffer = new BufferedReader(new InputStreamReader(usuarios));
			 HashMap<String,Usuario> mapaUsuarios = new HashMap<String,Usuario>();
			 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			 String linea = buffer.readLine();
			 
			 while(linea!=null){
				 String[] usuario = linea.split(",");// Separa la linea en atributos del usuario
				 
				 Usuario u = new Usuario();
				 u.setUsername(usuario[0]);
				 u.setDni(Integer.parseInt(usuario[1]));
				 u.setApellido(usuario[2]);
				 u.setNombres(usuario[3]);
				 u.setDomicilio(usuario[4]);
				 u.setFechaNac(format.parse(usuario[5]));
				 u.setEmail(usuario[6]);
				 u.setPassword(usuario[7]);
				 u.setSexo(Genero.valueOf(usuario[8]));
				 
				 mapaUsuarios.put(u.getUsername(),u);
				 linea=buffer.readLine();
			 }
			 contexto.setAttribute("usuarios", mapaUsuarios);
		 }
		 catch(Exception e){
			 contexto.log("No se pudo cargar la lista de usuarios del archivo usuarios.txt.");
		 }
    }
    
    /**
     * Carga los tipos de actividades del archivo actividades.txt.
     * Si no puede cargarlas hace logging del error.
     * @param contexto
     */
    private void cargarActividades(ServletContext contexto){
    	try{
			 InputStream actividadesFile = contexto.getResourceAsStream(contexto.getInitParameter("actividades"));
			 BufferedReader buffer = new BufferedReader(new InputStreamReader(actividadesFile));
			 ArrayList<String> actividades = new ArrayList<String>();
			 String linea = buffer.readLine();
			 while(linea!=null){
				 actividades.add(linea);
				 linea = buffer.readLine();
			 }
			 contexto.setAttribute("actividades", actividades);
    	}
    	catch(Exception e){
    		contexto.log("No se pudo cargar la lista de actividades.txt.");
    	}
    }
    
    /**
     * Carga rutas por defecto del archivo rutas.txt.
     * Si no puede cargarlas hace logging del error.
     * @param contexto
     */
    private void cargarRutas(ServletContext contexto){
		 try{
			 InputStream rutas = contexto.getResourceAsStream(contexto.getInitParameter("rutas"));
			 BufferedReader buffer = new BufferedReader(new InputStreamReader(rutas));
			 HashMap<String,Ruta> mapaRutas = new HashMap<String,Ruta>();
			 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			 String linea = buffer.readLine();

			 @SuppressWarnings("unchecked")
			HashMap<String,Usuario>usuarios = (HashMap<String,Usuario>) contexto.getAttribute("usuarios");
			 while(linea!=null){
				 String[] ruta = linea.split(",");// Separa la linea en atributos del usuario
				 
				 Ruta r = new Ruta();
				 r.setNombre(ruta[0]);
				 r.setDescripcion(ruta[1]);
				 r.setPriv(Privacidad.valueOf(ruta[2]));
				 r.setFormato(Formato.valueOf(ruta[3]));
				 
				 r.setDistancia(Float.parseFloat(ruta[4]));
				 r.setDificultad(Dificultad.valueOf(ruta[5]));
				 r.setTiempoEstimado(new Time(Long.parseLong(ruta[7])));
				 r.setDueno(usuarios.get(ruta[8]));
				 
				 mapaRutas.put(r.getNombre(),r);
				 linea=buffer.readLine();
			 }
			 contexto.setAttribute("rutas", mapaRutas);
		 }
		 catch(Exception e){
			 contexto.log("No se pudo cargar la lista de rutas del archivo rutas.txt.");
		 }
    }
    
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
