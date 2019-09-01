package negocio;

import java.util.Calendar;
import java.util.Date;

import dominio.AvisoProgramado;
import dominio.Evento;

public class EventoProgramadoTimerTask extends EventoTimerTask {

	public EventoProgramadoTimerTask(Evento evento2) {
		super(evento2);
	}
	
	@Override
	public void run() {
		System.out.println("Esto es un evento Programado");
		if (this.getEvento().getOrganizador() instanceof AvisoProgramado) {
			AvisoProgramado aviso = (AvisoProgramado) this.getEvento().getOrganizador();
			Date now = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(now);			
			if (aviso.getDiasDeRepeticion().contains(calendar.get(Calendar.DAY_OF_WEEK))) {
				super.run();
			}
			aviso.getDiasDeRepeticion();
		} else {
			System.out.println("Tarea mal programada");
		}
	}

}
