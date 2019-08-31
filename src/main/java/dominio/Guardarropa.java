package dominio;

import java.util.HashSet;
import java.util.Set;

public class Guardarropa {

	private Set<Prenda> prendas = new HashSet<Prenda>();
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public int cantidadDePrendas() {
		return getPrendas().size();
	}

	public Set<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(Set<Prenda> prendas) {
		this.prendas = prendas;
	}

	public void agregarPrendas(Set<Prenda> prendas) {
		this.prendas.addAll(prendas);
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

}
