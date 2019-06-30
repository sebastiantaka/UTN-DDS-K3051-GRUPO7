package dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Atuendo {
	
	private Collection<Prenda> prendas = new ArrayList<Prenda>();

	public Atuendo() {}

	public Atuendo(List<Prenda> unasPrendas) {
		prendas = unasPrendas;
	}

	public Collection<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(Collection<Prenda> prendas) {
		this.prendas = prendas;
	}

	@Override
	public String toString() {
		return "Atuendo [prendas=" + prendas + "]";
	}
	
	
	
}
