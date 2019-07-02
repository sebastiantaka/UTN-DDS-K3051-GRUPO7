package dominio;

import java.util.HashSet;
import java.util.Set;

public class Guardarropa implements Cloneable{
	
	@Override
	public Guardarropa clone() throws CloneNotSupportedException {
		Guardarropa guardarropa = new Guardarropa();
		guardarropa.setPrendas(this.prendas);
		return guardarropa;
	}	
	
	private Set<Prenda> prendas = new HashSet<Prenda>();
	
	public int cantidadDePrendas() {
		return getPrendas().size();
	}

	public Set<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(Set<Prenda> prendas) {
		this.prendas = prendas;
	}
	
}
