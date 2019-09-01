package dominio;

public class Formal implements TipoDeEvento {

	@Override
	public Boolean esPrendaValida(Prenda prenda) {
		return prenda.getEsFormal();
	}

}
