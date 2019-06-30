package negocio;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import dominio.Atuendo;
import dominio.Capa;
import dominio.Categoria;
import dominio.Guardarropa;
import dominio.Prenda;

public class AtuendoHLP {

	public AtuendoHLP() {}
	
	public Atuendo crearAtuendo() {
		return new Atuendo();
	}
	
	public Atuendo crearAtuendoSegunPrendas(Collection<Prenda> prendas) {
		return new Atuendo(prendas);
	}
	
	public void agregarPrenda(Atuendo atuendo, Prenda prenda ) {
		atuendo.getPrendas().add(prenda);
	}
	
	public Set<Atuendo> obtenerSugerencias(Guardarropa guardarropa){
		Map<Categoria, Set<Atuendo>> atuendosDeUnaSolaCategoria = new HashMap<Categoria, Set<Atuendo>>();
		Map<Categoria, Set<Prenda>> ropaSeparadaPorCategoria = this.separarRopaPorCategoria(guardarropa.getPrendas());
		
		ropaSeparadaPorCategoria.forEach( (categoria, prendasDelGuardarropa) -> {
			
			Map<Capa, Set<Prenda>> ropaSeparadaPorCapa = this.separarRopaPorCapa(prendasDelGuardarropa);
			Set<Atuendo> atuendosDeCategoria = this.obtenerAtuendosSegunCapa(ropaSeparadaPorCapa);
			atuendosDeUnaSolaCategoria.put(categoria, atuendosDeCategoria);
		});
		
		Set<Atuendo> atuendos = obtenerAtuendosSegunCategoria(atuendosDeUnaSolaCategoria);
		return atuendos;
	}
	
	private Set<Atuendo> obtenerAtuendosSegunCategoria(Map<Categoria, Set<Atuendo>> mapCategorias) {
		Set<List<Atuendo>> posiblesAtuendos = Sets.cartesianProduct((List<Set<Atuendo>>) mapCategorias.values());
		mapCategorias.forEach( (categoria, atuendosDeCategoria) -> {
			Map<Categoria, Set<Atuendo>> copiaMapa = new HashMap<Categoria, Set<Atuendo>>(mapCategorias);
			copiaMapa.remove(categoria);
			Sets.union(posiblesAtuendos, this.obtenerAtuendosSegunCategoria(copiaMapa));
		});
		Set<Atuendo> atuendos = posiblesAtuendos.stream().flatMap(x -> x.stream()).collect(Collectors.toSet());
		return atuendos;
	}

	public Set<Atuendo> obtenerAtuendosSegunCapa(Map<Capa, Set<Prenda>> ropaMap){
		Set<List<Prenda>> posiblesAtuendos= Sets.cartesianProduct((List<Set<Prenda>>) ropaMap.values());
		ropaMap.forEach((capa, ropa) -> {
			if (capa.getEsOpcional()) {
				Map<Capa, Set<Prenda>> copiaMapa = new HashMap<Capa, Set<Prenda>>(ropaMap);
				copiaMapa.remove(capa);
				Sets.union(posiblesAtuendos, this.obtenerAtuendosSegunCapa(copiaMapa));
			}
		});
		Set<Atuendo> atuendosDeCategoria = posiblesAtuendos.stream().map(set -> new Atuendo(set)).collect(Collectors.toSet());
		return atuendosDeCategoria;
	}
	
	public Map<Categoria, Set<Prenda>> separarRopaPorCategoria(Set<Prenda> prendas){
		Map<Categoria, Set<Prenda>> ropaPorCategoria = new HashMap<Categoria, Set<Prenda>>();
		for (Prenda prenda : prendas) {
			if (!ropaPorCategoria.containsKey(prenda.getCategoria())) {
				ropaPorCategoria.put(prenda.getCategoria(), new HashSet<Prenda>());
			}
			ropaPorCategoria.get(prenda.getCategoria()).add(prenda);
		}
		return ropaPorCategoria;
	}
	
	public Map<Capa, Set<Prenda>> separarRopaPorCapa(Set<Prenda> prendas) {
		Map<Capa, Set<Prenda>> ropaPorCapa = new HashMap<Capa, Set<Prenda>>();
		for (Prenda prenda : prendas) {
			if (!ropaPorCapa.containsKey(prenda.getTipoDePrenda().getCapa())) {
				ropaPorCapa.put(prenda.getTipoDePrenda().getCapa(), new HashSet<Prenda>());
			}
			ropaPorCapa.get(prenda.getTipoDePrenda().getCapa()).add(prenda);
		}
		return ropaPorCapa;
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa) {
		Set<Atuendo> sugerencias = this.obtenerSugerencias(guardarropa);
		Random rand = new Random();
	    return (Atuendo) sugerencias.toArray()[rand.nextInt(sugerencias.size()+1)];	
	}
}
