package negocio;

import dominio.Guardarropa;
import dominio.Prenda;

public class GuardarropaHLP {

	public GuardarropaHLP() { }
	
	public void adquirirPrenda(Guardarropa guardarropa, Prenda prenda) {
		guardarropa.getPrendas().add(prenda);
	}
	
	public Guardarropa crearGuardarropa() {
		return new Guardarropa();
	}
	
}
