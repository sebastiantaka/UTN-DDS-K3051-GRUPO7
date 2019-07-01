package testDominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
	
	private Prenda prenda;
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
	private Color rojo = new Color("rojo");;
	private Color negro = new Color("negro");;
	private Color blanco = new Color("blanco");;
	private Color azul = new Color("azul");
	private TipoDeTela vidrio = new TipoDeTela("vidrio", 0);
	private TipoDeTela gamuza = new TipoDeTela("gamuza", 0);
	private TipoDeTela cuero = new TipoDeTela("cuero", 0);
	private TipoDeTela jean = new TipoDeTela("jean", 0);
	private TipoDeTela algodon = new TipoDeTela("algodon", 0);
	
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
		
		tiposDeAnteojos.add(vidrio);
		tiposDeTelaRemera.add(algodon);
		tiposDeTelaRemera.add(jean);
		tiposDelPantalon.add(jean);
		tiposDeZapatilla.add(cuero);
		tiposDeZapatilla.add(gamuza);
		
		nivelDeCalorNulo = new NivelDeCalorNulo();
		
		pantalon = tipoPrenda.crearTipoDePrenda("Pantalon", parteInferior, tiposDelPantalon, capaMedia, nivelDeCalorNulo );
		zapatilla = tipoPrenda.crearTipoDePrenda("Zapatilla", calzado, tiposDeZapatilla, capaMedia, nivelDeCalorNulo);
		anteojo = tipoPrenda.crearTipoDePrenda("Anteojos", accesorio, tiposDeAnteojos, capaMedia, nivelDeCalorNulo);
		
		tipoPrenda.agregarTelaPermitida(anteojo, vidrio);
		tipoPrenda.agregarTelaPermitida(pantalon, jean);
		tipoPrenda.agregarTelaPermitida(zapatilla, cuero);
		tipoPrenda.agregarTelaPermitida(zapatilla, gamuza);
		
		
	}
	
	@Test
	public void test_prendaDeUnColor() {
		remera = tipoPrenda.crearTipoDePrenda("Remera", parteSuperior,  tiposDeTelaRemera, capaMedia, nivelDeCalorNulo);
		tipoPrenda.agregarTelaPermitida(remera, algodon);
		prenda2 = prendaH.crearPrendaDeUnColor("Remera de algodon roja", remera ,algodon, rojo);
		assertEquals(Prenda.class , prenda2.getClass());
		
	}	
	
	@Test
	public void test_prenda() {
		remera = tipoPrenda.crearTipoDePrenda("Remera", parteSuperior,  tiposDeTelaRemera, capaMedia, nivelDeCalorNulo);
		tipoPrenda.agregarTelaPermitida(remera, algodon);
		prenda2 = prendaH.crearPrenda("Remera de algodon Roja y azul Rayada", remera , algodon, rojo, azul);
		assertEquals(Prenda.class , prenda2.getClass());
		
	}	
	
	@Test
	public void test_agregarTelaAprenda() {
		tipoPrenda.agregarTelaPermitida(pantalon, cuero);
		assertTrue(tipoPrenda.esTelaValida(pantalon, cuero));
		
	}	
	
	@Test
	public void test_telaNoValida() {
		
		assertEquals(false , tipoPrenda.esTelaValida(pantalon, gamuza));
		
	}	
	
	@Test
	public void test_prendasDistintaTelayDistintoColor() {
		remera = tipoPrenda.crearTipoDePrenda("Remera", parteSuperior,  tiposDeTelaRemera, capaMedia, nivelDeCalorNulo);
		tipoPrenda.agregarTelaPermitida(remera, algodon);
		prenda = prendaH.crearPrendaDeUnColor("Remera de jean negra", remera ,jean, negro);
		prenda2 = prendaH.crearPrendaDeUnColor("Remera de algodon roja", remera ,algodon, rojo);
		assertEquals(prenda.getClass() , prenda2.getClass());
		assertNotEquals(prenda.getTipoDeTela(), prenda2.getTipoDeTela());
		assertNotEquals(prenda.getColorPrimario(), prenda2.getColorPrimario());
	}	
	
}