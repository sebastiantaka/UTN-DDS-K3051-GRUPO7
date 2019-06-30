package dominio;

import java.util.ArrayList;
import java.util.Collection;

public class Categoria {
	
	private String descripcion;
	private Collection<Capa> capas = new ArrayList<Capa>();
	private Boolean esOpcional;
	
	/*DESCRIPCION: Descripcion de la categoria*/
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/* CAPA:  Capas de Ropa que tiene esta categoria */
	
	public Collection<Capa> getCapas() {
		return capas;
	}
	public void setCapas(Collection<Capa> capas) {
		this.capas = capas;
	}
	
	/* OPCIONAL: Si esta categoria debe Estar en una prenda si o si*/
	
	public Boolean getEsOpcional() {
		return esOpcional;
	}
	public void setEsOpcional(Boolean esOpcional) {
		this.esOpcional = esOpcional;
	}
	
}
