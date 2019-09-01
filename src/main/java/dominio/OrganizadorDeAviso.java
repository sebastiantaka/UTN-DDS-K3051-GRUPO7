package dominio;

import java.util.Date;

public abstract class OrganizadorDeAviso {

	private Date fechaDeAviso;

	public Date getFechaDeAviso() {
		return fechaDeAviso;
	}

	public void setFechaDeAviso(Date fechaDeAviso) {
		this.fechaDeAviso = fechaDeAviso;
	}

	public abstract void configurarNotificacion(Evento evento);
}
