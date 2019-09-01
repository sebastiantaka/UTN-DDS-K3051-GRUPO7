package dominio;

import java.util.Date;
import java.util.Set;

import negocio.EventoTimerTask;
import negocio.ProgramadorDeTareas;

public class AvisoProgramado extends OrganizadorDeAviso {

	private Date fechaDeAviso;
	private Set<Integer> diasDeRepeticion;

	@Override
	public void configurarNotificacion(Evento evento) {

		ProgramadorDeTareas.getTimer().schedule(new EventoTimerTask(evento), this.getFechaDeAviso());

	}

	public Date getFechaDeAviso() {
		return fechaDeAviso;
	}

	public void setFechaDeAviso(Date fechaDeAviso) {
		this.fechaDeAviso = fechaDeAviso;
	}

	public Set<Integer> getDiasDeRepeticion() {
		return diasDeRepeticion;
	}

	public void setDiasDeRepeticion(Set<Integer> diasDeRepeticion) {
		this.diasDeRepeticion = diasDeRepeticion;
	}

}
