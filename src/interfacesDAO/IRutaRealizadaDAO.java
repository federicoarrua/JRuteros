package interfacesDAO;

import java.util.List;
import clasesJruteros.RutaRealizada;

public interface IRutaRealizadaDAO {
	
	public boolean guardarRutaRealizada(RutaRealizada r);
	public List<RutaRealizada> getRutasRealizadas();
	public RutaRealizada getRutaRealizadaPorId(Long id);
	public boolean modificarRutaRealizada(RutaRealizada r);
	public boolean eliminarRutaRealizada(RutaRealizada r);
}
