package dominio;

import java.util.ArrayList;

public class Guardaropa {
	
	private ArrayList<Prenda> prendas = new ArrayList<Prenda>();
	
	public void agregarPrendas(Prenda prenda) {
		
		prendas.add(prenda);
		
	}
	
	public Integer cantidadDePrendas() {
		return prendas.size();
	}

}
