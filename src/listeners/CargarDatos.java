package listeners;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
				 u.setTipo(TiposUsuario.valueOf(usuario[9]));
				 
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
				 r.setActividad(ruta[6]);
				 r.setTiempoEstimado(new Time(Long.parseLong(ruta[7])));
				 r.setDueño(usuarios.get(ruta[8]));
				 r.setFecha(format.parse(ruta[9]));
				 
				 mapaRutas.put(r.getNombre(),r);
				 linea=buffer.readLine();
			 }
			 contexto.setAttribute("rutas", mapaRutas);
		 }
		 catch(Exception e){
			 contexto.log("No se pudo cargar la lista de rutas del archivo rutas.txt.");
		 }
    }
	
}
