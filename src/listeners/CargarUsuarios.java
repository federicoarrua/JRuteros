package listeners;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import clasesJruteros.Usuario;
import enumJruteros.Genero;
import enumJruteros.TiposUsuario;;

/**
 * Application Lifecycle Listener implementation class CargarApp
 *
 */
@WebListener
public class CargarUsuarios implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CargarUsuarios() {
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
		
		 try{
			 InputStream usuarios = contexto.getResourceAsStream(contexto.getInitParameter("usuarios"));
			 BufferedReader buffer = new BufferedReader(new InputStreamReader(usuarios));
			 Set<Usuario> setUsuarios = new HashSet<Usuario>();
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
				 
				 setUsuarios.add(u);
				 linea=buffer.readLine();
			 }
			 contexto.setAttribute("usuarios", setUsuarios);
		 }
		 catch(Exception e){
			 contexto.log("No se pudo cargar la lista de usuarios del archivo usuarios.txt");
		 }
    }
	
}
