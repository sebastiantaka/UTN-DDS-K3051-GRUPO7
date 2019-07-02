package dominio;

import java.util.Date;

public class Evento {
	
	private Date fecha;
	private Ciudad ciudad;
	private String descripcion;

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

}
