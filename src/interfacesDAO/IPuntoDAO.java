package interfacesDAO;

import java.util.List;
import clasesJruteros.Punto;

public interface IPuntoDAO {
	
	public boolean guardarPunto(Punto p);
	public List<Punto> getPuntos();
	public Punto getPuntoPorId(Long id);
	public boolean modificarPunto(Punto p);
	public boolean eliminarPunto(Punto p);
}
