package testDominio;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import dominio.Guardarropa;
import dominio.Usuario;

public class UsuarioTest {
	
	Usuario usuario;
	Guardarropa guardarropa;
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario(new HashSet<Guardarropa>());
		guardarropa = new Guardarropa();
		
	}

	@Test
	public void UsuarioNoTieneGuardarropasInicialmenteTest() {
		assertEquals(0, usuario.getGuardarropas().size());
	}
	
	@Test
	public void UsuarioPuedeComprarGuardarropasTest() {
		assertEquals(0, usuario.getGuardarropas().size());
		usuario.adquirirGuardarropa(guardarropa);
		assertEquals(1, usuario.getGuardarropas().size());
		assertTrue(usuario.getGuardarropas().contains(guardarropa));
	}

}
