package testDominio;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dominio.Guardarropa;
import dominio.Usuario;
import exceptions.PrestacionesDePlanSuperadasException;
import negocio.GuardarropaHLP;
import negocio.UsuarioHLP;

public class UsuarioTest {
	
	Usuario usuarioGratuito;
	Usuario usuarioPremium;
	Guardarropa guardarropa;
	UsuarioHLP usuariohlp;
	GuardarropaHLP guardarropaH;
	
	
	@Before
	public void setUp() throws Exception {
		usuariohlp = new UsuarioHLP();
		usuarioGratuito = usuariohlp.crearUsuarioGratuito();
		usuarioPremium = usuariohlp.crearUsuarioPremium();
		
		guardarropaH = new GuardarropaHLP();
		guardarropa = guardarropaH.crearGuardarropa();
		
	}

	@Test
	public void UsuarioNoTieneGuardarropasInicialmenteTest() {
		assertEquals(0, usuarioGratuito.getGuardarropas().size());
	}
	
	@Test
	public void UsuarioGratuitoSoloPuedeCargar10PrendasPorGuardarropa() {
		assertEquals(new Integer(10), usuarioGratuito.getPlan().getMaximasPrendasPorGuardarropa());
	}
	
	@Test
	public void UsuarioPremiumTienePrendasIlimitadasPorGuardarropa() {
		assertEquals(Integer.MAX_VALUE, (int)Integer.valueOf(usuarioPremium.getPlan().getMaximasPrendasPorGuardarropa()));
	}
	
	@Test
	public void UsuarioPuedeComprarGuardarropasTest() throws PrestacionesDePlanSuperadasException {
		assertEquals(0, usuarioGratuito.getGuardarropas().size());
		usuariohlp.adquirirGuardarropa(usuarioGratuito, guardarropa);
		assertEquals(1, usuarioGratuito.getGuardarropas().size());
		assertTrue(usuarioGratuito.getGuardarropas().contains(guardarropa));
	}

}
