package negocio;

import dominio.Atuendo;
import dominio.Suscripcion;

public class SuscripcionHLP {
	
	public Atuendo siguiente(Suscripcion suscripcion) throws Exception{
		Integer siguiente = suscripcion.getIndex() + 1;
		if(siguiente >= suscripcion.getAtuendos().size()) {
			throw new Exception("Ya no hay mas sugerencias ;(");
		}
		suscripcion.setIndex(siguiente);
		
		return suscripcion.getAtuendos().get(suscripcion.getIndex());
	}
	
	public Atuendo anterior(Suscripcion suscripcion) throws Exception{
		if (suscripcion.getIndex() - 1 <= 0) {
			throw new Exception("No podes volver mas atras, es el primero!!!");
		}
		suscripcion.setIndex(suscripcion.getIndex() - 1);
		
		return suscripcion.getAtuendos().get(suscripcion.getIndex());
	}
	
	public Atuendo execute(Suscripcion suscripcion) {
		suscripcion.setAtuendoConfirmado(suscripcion.getAtuendos().get(suscripcion.getIndex()));
		return suscripcion.getAtuendoConfirmado();
	}
	
	public Atuendo undo(Suscripcion suscripcion) {
		suscripcion.setAtuendoConfirmado(null);
		return suscripcion.getAtuendos().get(suscripcion.getIndex());
	}
}
