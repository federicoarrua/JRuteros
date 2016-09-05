package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import enumJruteros.Genero;

/**
 * ManagedBean para uso de enumerativo 'Genero' del modelo
 * @author Federico Arrua
 *
 */

@ManagedBean(name = "generoBean")
@ApplicationScoped
public class GeneroBean {
	
	public Genero[] getGeneros(){
		return Genero.values();
	}
}
