package dominio;

public class Capa {
	
	private String descripcion;
	private Integer orden;
	private Boolean esOpcional;
	
	
	@Override
	public String toString() {
		return "Capa [descripcion=" + descripcion + ", orden=" + orden + ", esOpcional=" + esOpcional + "]";
	}

	public Capa(String descipcion, Integer orden, Boolean esOpcional) {
		this.setOrden(orden);
		this.setDescripcion(descripcion);
		this.setEsOpcional(esOpcional);
	}
	
	/* El orden en el que te lo tenes que poner */
	
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	/* La descripcion de la capa */
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/* ¿Esta capa es obligatoria para la categoría? */
	
	public Boolean getEsOpcional() {
		return esOpcional;
	}

	public void setEsOpcional(Boolean esOpcional) {
		this.esOpcional = esOpcional;
	}
}
