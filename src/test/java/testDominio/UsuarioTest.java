package testDominio;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import dominio.Guardarropa;
import dominio.Usuario;
import negocio.GuardarropaHLP;
import negocio.UsuarioHLP;

public class UsuarioTest {
	
	Usuario usuario;
	Guardarropa guardarropa;
	UsuarioHLP usuariohlp;
	
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario();
		guardarropa = new Guardarropa();
		usuariohlp = new UsuarioHLP();
		
	}

	@Test
	public void UsuarioNoTieneGuardarropasInicialmenteTest() {
		assertEquals(0, usuario.getGuardarropas().size());
	}
	
	@Test
	public void UsuarioPuedeComprarGuardarropasTest() {
		assertEquals(0, usuario.getGuardarropas().size());
		usuariohlp.adquirirGuardarropa(usuario, guardarropa);
		assertEquals(1, usuario.getGuardarropas().size());
		assertTrue(usuario.getGuardarropas().contains(guardarropa));
	}

}
