package clasesJruteros;

import java.sql.Time;
import java.util.Date;

import enumJruteros.*;

public class Ruta {
	
	private String nombre;
	private String descripcion;
	private Privacidad priv;
	//Recorrido keyhole markup language
	private Formato formato;
	private Float distancia;
	private Dificultad dificultad;
	private Actividad actividad;
	private Time tiempoEstimado;
	private Date fecha;
	//Fotos del recorrido
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
	
	
}
