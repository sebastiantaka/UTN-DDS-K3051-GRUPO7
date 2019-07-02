package testDominio;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dominio.Guardarropa;
import dominio.PlanGratuito;
import dominio.PlanPremium;
import dominio.Usuario;
import exceptions.PrestacionesDePlanSuperadasException;
import negocio.UsuarioHLP;

public class UsuarioTest {
	
	Usuario usuarioGratuito;
	Usuario usuarioPremium;
	Guardarropa guardarropa;
	UsuarioHLP usuariohlp;
	
	
	@Before
	public void setUp() throws Exception {
		usuarioGratuito = new Usuario(new PlanGratuito());
		usuarioPremium = new Usuario(new PlanPremium());
		guardarropa = new Guardarropa();
		usuariohlp = new UsuarioHLP();
	}

	@Test
	public void UsuarioNoTieneGuardarropasInicialmenteTest() {
		assertEquals(0, usuarioGratuito.getGuardarropas().size());
	}
	
	@Test
	public void UsuarioGratuitoSoloPuedeCargar10Guardarropas() {
		assertEquals(new Integer(10), usuarioGratuito.getPlan().getMaximosGuardarropas());
	}
	
	@Test
	public void UsuarioPremiumCargaLosMaximosGuardarropas() {
		assertEquals(Integer.MAX_VALUE, (int)Integer.valueOf(usuarioPremium.getPlan().getMaximosGuardarropas()));
	}
	
	@Test
	public void UsuarioPuedeComprarGuardarropasTest() throws PrestacionesDePlanSuperadasException {
		assertEquals(0, usuarioGratuito.getGuardarropas().size());
		usuariohlp.adquirirGuardarropa(usuarioGratuito, guardarropa);
		assertEquals(1, usuarioGratuito.getGuardarropas().size());
		assertTrue(usuarioGratuito.getGuardarropas().contains(guardarropa));
	}
	
	@Test(expected = PrestacionesDePlanSuperadasException.class)
	public void UsuarioGratuitoNoPuedeComprarMasDeLoQueSeLePermite() throws PrestacionesDePlanSuperadasException, CloneNotSupportedException {
		usuariohlp.adquirirGuardarropa(usuarioGratuito, guardarropa);
		for (int i = 0; i <= usuarioGratuito.getPlan().getMaximosGuardarropas(); i++) {
			Guardarropa guardarropaExtra = guardarropa.clone();
			usuariohlp.adquirirGuardarropa(usuarioGratuito, guardarropaExtra);
		}
	}

}
