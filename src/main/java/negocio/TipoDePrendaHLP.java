package negocio;

import java.util.Collection;
import java.util.Objects;

import dominio.Capa;
import dominio.Categoria;
import dominio.TipoDePrenda;
import dominio.TipoDeTela;

public class TipoDePrendaHLP {
	
	public TipoDePrendaHLP() {}	
	
	public TipoDePrenda crearTipoDePrenda(String nombre, Categoria categoria, Collection<TipoDeTela> tiposDeTelaPermitidos, Capa capa) {
		//Validaciones//
		Objects.requireNonNull(nombre);
		Objects.requireNonNull(categoria);
		Objects.requireNonNull(tiposDeTelaPermitidos);
		Objects.requireNonNull(capa);
		//FIN VALIDACIONES//
		return new TipoDePrenda(nombre, categoria, tiposDeTelaPermitidos);
	}
	
	public void agregarTelaPermitida(TipoDePrenda tipoDePrenda, TipoDeTela tela) {
		tipoDePrenda.getTiposDeTelasPermitidas().add(tela);
	}
	
	public boolean esTelaValida(TipoDePrenda tipoDePrenda, TipoDeTela tela) {
		return tipoDePrenda.getTiposDeTelasPermitidas().contains(tela);
	}

}
