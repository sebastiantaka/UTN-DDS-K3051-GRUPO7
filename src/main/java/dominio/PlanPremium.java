package dominio;

public class PlanPremium implements IPlan{

	public PlanPremium() {	}
	
	public Integer getMaximosGuardarropas() {
		return Integer.MAX_VALUE;
	}
	
	public Integer getMaximasPrendasPorGuardarropa() {
		return Integer.MAX_VALUE;
	}
}
