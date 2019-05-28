package testDominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dominio.Categoria;
import dominio.Color;
import dominio.Guardarropa;
import dominio.Prenda;
import dominio.TipoDePrenda;
import dominio.TipoDeTela;

public class PrendaTest {
	
	private Prenda prenda;
	private TipoDePrenda remera;
	private TipoDePrenda pantalon;
	private TipoDePrenda zapatilla;
	private TipoDePrenda anteojo;
	private Set<TipoDeTela> tiposDeTelaRemera;
	private Set<TipoDeTela> tiposDelPantalon;
	private Set<TipoDeTela> tiposDeZapatilla;
	private Set<TipoDeTela> tiposDeAnteojos;
	
	
	
	@Before
	public void init() {
		tiposDeTelaRemera = new HashSet<TipoDeTela>();
		tiposDeTelaRemera.add(TipoDeTela.ALGODON);
		
		tiposDelPantalon = new HashSet<TipoDeTela>();
		tiposDelPantalon.add(TipoDeTela.JEAN);
		
		tiposDeZapatilla = new HashSet<TipoDeTela>();
		tiposDeZapatilla.add(TipoDeTela.CUERO);
		tiposDeZapatilla.add(TipoDeTela.GAMUZA);
		
		tiposDeAnteojos = new HashSet<TipoDeTela>();
		tiposDeAnteojos.add(TipoDeTela.VIDRIO);
		
		remera = new TipoDePrenda("Remera", Categoria.PARTE_SUPERIOR, tiposDeTelaRemera );
		pantalon = new TipoDePrenda("Pantalon", Categoria.PARTE_INFERIOR, tiposDelPantalon );
		zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeZapatilla );
		anteojo = new TipoDePrenda("Anteojos", Categoria.ACCESORIO, tiposDeAnteojos );
		
		prenda = new Prenda(remera ,TipoDeTela.ALGODON, Color.BLANCO);
	}
	
	
	
}