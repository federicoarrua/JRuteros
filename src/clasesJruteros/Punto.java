package clasesJruteros;

import javax.persistence.*;

/**
 * Punto: Clase que representa un punto en el mapa.
 * @author Federico Arrúa
 *
 */
@SuppressWarnings("serial")

@Entity
@Table(name="punto")
public class Punto implements java.io.Serializable{
	
	@Id@GeneratedValue
	@Column(name="punto_id")
	private Long Id;
	
	@Column(nullable=false)
	private Float latitud;
	
	@Column(nullable=false)
	private Float longitud;
	
	public Punto(){}
	
	public Float getLatitud() {
		return latitud;
	}
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	public Float getLongitud() {
		return longitud;
	}
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
}
