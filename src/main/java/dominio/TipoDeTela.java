package dominio;

public class TipoDeTela {

	private String tela;
	private Integer nivelDeCalor;
	
	public TipoDeTela(String tela, Integer nivelDeCalor){
		this.setTela(tela);
		this.setNivelDeCalor(nivelDeCalor);
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public Integer getNivelDeCalor() {
		return nivelDeCalor;
	}

	public void setNivelDeCalor(Integer nivelDeCalor) {
		this.nivelDeCalor = nivelDeCalor;
	}
	
	
	
	
}
