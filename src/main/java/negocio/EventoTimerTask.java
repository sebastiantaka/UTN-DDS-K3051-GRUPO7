package negocio;

import java.util.TimerTask;
import dominio.Evento;
import dominio.Notificacion;

public class EventoTimerTask extends TimerTask {
	private Evento evento;

	public EventoTimerTask(Evento evento2) {
		this.setEvento(evento2);
	}

	@Override
	public void run() {
		System.out.println("Evento Programado");
		this.getEvento().getUsuarios().forEach(usuario ->{
			Notificacion notificacion = new Notificacion();
			notificacion.setTitulo("¡Programá tu atuendo para este evento!");
			notificacion.setDetalle("Deberias entrar a la aplicacion y elegir alguno de los atuendos recomendados para " + this.getEvento().getDescripcion());
			notificacion.setFechaYHora(this.getEvento().getOrganizador().getFechaDeAviso());
			NotificadorHLP notificadorHLP = new NotificadorHLP();
			notificadorHLP.notificarPorEmail(usuario, notificacion);
			
		});
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
