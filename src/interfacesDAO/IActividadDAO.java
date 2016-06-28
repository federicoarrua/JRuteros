package interfacesDAO;

import java.util.List;

import clasesJruteros.Actividad;

public interface IActividadDAO {
	
	public boolean guardarActividad(Actividad act);
	public List<Actividad> getActividades();
	public Actividad getActividadPorId(Long id);
	public Actividad getActividadPorTipo(String tipo);
	public boolean modificarActividad(Actividad act);
	public boolean eliminarActividad(Actividad act);
}
