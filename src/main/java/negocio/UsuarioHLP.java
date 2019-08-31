package negocio;

import dominio.Guardarropa;
import dominio.PlanGratuito;
import dominio.PlanPremium;
import dominio.Usuario;
import exceptions.PrestacionesDePlanSuperadasException;

public class UsuarioHLP {

	public UsuarioHLP() {	}

	public Usuario crearUsuarioGratuito() {
		return new Usuario(new PlanGratuito());
	}
	
	public Usuario crearUsuarioPremium() {
		return new Usuario(new PlanPremium());
	}
	
	public void adquirirGuardarropa(Usuario usuario, Guardarropa guardarropa) throws PrestacionesDePlanSuperadasException {
		usuario.getGuardarropas().add(guardarropa);
		guardarropa.agregarUsuario(usuario);
	}
	
	
	
}
