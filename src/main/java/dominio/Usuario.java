package dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Usuario {
	
	private Set<Guardarropa> guardarropas = new HashSet<Guardarropa>();
	private IPlan plan;
	private Set<Evento> eventosRegistrados = new HashSet<Evento>();
	private String email;
	private String contrase�a;
	private Collection<Notificacion> notificaciones = new ArrayList<Notificacion>();
	
	
	public Usuario(IPlan plan) {	
		this.setPlan(plan);
	}

	public Set<Guardarropa> getGuardarropas() {
		return guardarropas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public Collection<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Collection<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
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
	
	public void addGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
}
