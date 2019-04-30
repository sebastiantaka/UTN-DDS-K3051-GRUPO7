package testDominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.Remera;


public class RemeraTest {
	
	private Remera remera;
	
	@Before
	public void init() {
		remera = new Remera("Remera", "Parte superior", "Algodon", "Blanco");
	}
	
	@Test
	public void test_ColorRemera() {
		assertEquals("Blanco", remera.getColor());
	}

}
