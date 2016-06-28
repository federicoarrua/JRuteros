package interfacesDAO;
import java.util.List;

import clasesJruteros.Ruta;

public interface IRutaDAO {
	
	public boolean guardarRuta(Ruta ruta);
	public List<Ruta> getRutas();
	public Ruta getRutaPorId(Long id);
	public boolean eliminarRuta(Ruta ruta);
	public boolean modificarRuta(Ruta ruta);
}
