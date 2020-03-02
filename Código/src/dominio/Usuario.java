package dominio;

/**
 * @author Daniel Loro Durán
 */
public class Usuario {

	private String nombreUsuario;
	private String foto;
	private String ultimaConexion;
	
	/**
	 * @param nombreUsuario
	 * @param foto
	 * @param ultimaConexion
	 */
	
	public Usuario(String nombreUsuario, String foto) {
		this.nombreUsuario = nombreUsuario;
		this.foto = foto;
	}

	/**
	 * @Name getNombreUsuario
	 * @Description Metodo getter de la variable 'nombreUsuario'
	 */
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @Name setNombreUsuario
	 * @Description Metodo setter de la variable 'nombreUsuario'
	 */
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @Name getFoto
	 * @Description Metodo getter de la variable 'foto'
	 */
	
	public String getFoto() {
		return foto;
	}

	/**
	 * @Name setFoto
	 * @Description Metodo setter de la variable 'foto'
	 */
	
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @Name getUltimaConexion
	 * @Description Metodo getter de la variable 'ultimaConexion'
	 */
	
	public String getUltimaConexion() {
		return ultimaConexion;
	}

	/**
	 * @Name setUltimaConexion
	 * @Description Metodo setter de la variable 'ultimaConexion'
	 */
	
	public void setUltimaConexion(String ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
	}


	
}
