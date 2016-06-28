package interfacesDAO;

import java.util.List;
import clasesJruteros.Usuario;

public interface IUsuarioDAO {
	
	public boolean guardarUsuario(Usuario u);
	public List<Usuario> getUsuarios();
	public Usuario getUsuarioPorId(Long id);
	public Usuario getUsuarioPorUsername(String username);
	public boolean modificarUsuario(Usuario u);
	public boolean eliminarUsuario(Usuario u);
}
