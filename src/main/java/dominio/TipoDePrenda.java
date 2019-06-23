package dominio;

import java.util.Collection;

public class TipoDePrenda {
	
	private String nombre;
	private Categoria categoria;
	private Collection<TipoDeTela> tiposDeTelasPermitidas;
	
	public TipoDePrenda(String nombre, Categoria categoria, Collection<TipoDeTela> tiposDeTelaPermitidos) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.setTiposDeTelasPermitidas(tiposDeTelaPermitidos);
	}

	/* Categoria */
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	
	/* Tipo De Telas Permitidas */
	
	public Collection<TipoDeTela> getTiposDeTelasPermitidas() {
		return tiposDeTelasPermitidas;
	}

	public void setTiposDeTelasPermitidas(Collection<TipoDeTela> tiposDeTelaPermitidos) {
		this.tiposDeTelasPermitidas = tiposDeTelaPermitidos;
	}
	
	
	/* Nombre */
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
