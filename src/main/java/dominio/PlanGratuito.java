package dominio;

public class PlanGratuito implements IPlan{

	public PlanGratuito() {	}
	
	public Integer getMaximosGuardarropas() {
		return 10;
	}
	
	public Integer getMaximasPrendasPorGuardarropa() {
		return 10;
	}
	
}
