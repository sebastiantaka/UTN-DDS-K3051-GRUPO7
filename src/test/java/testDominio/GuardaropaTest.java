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

public class GuardaropaTest {
	
	private Prenda prenda;
	private Prenda prenda2;
	private Guardarropa guardarropa;
	private TipoDePrenda remera;
	private TipoDePrenda pantalon;
	private TipoDePrenda zapatilla;
	private TipoDePrenda anteojo;
	private Set<TipoDeTela> tiposDeTelaRemera;
	private Set<TipoDeTela> tiposDelPantalon;
	private Set<TipoDeTela> tiposDeZapatilla;
	private Set<TipoDeTela> tiposDeAnteojos;
	private Prenda prenda3;
	private Prenda prenda4;
	private Prenda prenda5;
	private Prenda prenda6;
	
	@Before
	public void init() {
		tiposDeTelaRemera = new HashSet<TipoDeTela>();
		tiposDeTelaRemera.add(TipoDeTela.ALGODON);
		
		tiposDelPantalon = new HashSet<TipoDeTela>();
		tiposDelPantalon.add(TipoDeTela.JEAN);
		
		tiposDeZapatilla = new HashSet<TipoDeTela>();
		tiposDeZapatilla.add(TipoDeTela.CUERO);
		
		tiposDeAnteojos = new HashSet<TipoDeTela>();
		tiposDeAnteojos.add(TipoDeTela.VIDRIO);
		
		remera = new TipoDePrenda("Remera", Categoria.PARTE_SUPERIOR, tiposDeTelaRemera );
		pantalon = new TipoDePrenda("Pantalon", Categoria.PARTE_INFERIOR, tiposDelPantalon );
		zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeZapatilla );
		anteojo = new TipoDePrenda("Anteojos", Categoria.ACCESORIO, tiposDeAnteojos );
		
		prenda = new Prenda(remera ,TipoDeTela.ALGODON, Color.BLANCO);
		prenda2 = new Prenda(remera ,TipoDeTela.ALGODON, Color.ROJO);
		prenda3 = new Prenda(pantalon, TipoDeTela.JEAN, Color.AZUL);
		prenda4 = new Prenda(zapatilla, TipoDeTela.CUERO, Color.NEGRO);
		prenda5 = new Prenda(zapatilla, TipoDeTela.CUERO, Color.ROJO);
		prenda6 = new Prenda(anteojo, TipoDeTela.VIDRIO, Color.NEGRO);
		
		guardarropa = new Guardarropa();
		
		guardarropa.agregarPrendas(prenda);
		guardarropa.agregarPrendas(prenda2);
		guardarropa.agregarPrendas(prenda3);
		guardarropa.agregarPrendas(prenda4);
		guardarropa.agregarPrendas(prenda5);
		guardarropa.agregarPrendas(prenda6);
		
	}
	
	@Test
	public void test_guardaropaTieneDosPrendas() {
		
		assertEquals(6, guardarropa.cantidadDePrendas());
	}
	
	@Test
	public void test_guardaropaNoEstaVacio() {
		
		assertNotNull(guardarropa);
	}
	
	/*
	@Test
	public void test_alMenosUnAtuendo(){
	assertEquals(true, guardaropa.getPrendasDeseadas(Zapatillas.class).stream.findAny());
	}
	*/
	
	@Test
	public void separarRopaPorCategoriaTest() {
		List<Set<Prenda>> ropaSeparada = guardarropa.separarRopaPorCategoria();
		assertTrue(ropaSeparada.get(prenda.getCategoria().ordinal()).contains(prenda));
		assertTrue(ropaSeparada.get(prenda2.getCategoria().ordinal()).contains(prenda2));
		assertTrue(ropaSeparada.get(prenda3.getCategoria().ordinal()).contains(prenda3));
		assertTrue(ropaSeparada.get(prenda4.getCategoria().ordinal()).contains(prenda4));
		assertTrue(ropaSeparada.get(prenda5.getCategoria().ordinal()).contains(prenda5));
		assertTrue(ropaSeparada.get(prenda6.getCategoria().ordinal()).contains(prenda6));
	}
	
	@Test public void obtenerSugerenciasTest() {
		Set<List<Prenda>> sugerencias = guardarropa.obtenerSugerencias();
		sugerencias.forEach(sugerencia -> System.out.println(sugerencia));
		assertEquals(8, sugerencias.size());
	}
}
