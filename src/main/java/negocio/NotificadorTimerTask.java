package negocio;

import java.util.TimerTask;

import dominio.Notificacion;

public class NotificadorTimerTask extends TimerTask{
	
	private Notificacion notificacion;
	
	public NotificadorTimerTask(Notificacion notificacion2) {
		this.setNotificacion(notificacion2);
	}

	@Override
	public void run() {
		
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

}
