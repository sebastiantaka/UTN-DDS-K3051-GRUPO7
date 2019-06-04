package negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import dominio.Atuendo;
import dominio.Categoria;
import dominio.Guardarropa;
import dominio.Prenda;

public class GuardarropaHLP {

	public GuardarropaHLP() { }
	
	public void adquirirPrenda(Guardarropa guardarropa, Prenda prenda) {
		guardarropa.getPrendas().add(prenda);
	}
	
	public Guardarropa crearGuardarropa() {
		return new Guardarropa();
	}
	
	
	public Set<Atuendo> obtenerSugerencias(Guardarropa guardarropa){
		Set<Atuendo> atuendos = new HashSet<Atuendo>();
		List<Set<Prenda>> ropaSeparada = this.separarRopaPorCategoria(guardarropa);
		Set<List<Prenda>> combinacionesConAccesorios = Sets.cartesianProduct(ropaSeparada);
		ropaSeparada.remove(Categoria.ACCESORIO.ordinal());
		Set<List<Prenda>> combinacionesSinAccesorios = Sets.cartesianProduct(ropaSeparada);
		Set<List<Prenda>> combinacionesPosibles = Sets.union(combinacionesConAccesorios, combinacionesSinAccesorios);
		combinacionesPosibles.forEach(combinacion -> atuendos.add(new Atuendo(combinacion)));
		return atuendos;
	}
	
	public List<Set<Prenda>> separarRopaPorCategoria(Guardarropa guardarropa){
		ArrayList<Set<Prenda>> listaDeSetsDeRopa = new ArrayList<Set<Prenda>>();
		for (int i = 0; i < Categoria.values().length; i++){
			listaDeSetsDeRopa.add(new HashSet<Prenda>());
		}
		guardarropa.getPrendas().forEach(prenda -> listaDeSetsDeRopa.get(prenda.getCategoria().ordinal()).add(prenda));
		return listaDeSetsDeRopa;
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa) {
		Set<Atuendo> sugerencias = this.obtenerSugerencias(guardarropa);
		Random rand = new Random();
	    return (Atuendo) sugerencias.toArray()[rand.nextInt(sugerencias.size()+1)];	
	}
}
