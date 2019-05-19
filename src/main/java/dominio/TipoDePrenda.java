package dominio;

import java.util.Set;

public class TipoDePrenda {
	
	private String nombre;
	private Categoria categoria;
	private Set<TipoDeTela> tiposDeTelasPermitidas;
	
	public TipoDePrenda(String nombre, Categoria categoria, Set<TipoDeTela> tiposDeTelasPermitidas) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.setTiposDeTelasPermitidas(tiposDeTelasPermitidas);
	}

	/* Categoria */
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	
	/* Tipo De Telas Permitidas */
	
	public Set<TipoDeTela> getTiposDeTelasPermitidas() {
		return tiposDeTelasPermitidas;
	}

	public void setTiposDeTelasPermitidas(Set<TipoDeTela> tiposDeTelasPermitidas) {
		this.tiposDeTelasPermitidas = tiposDeTelasPermitidas;
	}
	
	public void agregarTelaPermitida(TipoDeTela tela) {
		/* Podemos hacer esto por ser Set*/
		tiposDeTelasPermitidas.add(tela);
	}
	
	public boolean esTelaValida(TipoDeTela tela) {
		return tiposDeTelasPermitidas.contains(tela);
	}

	/* Nombre */
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
