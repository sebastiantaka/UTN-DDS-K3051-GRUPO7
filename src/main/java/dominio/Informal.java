package dominio;

public class Informal implements TipoDeEvento {

	@Override
	public Boolean esPrendaValida(Prenda prenda) {
		return !prenda.getEsFormal();
	}

}