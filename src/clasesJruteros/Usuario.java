package clasesJruteros;

import java.sql.Time;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

import enumJruteros.*;

/**
 * Usuario: clase Usuario según la especificación del sistema JRuteros.
 * @author root
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="usuario")
public class Usuario implements java.io.Serializable{
	
	@Id@GeneratedValue
	@Column(name="usuario_id")
	private Long Id;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private Integer dni;
	
	@Column(nullable=false)
	private String apellido;
	
	@Column(nullable=false)
	private String nombres;
	
	@Column(nullable=false)
	private String domicilio;
	
	@Column(nullable=false)
	private Date fechaNac;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Genero sexo;
	
	@OneToMany(mappedBy="dueno")
	private List<Ruta> rutasPropias;
	
	@OneToMany(mappedBy="usuario")
	private List<RutaRealizada> rutasHechas;
	
	public Usuario(){}
	
	/**
	 * Crea una ruta con los parámetros pasados y la almacena en rutasPropias
	 * En caso de fracaso o de haber ruta con mismo nombre retorna false.
	 */
	public Boolean subirRuta(String nombre, String descripción,Privacidad privacidad,Dificultad dificultad,Formato formato,Actividad actividad,Float distancia, Time tiempo,Imagen[] imagenes,Punto[] puntos){
		return true;
	}
	
	/**
	 * Elimina la ruta con el nombre pasado por parámetro de rutasPropias.
	 * En caso de no ser posible o no existir retorna false.
	 */
	public Boolean eliminarRuta(String nombre){
		return true;
	}
	
	/**
	 * Almacena la referencia de la ruta pasada por parámetro en
	 * rutasHechas. Devuelve false en caso de no poder guardarla o
	 * si esa ruta ya está en el arreglo.
	 */
	public Boolean marcarRutaHecha(Ruta ruta){
		return true;
	}
	
	/**
	 * Elimina la referencia de la ruta pasada por parámetro del 
	 * arreglo rutasHechas. Devuelve false en caso de no encontrar la ruta
	 * o si no pudo eliminarla.
	 */
	public Boolean desmarcarRutaHecha(Ruta ruta){
		return true;
	}
	
	/**
	 * Puntúa la ruta pasada por parametro solo si la tiene en el arreglo
	 * de rutasHechas y añade el puntaje al atributo valoracion de RutaRealizada.
	 * Además suma el puntaje al atributo valoracion de Ruta.
	 * Si la ruta ya esta puntuada, resta el puntaje anterior ,suma el nuevo
	 * y no modifica el atributo cantPuntuados de la ruta.
	 */
	public void puntuarRuta(Ruta ruta,Float puntaje){
		
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

	public List<RutaRealizada> getRutasHechas() {
		return rutasHechas;
	}

	public void setRutasHechas(List<RutaRealizada> rutasHechas) {
		this.rutasHechas = rutasHechas;
	}

	public List<Ruta> getRutasPropias() {
		return rutasPropias;
	}

	public void setRutasPropias(List<Ruta> rutasPropias) {
		this.rutasPropias = rutasPropias;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
}
