package dominio;

import java.awt.Image;

public class Prenda {
	
	private String nombre;
	private TipoDePrenda tipoDePrenda;
	private TipoDeTela tipoDeTela;
	private Color colorPrimario;
	private Color colorSecundario;
	private Image imagen;
	
	public Prenda(String unNombre, TipoDePrenda unTipoDePrenda, TipoDeTela unTipoDeTela, Color colorPrimario, Color colorSecundario) {
		this.setTipoDePrenda(unTipoDePrenda);
		this.setTipoDeTela(unTipoDeTela);
		this.setColorPrimario(colorPrimario);
		this.setColorSecundario(colorSecundario);
		this.setNombre(unNombre);
	}
	
	
	/*Categoria*/
	
	public Categoria getCategoria() {
		return getTipoDePrenda().getCategoria();
	}
	
	/*TipoDePrenda*/
	
	public TipoDePrenda getTipoDePrenda() {
		return tipoDePrenda;
	}
	
	public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
		this.tipoDePrenda = tipoDePrenda;
	}

	
	/*Color Primario*/
	
	public Color getColorPrimario() {
		return colorPrimario;
	}	
	
	public void setColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
	}
	
	/*Color Secundario*/
	
	public Color getColorSecundario() {
		return colorSecundario;
	}
	
	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

	/*Tela*/
	
	public TipoDeTela getTipoDeTela() {
		return tipoDeTela;
	}

	public void setTipoDeTela(TipoDeTela tipoDeTela) {
		this.tipoDeTela = tipoDeTela;
	}

	/*Nombre*/

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* NivelDeCalor */
	
	public Integer getNivelDeCalor() {
		return this.getTipoDePrenda().getCalculoDeCalor().nivelDeCalor(this);
	}

	/* IMAGEN */
	
	public Image getImagen() {
		return imagen;
	}


	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public String toString() {
		return "Prenda [nombre=" + nombre /*+ ", tipoDePrenda=" + tipoDePrenda + ", tipoDeTela=" + tipoDeTela
				+ ", colorPrimario=" + colorPrimario + ", colorSecundario=" + colorSecundario*/ + "]";
	}

}


