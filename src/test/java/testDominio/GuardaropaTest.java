package testDominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import dominio.Capa;
import dominio.Categoria;
import dominio.Color;
import dominio.Guardarropa;
import dominio.NivelDeCalorNulo;
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
	private Color rojo = new Color("rojo");;
	private Color negro = new Color("negro");;
	private Color blanco = new Color("blanco");;
	private Color azul = new Color("azul");
	private TipoDeTela vidrio = new TipoDeTela("vidrio");
	private TipoDeTela gamuza = new TipoDeTela("gamuza");
	private TipoDeTela cuero = new TipoDeTela("cuero");
	private TipoDeTela jean = new TipoDeTela("jean");
	private TipoDeTela algodon = new TipoDeTela("algodon");
	private TipoDePrendaHLP tipoPrenda = new TipoDePrendaHLP();
	private PrendaHLP prendaH = new PrendaHLP();
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
		
		tiposDeAnteojos.add(vidrio);
		tiposDeTelaRemera.add(algodon);
		tiposDelPantalon.add(jean);
		tiposDeZapatilla.add(cuero);
		tiposDeZapatilla.add(gamuza);
		
		remera = tipoPrenda.crearTipoDePrenda("Remera", parteSuperior,  tiposDeTelaRemera, capaMedia, new NivelDeCalorNulo());
		pantalon = tipoPrenda.crearTipoDePrenda("Pantalon", parteInferior, tiposDelPantalon, capaMedia, new NivelDeCalorNulo() );
		zapatilla = tipoPrenda.crearTipoDePrenda("Zapatilla", calzado, tiposDeZapatilla, capaMedia, new NivelDeCalorNulo() );
		anteojo = tipoPrenda.crearTipoDePrenda("Anteojos", accesorio, tiposDeAnteojos, capaMedia, new NivelDeCalorNulo() );
		
		tipoPrenda.agregarTelaPermitida(anteojo, vidrio);
		tipoPrenda.agregarTelaPermitida(remera, algodon);
		tipoPrenda.agregarTelaPermitida(pantalon, jean);
		tipoPrenda.agregarTelaPermitida(zapatilla, cuero);
		tipoPrenda.agregarTelaPermitida(zapatilla, gamuza);
		
		prenda = prendaH.crearPrendaDeUnColor("Remera Blanca Lisa", remera, algodon,  blanco);
		prenda2 = prendaH.crearPrendaDeUnColor("Remera Roja Lisa", remera ,algodon, rojo);
		prenda3 = prendaH.crearPrendaDeUnColor("Pantalon Jean Azul", pantalon, jean, azul);
		prenda4 = prendaH.crearPrendaDeUnColor("Zapatilla de Cuero Negro", zapatilla, cuero, negro);
		prenda5 = prendaH.crearPrendaDeUnColor("Zapatilla de Cuero Rojo", zapatilla, cuero, rojo);
		prenda6 = prendaH.crearPrendaDeUnColor("Anteojos de Sol", anteojo, vidrio, negro);
		
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
		
		prenda7 = prendaH.crearPrendaDeUnColor("Zapatilla de Gamuza", zapatilla, gamuza, negro);
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
	
	
}