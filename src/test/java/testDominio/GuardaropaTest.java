package testDominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dominio.Atuendo;
import dominio.Categoria;
import dominio.Color;
import dominio.Guardarropa;
import dominio.Prenda;
import dominio.TipoDePrenda;
import dominio.TipoDeTela;
import negocio.GuardarropaHLP;
import negocio.PrendaHLP;
import negocio.TipoDePrendaHLP;

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
	private Prenda prenda7;
	private TipoDePrendaHLP tipoPrenda = new TipoDePrendaHLP();
	private PrendaHLP prendaH = new PrendaHLP();
	private GuardarropaHLP guardarropaH = new GuardarropaHLP();
	
	
	@Before
	public void init() {

		tiposDeTelaRemera = new HashSet<TipoDeTela>();
		tiposDelPantalon = new HashSet<TipoDeTela>();
		tiposDeZapatilla = new HashSet<TipoDeTela>();
		tiposDeAnteojos = new HashSet<TipoDeTela>();
		
		tiposDeAnteojos.add(TipoDeTela.VIDRIO);
		tiposDeTelaRemera.add(TipoDeTela.ALGODON);
		tiposDelPantalon.add(TipoDeTela.JEAN);
		tiposDeZapatilla.add(TipoDeTela.CUERO);
		tiposDeZapatilla.add(TipoDeTela.GAMUZA);
		
		remera = tipoPrenda.crearTipoDePrenda("Remera",Categoria.PARTE_SUPERIOR,  tiposDeTelaRemera);
		pantalon = tipoPrenda.crearTipoDePrenda("Pantalon", Categoria.PARTE_INFERIOR, tiposDelPantalon );
		zapatilla = tipoPrenda.crearTipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeZapatilla );
		anteojo = tipoPrenda.crearTipoDePrenda("Anteojos", Categoria.ACCESORIO, tiposDeAnteojos );
		
		tipoPrenda.agregarTelaPermitida(anteojo, TipoDeTela.VIDRIO);
		tipoPrenda.agregarTelaPermitida(remera, TipoDeTela.ALGODON);
		tipoPrenda.agregarTelaPermitida(pantalon, TipoDeTela.JEAN);
		tipoPrenda.agregarTelaPermitida(zapatilla, TipoDeTela.CUERO);
		tipoPrenda.agregarTelaPermitida(zapatilla, TipoDeTela.GAMUZA);
		
		prenda = prendaH.crearPrendaDeUnColor(remera, TipoDeTela.ALGODON,  Color.BLANCO);
		prenda2 = prendaH.crearPrendaDeUnColor(remera ,TipoDeTela.ALGODON, Color.ROJO);
		prenda3 = prendaH.crearPrendaDeUnColor(pantalon, TipoDeTela.JEAN, Color.AZUL);
		prenda4 = prendaH.crearPrendaDeUnColor(zapatilla, TipoDeTela.CUERO, Color.NEGRO);
		prenda5 = prendaH.crearPrendaDeUnColor(zapatilla, TipoDeTela.CUERO, Color.ROJO);
		prenda6 = prendaH.crearPrendaDeUnColor(anteojo, TipoDeTela.VIDRIO, Color.NEGRO);
		
		guardarropa = new Guardarropa();
		
		guardarropaH.adquirirPrenda(guardarropa, prenda);
		guardarropaH.adquirirPrenda(guardarropa, prenda2);
		guardarropaH.adquirirPrenda(guardarropa, prenda3);
		guardarropaH.adquirirPrenda(guardarropa, prenda4);
		guardarropaH.adquirirPrenda(guardarropa, prenda5);
		guardarropaH.adquirirPrenda(guardarropa, prenda6);
		
	}
	
	@Test
	public void test_guardaropaTienePrendas() {
		
		assertEquals(6, guardarropa.cantidadDePrendas());
	}
	
	@Test
	public void test_guardaropaAgregaPrendas() {
		
		prenda7 = prendaH.crearPrendaDeUnColor(zapatilla, TipoDeTela.GAMUZA, Color.NEGRO);
		guardarropaH.adquirirPrenda(guardarropa, prenda7);
		assertEquals(7, guardarropa.cantidadDePrendas());
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
		List<Set<Prenda>> ropaSeparada = guardarropaH.separarRopaPorCategoria(guardarropa);
		assertTrue(ropaSeparada.get(prenda.getCategoria().ordinal()).contains(prenda));
		assertTrue(ropaSeparada.get(prenda2.getCategoria().ordinal()).contains(prenda2));
		assertTrue(ropaSeparada.get(prenda3.getCategoria().ordinal()).contains(prenda3));
		assertTrue(ropaSeparada.get(prenda4.getCategoria().ordinal()).contains(prenda4));
		assertTrue(ropaSeparada.get(prenda5.getCategoria().ordinal()).contains(prenda5));
		assertTrue(ropaSeparada.get(prenda6.getCategoria().ordinal()).contains(prenda6));
	}
	
	@Test public void obtenerSugerenciasTest() {
		Set<Atuendo> sugerencias = guardarropaH.obtenerSugerencias(guardarropa);
		sugerencias.forEach(sugerencia -> System.out.println(sugerencia));
		assertEquals(8, sugerencias.size());
	}
}
