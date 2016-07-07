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
	private Float lat;
	
	@Column(nullable=false)
	private Float lng;
	
	public Punto(){}
	
	public Float getLat() {
		return lat;
	}
	public void setLat(Float latitud) {
		this.lat = latitud;
	}
	public Float getLng() {
		return lng;
	}
	public void setLng(Float longitud) {
		this.lng = longitud;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
}
