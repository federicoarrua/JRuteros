package beans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import clasesDAO.UsuarioDAO;
import clasesJruteros.Usuario;

/**
 * ManagedBean usado para el manejo de usuarios por parte del administrador.
 * @author Federico Arrua
 *
 */

@ManagedBean(name = "usersBean")
@RequestScoped
public class UsersBean {
	
	private List<Usuario> users;
	UsuarioDAO uDAO = new UsuarioDAO();
	
	@PostConstruct
	public void init(){
		this.users = uDAO.getUsuarios();
	}
	
	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
	
	public String enable(Long id){
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		Usuario u = uDAO.getUsuarioPorId(id);
		
		u.setEnable(!u.getEnable());
		uDAO.modificarUsuario(u);
		
		try {
			ectx.redirect("/jruteros/admin/users.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "enable-success";
	}
	
}
