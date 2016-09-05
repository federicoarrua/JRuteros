package clasesJruteros;

import javax.persistence.*;

/**
 * Actividad: clase Actividad segun especificacion del modelo JRuteros.
 * @author Federico Arrua
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="actividad")
public class Actividad implements java.io.Serializable{
	
	@Id@GeneratedValue
	@Column(name="actividad_id")
	private Long Id;
	
	@Column(nullable=false)
	private String tipo;
	
	@Column(nullable=false)
	private Boolean borrada;
	
	public Actividad(){}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Boolean getBorrada() {
		return borrada;
	}
	public void setBorrada(Boolean borrada) {
		this.borrada = borrada;
	}
	
}
