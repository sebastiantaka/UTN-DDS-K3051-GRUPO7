package negocio;

import java.util.Set;

import dominio.Guardarropa;
import dominio.Prenda;
import dominio.Usuario;
import exceptions.PrestacionesDePlanSuperadasException;

public class GuardarropaHLP {

	public GuardarropaHLP() { }

	public void agregarUsuario(Guardarropa guardarropa, Usuario usuario) {
		guardarropa.agregarUsuario(usuario);
		usuario.addGuardarropa(guardarropa);
	}
	
	public void adquirirPrenda(Guardarropa guardarropa, Prenda prenda, Usuario usuario) throws PrestacionesDePlanSuperadasException {
		if (guardarropa.getPrendas().size() > usuario.getPlan().getMaximasPrendasPorGuardarropa()) {
			throw new PrestacionesDePlanSuperadasException("Se superó la cantidad de prendas para guardar en este ropero en este Plan");
		}
		guardarropa.getPrendas().add(prenda);
	}
	
	public void adquirirPrendas(Guardarropa guardarropa, Set<Prenda> prendas, Usuario usuario) throws PrestacionesDePlanSuperadasException {
		if (guardarropa.cantidadDePrendas() + prendas.size() > usuario.getPlan().getMaximasPrendasPorGuardarropa()) {
			throw new PrestacionesDePlanSuperadasException("Se superó la cantidad de prendas para guardar en este ropero en este Plan");
		}
		guardarropa.agregarPrendas(prendas);
	}
	
	public void setPrendas(Guardarropa guardarropa, Set<Prenda> prendas, Usuario usuario) throws PrestacionesDePlanSuperadasException {
		if (prendas.size() > usuario.getPlan().getMaximasPrendasPorGuardarropa()) {
			throw new PrestacionesDePlanSuperadasException("Se superó la cantidad de prendas para guardar en este ropero en este Plan");
		}
		guardarropa.setPrendas(prendas);
	}
	
	public Guardarropa crearGuardarropa() {
		return new Guardarropa();
	}
	
	
}
