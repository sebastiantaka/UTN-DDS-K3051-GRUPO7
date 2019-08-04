package dominio;

public class Ciudad {
	private Provincia provincia;
	private String nombre;
	private Integer codigoDeCiudadOpenWeather;

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
}
