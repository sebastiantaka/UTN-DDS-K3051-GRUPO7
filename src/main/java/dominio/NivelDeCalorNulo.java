package dominio;

public class NivelDeCalorNulo implements NivelDeCalorStrategy{

	public NivelDeCalorNulo() {}
	
	@Override
	public Integer nivelDeCalor(Prenda prenda) {
		return 0;
	}
	
}
