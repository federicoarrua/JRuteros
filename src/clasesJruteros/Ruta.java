package clasesJruteros;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Date;
import java.sql.Time;

import javax.persistence.*;

import enumJruteros.*;

/**
 * Ruta: clase Ruta según especificación del proyecto.
 * @author Federico Arrúa.
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ruta")
public class Ruta implements java.io.Serializable{
	
	@Id@GeneratedValue
	@Column(name="ruta_id")
	private Long Id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String descripcion;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Privacidad priv;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Formato formato;
	
	@Column(nullable=false)
	private Float distancia;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Dificultad dificultad;
	
	@Column(nullable=false)
	private Time tiempoEstimado;
	
	@Column(nullable=false)
	private Date fecha;
	
	private Float valoracion;
	
	private Float cantPuntuadores;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="usuario_id")
	private Usuario dueno;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="actividad_id")
	private Actividad actividad;
	
	@OneToMany(cascade=CascadeType.REMOVE)
	@JoinTable(name="ruta_imagen",
		joinColumns=@JoinColumn(name="ruta_id"),
		inverseJoinColumns=@JoinColumn(name="imagen_id")
			)
	private List<Imagen> imagenesRuta;
	
	@ManyToMany(cascade=CascadeType.REMOVE)
	@JoinTable(name="ruta_punto",
		joinColumns=@JoinColumn(name="ruta_id"),
		inverseJoinColumns=@JoinColumn(name="punto_id")
			)
	private List<Punto> puntosRecorrido;
	
	public Ruta(){}
	
	/**
	 * Agrega un punto al arreglo de puntos del recorrido puntosRecorrido.
	 * En caso de no poder retorna false.
	 * @return
	 */
	public Boolean agregarPunto(Float latitud, Float longitud){
		return true;
	}
	
	/**
	 * Elimina el punto con esa latitud y esa longitud del arreglo de 
	 * puntos del recorrido.
	 * Si el punto no está retorna false.
	 * @return
	 */
	public Boolean eliminarPunto(Float latitud, Float longitud){
		return true;
	}
	
	/**
	 * Agrega una imagen al arreglo con el archivo y nombre pasados por 
	 * parámetro.
	 * Retorna true si la agrego correctamente, false caso contrario o si
	 * el nombre está repetido.
	 * @return
	 */
	public Boolean agregarImagen(BufferedImage archivo, String nombre){
		return true;
	}
	
	/**
	 * Elimina la imagen con el nombre pasado por parámetro.
	 * Retorna false si no pudo eliminarla o si no hay ninguna con ese nombre
	 * @return
	 */
	public Boolean eliminarImagen(String nombre){
		return true;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getTiempoEstimado() {
		return tiempoEstimado;
	}
	public void setTiempoEstimado(Time tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	public Dificultad getDificultad() {
		return dificultad;
	}
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	public Formato getFormato() {
		return formato;
	}
	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	public Float getDistancia() {
		return distancia;
	}
	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}
	public Privacidad getPriv() {
		return priv;
	}
	public void setPriv(Privacidad priv) {
		this.priv = priv;
	}

	public Usuario getDueno() {
		return dueno;
	}

	public void setDueno(Usuario dueno) {
		this.dueno = dueno;
	}
	public List<Punto> getPuntosRecorrido() {
		return puntosRecorrido;
	}
	public void setPuntosRecorrido(List<Punto> puntosRecorrido) {
		this.puntosRecorrido = puntosRecorrido;
	}
	public List<Imagen> getImagenesRuta() {
		return imagenesRuta;
	}
	public void setImagenesRuta(List<Imagen> imagenesRuta) {
		this.imagenesRuta = imagenesRuta;
	}

	public Float getValoracion() {
		return valoracion;
	}

	public void setValoracion(Float valoracion) {
		this.valoracion = valoracion;
	}

	public Float getCantPuntuadores() {
		return cantPuntuadores;
	}

	public void setCantPuntuadores(Float cantPuntuadores) {
		this.cantPuntuadores = cantPuntuadores;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	
}
