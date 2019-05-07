package dominio;

public class TipoDePrenda {
	
	private String tipoPrenda;
	private Categoria categoria;
	
	public TipoDePrenda(String tipoPrenda, Categoria categoria) {
		this.tipoPrenda = tipoPrenda;
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}
	
	
	
	
	

}
