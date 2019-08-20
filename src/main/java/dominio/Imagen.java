package dominio;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public class Imagen extends BufferedImage {
	
	private String nombreDeArchivo;
	
	public Imagen(int width, int height, int imageType, IndexColorModel cm, String nombreDeArchivo) {
		super(width, height, imageType, cm);
		this.setNombreDeArchivo(nombreDeArchivo);
	}

	public Imagen(int width, int height, int imageType, String nombreDeArchivo) {
		super(width, height, imageType);
		this.setNombreDeArchivo(nombreDeArchivo);
	}

	public Imagen(ColorModel arg0, WritableRaster arg1, boolean arg2, Hashtable<?, ?> arg3, String nombreDeArchivo) {
		super(arg0, arg1, arg2, arg3);
		this.setNombreDeArchivo(nombreDeArchivo);
	}

	public String getNombreDeArchivo() {
		return nombreDeArchivo;
	}

	public void setNombreDeArchivo(String nombreDeArchivo) {
		this.nombreDeArchivo = nombreDeArchivo;
	}
	

}
