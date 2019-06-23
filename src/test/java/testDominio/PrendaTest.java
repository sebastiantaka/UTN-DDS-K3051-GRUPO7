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
import negocio.PrendaHLP;
import negocio.TipoDePrendaHLP;

public class PrendaTest {
	
	private Prenda prenda;
	private Prenda prenda2;
	private Prenda prenda3;
	private Prenda prenda4;
	private Prenda prenda5;
	private Prenda prenda6;
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
		
		
		pantalon = tipoPrenda.crearTipoDePrenda("Pantalon", Categoria.PARTE_INFERIOR, tiposDelPantalon );
		zapatilla = tipoPrenda.crearTipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeZapatilla );
		anteojo = tipoPrenda.crearTipoDePrenda("Anteojos", Categoria.ACCESORIO, tiposDeAnteojos );
		tipoPrenda.agregarTelaPermitida(anteojo, TipoDeTela.VIDRIO);
		
		tipoPrenda.agregarTelaPermitida(pantalon, TipoDeTela.JEAN);
		tipoPrenda.agregarTelaPermitida(zapatilla, TipoDeTela.CUERO);
		tipoPrenda.agregarTelaPermitida(zapatilla, TipoDeTela.GAMUZA);
		prenda = prendaH.crearPrendaDeUnColor(remera, TipoDeTela.ALGODON,  Color.BLANCO);
		
		prenda3 = prendaH.crearPrendaDeUnColor(pantalon, TipoDeTela.JEAN, Color.AZUL);
		prenda4 = prendaH.crearPrendaDeUnColor(zapatilla, TipoDeTela.CUERO, Color.NEGRO);
		prenda5 = prendaH.crearPrendaDeUnColor(zapatilla, TipoDeTela.CUERO, Color.ROJO);
		prenda6 = prendaH.crearPrendaDeUnColor(anteojo, TipoDeTela.VIDRIO, Color.NEGRO);
		
		
	}
	
	@Test
	public void test_prendaDeUnColor() {
		remera = tipoPrenda.crearTipoDePrenda("Remera",Categoria.PARTE_SUPERIOR,  tiposDeTelaRemera);
		tipoPrenda.agregarTelaPermitida(remera, TipoDeTela.ALGODON);
		prenda2 = prendaH.crearPrendaDeUnColor(remera ,TipoDeTela.ALGODON, Color.ROJO);
		assertEquals(Prenda.class , prenda2.getClass());
		
	}	
	
	@Test
	public void test_prenda() {
		remera = tipoPrenda.crearTipoDePrenda("Remera",Categoria.PARTE_SUPERIOR,  tiposDeTelaRemera);
		tipoPrenda.agregarTelaPermitida(remera, TipoDeTela.ALGODON);
		prenda2 = prendaH.crearPrenda(remera ,TipoDeTela.ALGODON, Color.ROJO, Color.AZUL);
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