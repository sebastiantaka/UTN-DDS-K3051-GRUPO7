package dominio;

import negocio.EventoTimerTask;
import negocio.ProgramadorDeTareas;

public class AvisoSimple extends OrganizadorDeAviso {

	@Override
	public void configurarNotificacion(Evento evento) {

		ProgramadorDeTareas.getTimer().schedule(new EventoTimerTask(evento), this.getFechaDeAviso());

	}
}
