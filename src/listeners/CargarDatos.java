package listeners;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import clasesDAO.AdminDAO;
import clasesDAO.UsuarioDAO;
import clasesJruteros.*;
import enumJruteros.Genero;

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
		AdminDAO aDAO = new AdminDAO();
		UsuarioDAO uDAO = new UsuarioDAO();
		aDAO.guardarAdmin(crearAdmin());
		uDAO.guardarUsuario(crearUsuarioPrueba());
    }
    
	public Admin crearAdmin(){
		Admin a = new Admin();
		a.setUsername("admin");
		a.setPassword("password");
		a.setMail("admin@admin.com");
		return a;
	}
	
	public Usuario crearUsuarioPrueba(){
		Usuario usr = new Usuario();
		usr.setApellido("apellido");
		usr.setDni(12345678);
		usr.setDomicilio("1 entre 60 y 61");
		usr.setFechaNac(new Date(1990,11,11));
		usr.setEmail("usr@jruteros.com");
		usr.setNombres("nombres");
		usr.setPassword("password");
		usr.setSexo(Genero.M);
		usr.setEnable(true);
		usr.setUsername("username");
		
		return usr;
	}
	
}
