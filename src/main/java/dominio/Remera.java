package dominio;

public class Remera implements TipoPrenda{
	
	private String nombre;
	private String categoria;
	private String tipoTela;
	private String color;
	
	public Remera(String nombre, String categoria, String tipoTela, String color) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.tipoTela = tipoTela;
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getTipoTela() {
		return tipoTela;
	}

	public String getColor() {
		return color;
	}
	
	
	
	
}
