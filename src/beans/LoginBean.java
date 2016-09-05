package beans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import clasesDAO.AdminDAO;
import clasesDAO.UsuarioDAO;
import clasesJruteros.Admin;
import clasesJruteros.Usuario;

/**
 * ManagedBean para el manejo de sesiones de usuario y administrador, y modificacion de datos.
 * @author Federico Arrua
 *
 */

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	
	private Usuario usuario;
	private Admin admin;
	private String username;
	private String password;
	private Boolean loggedIn;
	UsuarioDAO uDAO = new UsuarioDAO();
	AdminDAO aDAO = new AdminDAO();
	
	public String login() {
		if(!aDAO.validarAdmin(this.username, this.password)){
			boolean valid = uDAO.validarUsuario(this.username, this.password);
			
			ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
	        HttpSession session = (HttpSession)ectx.getSession(false);
			
			if (valid) {
				this.loggedIn = true;
				this.usuario = uDAO.getUsuarioPorUsername(this.username).get(0);
		        session.setAttribute("loggedIn", true);
		        session.setAttribute("user",this.usuario);
				return "login-success";
			} else {
				FacesContext.getCurrentInstance().addMessage(
						"loginForm:username",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Incorrect Username and Passowrd",
								"Please enter correct username and Password"));
				return "login-unsuccess";
			}
		}
		else{
			return loginAdmin();
		}
	}
	
	public String loginAdmin(){
		this.loggedIn = true;
		this.admin = aDAO.getAdminPorUsername(this.username).get(0);
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession)ectx.getSession(false);
        
        session.setAttribute("loggedIn", true);
        session.setAttribute("admin",this.admin);
        
        return "admin-success";
	}
	
	public String logout(){
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        System.out.println("fasdasd");
        this.loggedIn = false;
        /*try {
			ectx.redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "logout-success";		
	}
	
	public String modify(){
        FacesMessage message;
        FacesContext context = FacesContext.getCurrentInstance();
		
        if(uDAO.modificarUsuario(this.usuario)){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Modificaci�n de datos exitosa",null);
			context.addMessage("modifyForm:button", message);
			this.username = this.usuario.getUsername();
			
        	return "modify-success";
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Modificaci�n de datos fallida. Revisar username o email",null);
			context.addMessage("modifyForm:button", message);
			usuario = uDAO.getUsuarioPorId(usuario.getId());
			
			return "modify-unsuccess";
		}
	}
	
	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
