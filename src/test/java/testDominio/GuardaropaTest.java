package testDominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import dominio.Guardaropa;
import dominio.Prenda;
import dominio.Remera;

public class GuardaropaTest {
	
	private Prenda prenda;
	private Prenda prenda2;
	private Guardaropa guardaropa;
	
	@Before
	public void init() {
		prenda = new Prenda(new Remera("Remera", "Parte superior", "Algodon", "Blanco"));
		prenda2 = new Prenda(new Remera("Remera", "Parte superior", "Nylon", "Rojo"));
		guardaropa = new Guardaropa();
		
		guardaropa.agregarPrendas(prenda);
		guardaropa.agregarPrendas(prenda2);
	}
	
	@Test
	public void test_guardaropaTieneDosPrendas() {
		
		assertEquals(2, guardaropa.cantidadDePrendas());
	}
	
	@Test
	public void test_guardaropaNoEstaVacio() {
		
		assertNotNull(guardaropa);
	}

}
