package clasesJruteros;

import javax.persistence.*;

/**
 * Imagen: Clase que representa una imagen con su nombre.
 * @author Federico Arrúa
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="imagen")
public class Imagen implements java.io.Serializable{
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="imagen_id")
	private Long Id;
	
	@Column(nullable=false)
	private String url;
	
	@Column(nullable=false)
	private String nombre;
	
	public Imagen(){}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
}
