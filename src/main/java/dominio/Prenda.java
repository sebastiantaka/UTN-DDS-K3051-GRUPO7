package dominio;

import java.awt.Image;

public class Prenda implements Cloneable {

	private String nombre;
	private TipoDePrenda tipoDePrenda;
	private TipoDeTela tipoDeTela;
	private Color colorPrimario;
	private Color colorSecundario;
	private Image imagen;
	private Boolean estaOcupada = false;
	private Boolean esFormal;

	public Prenda() {
	};

	public Prenda(String unNombre, TipoDePrenda unTipoDePrenda, TipoDeTela unTipoDeTela, Color colorPrimario,
			Color colorSecundario) {
		this.setTipoDePrenda(unTipoDePrenda);
		this.setTipoDeTela(unTipoDeTela);
		this.setColorPrimario(colorPrimario);
		this.setColorSecundario(colorSecundario);
		this.setNombre(unNombre);
	}

	@Override
	public Prenda clone() throws CloneNotSupportedException {
		return new Prenda(this.getNombre(), this.getTipoDePrenda(), this.getTipoDeTela(), this.getColorPrimario(),
				this.getColorSecundario());
	}

	/* Categoria */

	public Categoria getCategoria() {
		return getTipoDePrenda().getCategoria();
	}

	/* TipoDePrenda */

	public TipoDePrenda getTipoDePrenda() {
		return tipoDePrenda;
	}

	public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
		this.tipoDePrenda = tipoDePrenda;
	}

	/* Color Primario */

	public Color getColorPrimario() {
		return colorPrimario;
	}

	public void setColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	/* Color Secundario */

	public Color getColorSecundario() {
		return colorSecundario;
	}

	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

	/* Tela */

	public TipoDeTela getTipoDeTela() {
		return tipoDeTela;
	}

	public void setTipoDeTela(TipoDeTela tipoDeTela) {
		this.tipoDeTela = tipoDeTela;
	}

	/* Nombre */

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
		return "Prenda [nombre="
				+ nombre /*
							 * + ", tipoDePrenda=" + tipoDePrenda + ", tipoDeTela=" + tipoDeTela +
							 * ", colorPrimario=" + colorPrimario + ", colorSecundario=" + colorSecundario
							 */ + "]";
	}

	public Boolean getEstaOcupada() {
		return estaOcupada;
	}

	public void setEstaOcupada(Boolean estaOcupada) {
		this.estaOcupada = estaOcupada;
	}

	public Boolean getEsFormal() {
		return esFormal;
	}

	public void setEsFormal(Boolean esFormal) {
		this.esFormal = esFormal;
	}

}
