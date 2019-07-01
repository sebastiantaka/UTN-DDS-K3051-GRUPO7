package testDominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dominio.Capa;
import dominio.Categoria;
import dominio.Color;
import dominio.NivelDeCalorNulo;
import dominio.Prenda;
import dominio.TipoDePrenda;
import dominio.TipoDeTela;
import negocio.PrendaHLP;
import negocio.TipoDePrendaHLP;

public class PrendaTest {
	
	private Prenda prenda2;
	private TipoDePrenda remera;
	private TipoDePrenda pantalon;
	private TipoDePrenda zapatilla;
	private TipoDePrenda anteojo;
	private Set<TipoDeTela> tiposDeTelaRemera;
	private Set<TipoDeTela> tiposDelPantalon;
	private Set<TipoDeTela> tiposDeZapatilla;
	private Set<TipoDeTela> tiposDeAnteojos;
	private TipoDePrendaHLP tipoPrenda = new TipoDePrendaHLP();
	private PrendaHLP prendaH = new PrendaHLP();
	private Capa capaMedia;
	private Categoria parteSuperior;
	private Categoria parteInferior;
	private Categoria calzado;
	private Categoria accesorio;
	private List<Capa> capasPermitidas;
	private NivelDeCalorNulo nivelDeCalorNulo;
	
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
		
		nivelDeCalorNulo = new NivelDeCalorNulo();
		
		pantalon = tipoPrenda.crearTipoDePrenda("Pantalon", parteInferior, tiposDelPantalon, capaMedia, nivelDeCalorNulo );
		zapatilla = tipoPrenda.crearTipoDePrenda("Zapatilla", calzado, tiposDeZapatilla, capaMedia, nivelDeCalorNulo);
		anteojo = tipoPrenda.crearTipoDePrenda("Anteojos", accesorio, tiposDeAnteojos, capaMedia, nivelDeCalorNulo);
		
		tipoPrenda.agregarTelaPermitida(anteojo, TipoDeTela.VIDRIO);
		tipoPrenda.agregarTelaPermitida(pantalon, TipoDeTela.JEAN);
		tipoPrenda.agregarTelaPermitida(zapatilla, TipoDeTela.CUERO);
		tipoPrenda.agregarTelaPermitida(zapatilla, TipoDeTela.GAMUZA);
		
		
	}
	
	@Test
	public void test_prendaDeUnColor() {
		remera = tipoPrenda.crearTipoDePrenda("Remera", parteSuperior,  tiposDeTelaRemera, capaMedia, nivelDeCalorNulo);
		tipoPrenda.agregarTelaPermitida(remera, TipoDeTela.ALGODON);
		prenda2 = prendaH.crearPrendaDeUnColor("Remera de algodon roja", remera ,TipoDeTela.ALGODON, Color.ROJO);
		assertEquals(Prenda.class , prenda2.getClass());
		
	}	
	
	@Test
	public void test_prenda() {
		remera = tipoPrenda.crearTipoDePrenda("Remera", parteSuperior,  tiposDeTelaRemera, capaMedia, nivelDeCalorNulo);
		tipoPrenda.agregarTelaPermitida(remera, TipoDeTela.ALGODON);
		prenda2 = prendaH.crearPrenda("Remera de algodon Roja y azul Rayada", remera ,TipoDeTela.ALGODON, Color.ROJO, Color.AZUL);
		assertEquals(Prenda.class , prenda2.getClass());
		
	}	
	
	@Test
	public void test_agregarTelaAprenda() {
		tipoPrenda.agregarTelaPermitida(pantalon, TipoDeTela.CUERO);
		assertTrue(tipoPrenda.esTelaValida(pantalon, TipoDeTela.CUERO));
		
	}	
	
	@Test
	public void test_telaNoValida() {
		
		assertEquals(false , tipoPrenda.esTelaValida(pantalon, TipoDeTela.GAMUZA));
		
	}	
	
	
	
}