package dominio;

import java.util.ArrayList;
import java.util.Collection;

public class Atuendo {
	
	private Collection<Prenda> prendas = new ArrayList<Prenda>();

	public Atuendo() {}

	public Atuendo(Collection<Prenda> unasPrendas) {
		prendas = unasPrendas;
	}
	
	/*Prendas */
	
	public Collection<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(Collection<Prenda> prendas) {
		this.prendas = prendas;
	}
	
	/* Calor */
	
	public Integer nivelDeCalor(){
		Integer calor = 0;
		for (Prenda prenda : this.getPrendas()) {
			calor += prenda.getNivelDeCalor();
		}
		return calor;
	}
	
	@Override
	public String toString() {
		return "Atuendo [prendas=" + prendas + "]";
	}
	
	
	
}
