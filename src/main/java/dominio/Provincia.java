package dominio;

public class Provincia {
	private Pais pais;
	private String nombre;
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Provincia de " + this.getNombre() + ", " + this.getPais().toString();
	}
}
