package dominio;

import java.util.ArrayList;
import java.util.List;

public class Suscripcion {
	
	private Evento evento;
	private Usuario usuario;
	private List<Atuendo> atuendos = new ArrayList<Atuendo>();
	private Atuendo atuendoConfirmado;
	private Integer index = 0;
	
	public List<Atuendo> getAtuendos() {
		return atuendos;
	}

	public void setAtuendos(List<Atuendo> atuendos) {
		this.atuendos = atuendos;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Atuendo getAtuendoConfirmado() {
		return atuendoConfirmado;
	}

	public void setAtuendoConfirmado(Atuendo atuendoConfirmado) {
		this.atuendoConfirmado = atuendoConfirmado;
	}
	
}
