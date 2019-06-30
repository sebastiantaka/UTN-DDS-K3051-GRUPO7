package dominio;

public class NivelDeCalorAbrigado implements NivelDeCalorStrategy {
	
	public NivelDeCalorAbrigado() {}

	@Override
	public Integer nivelDeCalor(Prenda prenda) {
		return prenda.getTipoDeTela().ordinal() * 5;
	}

}
