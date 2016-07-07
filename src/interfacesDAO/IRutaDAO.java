package interfacesDAO;
import java.util.List;

import clasesJruteros.Punto;
import clasesJruteros.Ruta;

public interface IRutaDAO {
	
	public boolean guardarRuta(Ruta ruta);
	public List<Ruta> getRutas();
	public Ruta getRutaPorId(Long id);
	public boolean eliminarRuta(Ruta ruta);
	public boolean modificarRuta(Ruta ruta);
	public List<Punto> getPuntosRuta(Long id);
	public boolean eliminarRecorrido(Long id);
	public boolean eliminarPuntoRuta(Long idRuta, Long idPunto);
	public boolean agregarPuntoRuta(Punto p, Long id);
}
