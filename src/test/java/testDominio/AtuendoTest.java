package testDominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dominio.Atuendo;
import dominio.Capa;
import dominio.Categoria;
import dominio.Color;
import dominio.Guardarropa;
import dominio.NivelDeCalorNulo;
import dominio.Prenda;
import dominio.TipoDePrenda;
import dominio.TipoDeTela;
import negocio.AtuendoHLP;
import negocio.GuardarropaHLP;
import negocio.PrendaHLP;
import negocio.TipoDePrendaHLP;

public class AtuendoTest {
	
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
	private TipoDePrendaHLP tipoPrenda = new TipoDePrendaHLP();
	private PrendaHLP prendaH = new PrendaHLP();
	private AtuendoHLP atuendoH = new AtuendoHLP();
	private GuardarropaHLP guardarropaH = new GuardarropaHLP();
	private Capa capaMedia;
	private Categoria parteSuperior;
	private Categoria parteInferior;
	private Categoria calzado;
	private Categoria accesorio;
	private List<Capa> capasPermitidas;
	
	@Before
	public void init() {
		
		capaMedia = new Capa("Capa Media", 1, false);
		
		capasPermitidas = new ArrayList<Capa>();
		capasPermitidas.add(capaMedia);
		
		parteSuperior = new Categoria("Parte Superior", capasPermitidas, false);
		parteInferior = new Categoria("Parte Inferior", capasPermitidas, false);
		calzado = new Categoria("Calzado", capasPermitidas, false);
		accesorio = new Categoria("Accesorio", capasPermitidas, true);
		
		
		tiposDeTelaRemera = new HashSet<TipoDeTela>();
		tiposDelPantalon = new HashSet<TipoDeTela>();
		tiposDeZapatilla = new HashSet<TipoDeTela>();
		tiposDeAnteojos = new HashSet<TipoDeTela>();
		
		tiposDeAnteojos.add(TipoDeTela.VIDRIO);
		tiposDeTelaRemera.add(TipoDeTela.ALGODON);
		tiposDelPantalon.add(TipoDeTela.JEAN);
		tiposDeZapatilla.add(TipoDeTela.CUERO);
		tiposDeZapatilla.add(TipoDeTela.GAMUZA);
		
		remera = tipoPrenda.crearTipoDePrenda("Remera", parteSuperior,  tiposDeTelaRemera, capaMedia, new NivelDeCalorNulo());
		pantalon = tipoPrenda.crearTipoDePrenda("Pantalon", parteInferior, tiposDelPantalon, capaMedia, new NivelDeCalorNulo() );
		zapatilla = tipoPrenda.crearTipoDePrenda("Zapatilla", calzado, tiposDeZapatilla, capaMedia, new NivelDeCalorNulo() );
		anteojo = tipoPrenda.crearTipoDePrenda("Anteojos", accesorio, tiposDeAnteojos, capaMedia, new NivelDeCalorNulo() );
		
		tipoPrenda.agregarTelaPermitida(anteojo, TipoDeTela.VIDRIO);
		tipoPrenda.agregarTelaPermitida(remera, TipoDeTela.ALGODON);
		tipoPrenda.agregarTelaPermitida(pantalon, TipoDeTela.JEAN);
		tipoPrenda.agregarTelaPermitida(zapatilla, TipoDeTela.CUERO);
		tipoPrenda.agregarTelaPermitida(zapatilla, TipoDeTela.GAMUZA);
		
		prenda = prendaH.crearPrendaDeUnColor("Remera Blanca Lisa", remera, TipoDeTela.ALGODON,  Color.BLANCO);
		prenda2 = prendaH.crearPrendaDeUnColor("Remera Roja Lisa", remera ,TipoDeTela.ALGODON, Color.ROJO);
		prenda3 = prendaH.crearPrendaDeUnColor("Pantalon Jean Azul", pantalon, TipoDeTela.JEAN, Color.AZUL);
		prenda4 = prendaH.crearPrendaDeUnColor("Zapatilla de Cuero Negro", zapatilla, TipoDeTela.CUERO, Color.NEGRO);
		prenda5 = prendaH.crearPrendaDeUnColor("Zapatilla de Cuero Rojo", zapatilla, TipoDeTela.CUERO, Color.ROJO);
		prenda6 = prendaH.crearPrendaDeUnColor("Anteojos de Sol", anteojo, TipoDeTela.VIDRIO, Color.NEGRO);
		
		guardarropa = new Guardarropa();
		
		guardarropaH.adquirirPrenda(guardarropa, prenda);
		guardarropaH.adquirirPrenda(guardarropa, prenda2);
		guardarropaH.adquirirPrenda(guardarropa, prenda3);
		guardarropaH.adquirirPrenda(guardarropa, prenda4);
		guardarropaH.adquirirPrenda(guardarropa, prenda5);
		guardarropaH.adquirirPrenda(guardarropa, prenda6);
		
	}

	@Test
	public void separarRopaPorCategoriaTest() {
		Map<Categoria, Set<Prenda>> ropaSeparada = atuendoH.separarRopaPorCategoria(guardarropa.getPrendas());
		assertTrue(ropaSeparada.get(prenda.getCategoria()).contains(prenda));
		assertTrue(ropaSeparada.get(prenda2.getCategoria()).contains(prenda2));
		assertTrue(ropaSeparada.get(prenda3.getCategoria()).contains(prenda3));
		assertTrue(ropaSeparada.get(prenda4.getCategoria()).contains(prenda4));
		assertTrue(ropaSeparada.get(prenda5.getCategoria()).contains(prenda5));
		assertTrue(ropaSeparada.get(prenda6.getCategoria()).contains(prenda6));
	}
	
	@Test public void obtenerSugerenciasTest() {
		Set<Atuendo> sugerencias = atuendoH.obtenerSugerencias(guardarropa);
		sugerencias.forEach(sugerencia -> System.out.println(sugerencia));
		assertEquals(8, sugerencias.size());
	}

}
