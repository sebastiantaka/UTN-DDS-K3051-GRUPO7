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
	private String contraseña;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
