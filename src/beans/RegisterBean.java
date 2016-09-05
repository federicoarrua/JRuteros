package beans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;

import clasesDAO.UsuarioDAO;
import clasesJruteros.Usuario;
import enumJruteros.Genero;

/**
 * ManagedBean para el registro de usuarios normales.
 * @author Federico Arrua
 *
 */

@ManagedBean(name = "registerBean")
@RequestScoped
public class RegisterBean {
	
	private String username;
	private Integer dni;
	private String apellido;
	private String nombre;
	private String email;
	private String password;
	private Usuario usuario;
	private String domicilio;
	private Date fechaNac;
	private Genero sexo;
	UsuarioDAO uDAO = new UsuarioDAO();
	
	public String register(){
		this.usuario = new Usuario();
		this.usuario.setUsername(this.username);
		this.usuario.setDni(this.dni);
		this.usuario.setApellido(this.apellido);
		this.usuario.setNombres(this.nombre);
		this.usuario.setEmail(this.email);
		this.password = this.generateRandomPassword();
		this.usuario.setPassword(this.password);
		this.usuario.setEnable(true);
		this.usuario.setSexo(this.sexo);
		this.usuario.setDomicilio(this.domicilio);
		this.usuario.setFechaNac(this.fechaNac);
		
		if(uDAO.guardarUsuario(this.usuario)){
			LoginBean lb = new LoginBean();
			lb.setUsername(this.username);
			lb.setPassword(this.password);
			lb.login();
			ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
	        HttpSession session = (HttpSession)ectx.getSession(false);
	        session.setAttribute("loginBean", lb);
			return "register-success";
		}
		else{
            FacesMessage message;
            FacesContext context = FacesContext.getCurrentInstance();

			if(!uDAO.getUsuarioPorUsername(this.username).isEmpty()){
				message = new FacesMessage("Username ya existente");
				context.addMessage("registerForm:username",message );
			}
			else{
	            message = new FacesMessage("Email ya existente");
	            context.addMessage("registerForm:email",message );
			}
			
			return "register-unsuccess";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}
	
	private String generateRandomPassword(){
		
		for (int i = 0; i < 8; i++) {
		    System.out.println(RandomStringUtils.randomAlphabetic(8));
		}
		return RandomStringUtils.randomAlphabetic(8);
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
}
