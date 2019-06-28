package negocio;

import java.util.Objects;
import dominio.Color;
import dominio.Prenda;
import dominio.TipoDePrenda;
import dominio.TipoDeTela;
import exceptions.TipoDeTelaInvalidoException;

public class PrendaHLP {

	public PrendaHLP() { }
	
	public Prenda crearPrendaDeUnColor(TipoDePrenda unTipoDePrenda, TipoDeTela unTipoDeTela, Color unColor) {
		return new Prenda(unTipoDePrenda, unTipoDeTela, unColor, null);//TODO actualizar 
	}
	
	public Prenda crearPrenda(TipoDePrenda unTipoDePrenda, TipoDeTela unTipoDeTela, Color colorPrimario, Color colorSecundario) {
		//Validaciones//
		Objects.requireNonNull(unTipoDePrenda);
		this.verificarTelaValida(unTipoDePrenda, unTipoDeTela);
		Objects.requireNonNull(colorPrimario);
		//FIN VALIDACIONES//
		return new Prenda(unTipoDePrenda, unTipoDeTela, colorPrimario, colorSecundario);
	}	
	
	private TipoDeTela verificarTelaValida(TipoDePrenda unTipoDePrenda, TipoDeTela unTipoDeTela) {
		TipoDePrendaHLP tipoDePrendaHLP = new TipoDePrendaHLP();
		if (!tipoDePrendaHLP.esTelaValida(unTipoDePrenda, unTipoDeTela)) {
			throw new TipoDeTelaInvalidoException();
		}
		return Objects.requireNonNull(unTipoDeTela, "Una prenda no puede no tener tipo de tela");
	}
	
	public void agregarTelaPermitida(TipoDePrenda tipoDePrenda, TipoDeTela tela) {
		tipoDePrenda.getTiposDeTelasPermitidas().add(tela);
	}
	
	public boolean esTelaValida(TipoDePrenda tipoDePrenda, TipoDeTela tela) {
		return tipoDePrenda.getTiposDeTelasPermitidas().contains(tela);
	}
	
}
