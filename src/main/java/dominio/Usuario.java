package dominio;

import java.util.Set;

public class Usuario {
	
	private Set<Guardarropa> guardarropas;
	
	public Usuario() {}

	public Set<Guardarropa> getGuardarropas() {
		return guardarropas;
	}

	public void setGuardarropas(Set<Guardarropa> guardarropas) {
		this.guardarropas = guardarropas;
	}
	
	public void AdquirirGuardarropa(Guardarropa guardarropa) {
		guardarropas.add(guardarropa);
	}

}
