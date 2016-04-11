package clasesJruteros;

import java.util.Date;

import enumJruteros.Genero;
import enumJruteros.TiposUsuario;

public class Usuario {

	private String username;
	private Integer dni;
	private String apellido;
	private String nombres;
	private String domicilio;
	private Date fechaNac;
	private String email;
	private String password;
	private Genero sexo;
	private TiposUsuario tipo;
	
	public Usuario(String username, Integer dni, String apellido, String nombres, String domicilio, Date fechaNac,
			String email, String password, Genero sexo, TiposUsuario tipo) {
		super();
		this.username = username;
		this.dni = dni;
		this.apellido = apellido;
		this.nombres = nombres;
		this.domicilio = domicilio;
		this.fechaNac = fechaNac;
		this.email = email;
		this.password = password;
		this.sexo = sexo;
		this.tipo = tipo;
	}
	
	public Usuario(Usuario u) {
		super();
		this.username = u.getUsername();
		this.dni = u.getDni();
		this.apellido = u.getApellido();
		this.nombres = u.getNombres();
		this.domicilio = u.getDomicilio();
		this.fechaNac = u.getFechaNac();
		this.email = u.getEmail();
		this.password = u.getPassword();
		this.sexo = u.getSexo();
		this.tipo = u.getTipo();
	}

	public Usuario() {
		super();
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}

	public TiposUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TiposUsuario tipo) {
		this.tipo = tipo;
	}
	
	
}
