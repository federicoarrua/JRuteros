package interfacesDAO;

import java.util.List;
import clasesJruteros.Imagen;

public interface IImagenDAO {
	
	public boolean guardarImagen(Imagen img);
	public List<Imagen> getImagenes();
	public Imagen getImagenPorId(Long id);
	public boolean modificarImagen(Imagen img);
	public boolean eliminarImagen(Imagen img);
	
}
