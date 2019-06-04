package negocio;

import dominio.Guardarropa;
import dominio.Usuario;

public class UsuarioHLP {

	public UsuarioHLP() {	}

	public Usuario crearUsuario() {
		return new Usuario();
	}
	
	public void adquirirGuardarropa(Usuario usuario, Guardarropa guardarropa) {
		usuario.getGuardarropas().add(guardarropa);
	}
	
}
