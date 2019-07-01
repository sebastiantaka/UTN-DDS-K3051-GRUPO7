package dominio;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public class Imagen extends BufferedImage {

	public Imagen(int width, int height, int imageType, IndexColorModel cm) {
		super(width, height, imageType, cm);
	}

	public Imagen(int width, int height, int imageType) {
		super(width, height, imageType);
	}

	public Imagen(ColorModel arg0, WritableRaster arg1, boolean arg2, Hashtable<?, ?> arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	

}
