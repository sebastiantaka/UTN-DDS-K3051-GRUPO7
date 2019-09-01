package dominio;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Evento {

	private Set<Usuario> usuarios = new HashSet<Usuario>();
	private Date fecha;
	private OrganizadorDeAviso organizador;
	private Ciudad ciudad;
	private String descripcion;
	private List<Atuendo> sugerencias;
	private Atuendo atuendo;
	private TipoDeEvento tipoDeEvento;

	public List<Atuendo> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<Atuendo> sugerencias) {
		this.sugerencias = sugerencias;
	}

	public Evento() {};
	
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

	public Atuendo getAtuendo() {
		return atuendo;
	}

	public void setAtuendo(Atuendo atuendo) {
		this.atuendo = atuendo;
	}

	public TipoDeEvento getTipoDeEvento() {
		return tipoDeEvento;
	}

	public void setTipoDeEvento(TipoDeEvento tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public OrganizadorDeAviso getOrganizador() {
		return organizador;
	}

	public void setOrganizador(OrganizadorDeAviso organizador) {
		this.organizador = organizador;
	}

}
