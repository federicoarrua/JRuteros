package clasesJruteros;

import javax.persistence.*;

/**
 * Admin: clase Admin según especificación del modelo JRuteros.
 * Representa al administrador del sistema.
 * @author Federico Arrúa
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="admin")
public class Admin implements java.io.Serializable{
	
	@Id@GeneratedValue
	@Column(name="admin_id")
	private Long id;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false,unique=true)
	private String mail;
	
	public Admin(){}
	
	/**
	 * Recibe un String y crea una nueva actividad con ese tipo.
	 * Consulta en la base de datos si ya existe esa actividad.
	 * Si al tipo de actividad pasado se le hizo un borrado lógico, se elimina
	 * la marca de borrado.
	 * Si ya existe ese tipo y no está borrada devuelve false(no sube repetidas).
	 */
	public Boolean subirActividad(String tipo){
		return true;
	}
	
	/**
	 * Elimina de la base de datos la actividad con el tipo pasado por
	 * parámetro. Si no existe devuelve false.
	 */
	public Boolean borradoFisicoAct(String tipo){
		return true;
	}
	
	/**
	 * Setea en true el atributo "borrada" del tipo de actividad pasado por
	 * parámetro. Si la actividad no existe devuelve false.
	 */
	public Boolean borradoLogicoAct(String tipo){
		return true;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
