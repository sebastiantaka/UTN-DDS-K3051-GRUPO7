package negocio;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dominio.Imagen;

public class ImagenHLP {

	private final Integer PESOMAXIMO = 100;
	private final Integer MAXIMAALTURA = 1080;
	private final Integer MAXIMOANCHO = 1920;
	
	public ImagenHLP() {}
	
	public Imagen cargarImagen() throws IOException {
		File file = new File("strawberry.jpg");
		Imagen image = null;
		if (file.isFile() && file.canRead()) {
			if (file.getTotalSpace() < this.PESOMAXIMO) {
				 image = (Imagen) ImageIO.read(file);
				 if (image.getHeight() > this.MAXIMAALTURA) {
					 image = (Imagen) image.getScaledInstance(-1, MAXIMAALTURA, Image.SCALE_DEFAULT);
					 if(image.getWidth() > this.MAXIMOANCHO) {
						 image = (Imagen) image.getScaledInstance(MAXIMOANCHO, -1, Image.SCALE_DEFAULT);
					 }
				 }
			}
		}
		
		return image;
	}
	
}
