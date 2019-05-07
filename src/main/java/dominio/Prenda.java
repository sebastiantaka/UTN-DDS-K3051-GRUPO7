package dominio;

public class Prenda {
	
	private TipoDePrenda tipoDePrenda;
	private Material material;
	private Color color;

	public Prenda(TipoDePrenda unTipoDePrenda, Material unMaterial, Color unColor) {
		this.tipoDePrenda = unTipoDePrenda;
		this.material = unMaterial;
		this.color = unColor;
	}
	
	public Categoria categoria() {
		return tipoDePrenda.getCategoria();
	}
	
	
	
	

}


