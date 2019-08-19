package dominio;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
	
	private Set<Guardarropa> guardarropas = new HashSet<Guardarropa>();
	private IPlan plan;
	private Set<Evento> eventosRegistrados = new HashSet<Evento>();
	
	public Usuario(IPlan plan) {	
		this.setPlan(plan);
	}

	public Set<Guardarropa> getGuardarropas() {
		return guardarropas;
	}

	public void setGuardarropas(Set<Guardarropa> guardarropas) {
		this.guardarropas = guardarropas;
	}

	public IPlan getPlan() {
		return plan;
	}

	public void setPlan(IPlan plan) {
		this.plan = plan;
	}

	public Set<Evento> getEventosRegistrados() {
		return eventosRegistrados;
	}

	public void setEventosRegistrados(Set<Evento> eventosRegistrados) {
		this.eventosRegistrados = eventosRegistrados;
	}

	public void addEventosRegistrados(Evento evento){
		this.eventosRegistrados.add(evento);
	}
}
