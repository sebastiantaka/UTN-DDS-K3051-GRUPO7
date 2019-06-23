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

public class AtuendoHLP {

	public AtuendoHLP() {}
	
	public Atuendo crearAtuendo() {
		return new Atuendo();
	}
	
	public void agregarPrenda(Atuendo atuendo, Prenda prenda ) {
		atuendo.getPrendas().add(prenda);
	}
	

	
}
