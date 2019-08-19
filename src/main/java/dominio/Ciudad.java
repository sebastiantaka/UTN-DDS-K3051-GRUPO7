package dominio;

import java.time.ZoneId;
import java.util.TimeZone;

public class Ciudad {
	private Provincia provincia;
	private String nombre;
	private Integer codigoDeCiudadOpenWeather;
	private ZoneId zonaHoraria;

	public Ciudad(Provincia provincia, String nombre, Integer codigoOW) {
		this.setProvincia(provincia);
		this.setNombre(nombre);
		this.setCodigoDeCiudadOpenWeather(codigoOW);
	}

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


	public ZoneId getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(ZoneId zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}
}
