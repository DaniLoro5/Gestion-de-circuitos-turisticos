package presentacion;

import java.awt.Image;
import java.io.Serializable;

/**
 * @author Daniel Loro Durán
 */
public class ImagenGrafico extends ObjetoGrafico implements Serializable{

	private Image imagen;

	public ImagenGrafico(int x, int y, Image imagen) {
		super(x, y);
		this.imagen = imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public Image getImagen() {
		return imagen;
	}
	
}
