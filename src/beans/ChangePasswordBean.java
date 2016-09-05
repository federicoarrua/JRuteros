package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import clasesDAO.AdminDAO;
import clasesDAO.UsuarioDAO;
import clasesJruteros.Admin;
import clasesJruteros.Usuario;

/**
 * ManagedBean para el manejo de cambio de contraseña de usuarios y administrador.
 * @author Federico Arrua
 *
 */

@ManagedBean(name = "changePasswordBean")
@RequestScoped
public class ChangePasswordBean {
	
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	public String change(){
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession)ectx.getSession(false);
        Usuario u = (Usuario) session.getAttribute("user");
        
        FacesMessage message;
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(u.getPassword().equals(this.oldPassword)){
			if(this.newPassword.equals(this.confirmPassword)){
		        u.setPassword(this.newPassword);
		        UsuarioDAO uDAO = new UsuarioDAO();
		        uDAO.modificarUsuario(u);
				return "change-success";
			}
			else{
				message = new FacesMessage("No coincide con la nueva contraseña");
				context.addMessage("changePassForm:confirmPassword", message);
				return "change-unsuccess";
			}
        }
		else{
			message = new FacesMessage("Contraseña vieja erronea");
			context.addMessage("changePassForm:oldPassword", message);
			
			return "change-unsuccess";
		}
	}
	
	public String changeAdmin(){
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession)ectx.getSession(false);
        Admin a = (Admin) session.getAttribute("admin");
        
        FacesMessage message;
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(a.getPassword().equals(this.oldPassword)){
			if(this.newPassword.equals(this.confirmPassword)){
		        a.setPassword(this.newPassword);
		        AdminDAO aDAO = new AdminDAO();
		        aDAO.modificarAdmin(a);
				return "changeadmin-success";
			}
			else{
				message = new FacesMessage("No coincide con la nueva contraseña");
				context.addMessage("changePassForm:confirmPassword", message);
				
				return "changeadmin-unsuccess";
			}
        }
		else{
			message = new FacesMessage("Contraseña vieja erronea");
			context.addMessage("changePassForm:oldPassword", message);
			
			return "changeadmin-unsuccess";
		}
	}
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
