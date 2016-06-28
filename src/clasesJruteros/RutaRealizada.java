package clasesJruteros;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="rutarealizada")
public class RutaRealizada implements java.io.Serializable{
	
	@Id@GeneratedValue
	@Column(name="rutarealizada_id")
	private Long Id;
	
	@Column(nullable=false)
	private Integer valoracion;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="ruta_id")
	private Ruta ruta;
	
	public RutaRealizada(){}
	
	public Integer getValoracion() {
		return valoracion;
	}
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
}
