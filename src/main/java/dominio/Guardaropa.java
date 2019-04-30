package dominio;

import java.util.ArrayList;

public class Guardaropa {
	
	private ArrayList<Prenda> prendas = new ArrayList<Prenda>();
	
	public void agregarPrendas(Prenda prenda) {
		
		prendas.add(prenda);
		
	}
	
	public int cantidadDePrendas() {
		return prendas.size();
	}
	/*
	public ArrayList<Prenda> getPrendas(Prenda tipoPrenda) {
		
		ArrayList<Prenda> prendasDeseadas = null ;
		
		for(Prenda prenda : prendas) {
		 if( tipoPrenda.isInstance(prenda) ) {
			 prendasDeseadas.add(prenda);
		 }
		}
	*/
}
