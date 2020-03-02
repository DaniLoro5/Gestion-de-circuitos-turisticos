package dominio;

/**
 * @author Daniel Loro Durán
 */
public class Promocion {

	private String nombrepromo;
	private String mensaje;
	private String nombreArchivo;
	private String tamanoArchivo;
	
	/**
	 * @param nombrepromo
	 * @param mensaje
	 */
	
	public Promocion(String nombrepromo, String mensaje) {
		this.nombrepromo = nombrepromo;
		this.mensaje = mensaje;
	}
	
	/**
	 * @Name getNombrepromo
	 * @Description Metodo getter de la variable 'nombrepromo'
	 */
	
	public String getNombrepromo() {
		return nombrepromo;
	}

	/**
	 * @Name setNombrepromo
	 * @Description Metodo setter de la variable 'nombrepromo'
	 */
	
	public void setNombrepromo(String nombrepromo) {
		this.nombrepromo = nombrepromo;
	}

	/**
	 * @Name getMensaje
	 * @Description Metodo getter de la variable 'mensaje'
	 */
	
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @Name setMensaje
	 * @Description Metodo setter de la variable 'mensaje'
	 */
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @Name getNombreArchivo
	 * @Description Metodo getter de la variable 'nombreArchivo'
	 */
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @Name setNombreArchivo
	 * @Description Metodo setter de la variable 'nombreArchivo'
	 */
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @Name getTamanoArchivo
	 * @Description Metodo getter de la variable 'tamanoArchivo'
	 */
	
	public String getTamanoArchivo() {
		return tamanoArchivo;
	}

	/**
	 * @Name setTamanoArchivo
	 * @Description Metodo setter de la variable 'tamanoArchivo'
	 */
	
	public void setTamanoArchivo(String tamanoArchivo) {
		this.tamanoArchivo = tamanoArchivo;
	}

	/**
	 * @Name toStirng
	 */
	
	public String toString() {
		return nombrepromo;
	}
	
}
