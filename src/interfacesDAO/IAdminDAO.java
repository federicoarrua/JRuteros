package interfacesDAO;

import java.util.List;

import clasesJruteros.Admin;

public interface IAdminDAO {

	public boolean guardarAdmin(Admin admin);
	public List<Admin> getAdmins();
	public Admin getAdmin(Long id);
	public boolean modificarAdmin(Admin admin);
	public boolean eliminarAdmin(Admin admin);
}
