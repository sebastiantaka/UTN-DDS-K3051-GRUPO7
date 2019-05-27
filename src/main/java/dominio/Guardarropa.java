package dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class Guardarropa {
	
	private Set<Prenda> prendas = new HashSet<Prenda>();
	
	public void agregarPrendas(Prenda prenda) {
		
		prendas.add(prenda);
		
	}
	
	public int cantidadDePrendas() {
		return prendas.size();
	}
	
	public List<Set<Prenda>> separarRopaPorCategoria(){
		ArrayList<Set<Prenda>> lista = new ArrayList<Set<Prenda>>();
		for (int i = 0; i < Categoria.values().length; i++){
			lista.add(new HashSet<Prenda>());
		}
		this.prendas.stream().forEach(prenda -> lista.get(prenda.getCategoria().ordinal()).add(prenda));
		return lista;
	}
	
	public Set<List<Prenda>> obtenerSugerencias(){
		List<Set<Prenda>> ropaSeparada = this.separarRopaPorCategoria();
		Set<List<Prenda>> combinacionesConAccesorios = Sets.cartesianProduct(ropaSeparada);
		ropaSeparada.remove(Categoria.ACCESORIO.ordinal());
		Set<List<Prenda>> combinacionesSinAccesorios = Sets.cartesianProduct(ropaSeparada);
		return Sets.union(combinacionesConAccesorios, combinacionesSinAccesorios);
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
