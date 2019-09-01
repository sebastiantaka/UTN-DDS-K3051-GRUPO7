package dominio;

import java.time.ZoneId;

public class Ciudad {
	private Provincia provincia;
	private String nombre;
	private Integer codigoDeCiudadOpenWeather;
	private String zonaHoraria;

	public Ciudad(Provincia provincia, String nombre, Integer codigoOW) {
		this.setProvincia(provincia);
		this.setNombre(nombre);
		this.setCodigoDeCiudadOpenWeather(codigoOW);
	}

	public Ciudad() {	}

	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.getNombre() + ", " + this.provincia.toString();
	}


	public Integer getCodigoDeCiudadOpenWeather() {
		return codigoDeCiudadOpenWeather;
	}

	public void setCodigoDeCiudadOpenWeather(Integer codigoDeCiudadOpenWeather) {
		this.codigoDeCiudadOpenWeather = codigoDeCiudadOpenWeather;
	}


	public String getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(String string) {
		this.zonaHoraria = string;
	}
}
