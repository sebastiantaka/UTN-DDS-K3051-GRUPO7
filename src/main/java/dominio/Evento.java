package dominio;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Evento {

	private Set<Suscripcion> subscripcionUsuarios = new HashSet<Suscripcion>();
	private Date fecha;
	private OrganizadorDeAviso organizador;
	private Ciudad ciudad;
	private String descripcion;
	private TipoDeEvento tipoDeEvento;

	public Evento() {
	};

	public Evento(Date fecha, Ciudad ciudad, String descripcion) {
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoDeEvento getTipoDeEvento() {
		return tipoDeEvento;
	}

	public void setTipoDeEvento(TipoDeEvento tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}

	public OrganizadorDeAviso getOrganizador() {
		return organizador;
	}

	public void setOrganizador(OrganizadorDeAviso organizador) {
		this.organizador = organizador;
	}

	public Set<Suscripcion> getSubscripcionUsuarios() {
		return subscripcionUsuarios;
	}

	public void setSubscripcionUsuarios(Set<Suscripcion> subscripcionUsuarios) {
		this.subscripcionUsuarios = subscripcionUsuarios;
	}

}
