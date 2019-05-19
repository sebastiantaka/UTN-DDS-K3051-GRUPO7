package dominio;

import java.util.Objects;

import exceptions.TipoDeTelaInvalidoException;

public class Prenda {
	
	private TipoDePrenda tipoDePrenda;
	private TipoDeTela tipoDeTela;
	private Color colorPrimario;
	private Color colorSecundario;

	public Prenda(TipoDePrenda unTipoDePrenda, TipoDeTela unTipoDeTela, Color unColor) {
		this.tipoDePrenda = Objects.requireNonNull(unTipoDePrenda, "Una prenda no puede no tener tipo");
		this.tipoDeTela = this.verificarTela(unTipoDeTela);
		this.colorPrimario = Objects.requireNonNull(unColor, "Una prenda no puede no tener color");
	}
	
	private TipoDeTela verificarTela(TipoDeTela unTipoDeTela) {
		if (!this.getTipoDePrenda().esTelaValida(unTipoDeTela)) {
			throw new TipoDeTelaInvalidoException();
		}
		return Objects.requireNonNull(unTipoDeTela, "Una prenda no puede no tener tipo de tela");
	}
	
	/*Categoria*/
	
	public Categoria categoria() {
		return tipoDePrenda.getCategoria();
	}
	
	/*TipoDePrenda*/
	
	public TipoDePrenda getTipoDePrenda() {
		return tipoDePrenda;
	}
	
	/*Color Primario*/
	
	public Color getColorPrimario() {
		return colorPrimario;
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

	
	
	
	

}


