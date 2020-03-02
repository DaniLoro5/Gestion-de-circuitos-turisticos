package dominio;

/**
 * @author Daniel Loro Durán
 */
public class PuntoInteres {

	private String nombre;
	private String tipo;
	private String foto;
	private String entrada;
	private String descripcion;
	private String horario;
	private String duracionVisita;
	
	/**
	 * @param nombre
	 * @param tipo
	 * @param foto
	 * @param entrada
	 * @param descripcion
	 * @param horario
	 * @parama duracionVisita
	 */
	public PuntoInteres(String nombre, String tipo, String foto, String entrada, String descripcion, String horario, String duracionVisita) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.foto = foto;
		this.entrada = entrada;
		this.descripcion = descripcion;
		this.horario = horario;
		this.duracionVisita = duracionVisita;
	}
	
	/**
	 * @Name getNombre
	 * @Description Metodo getter de la variable 'nombre'
	 */
	
	public String getNombre() {
		return nombre;
	}

	/**
	 * @Name setNombre
	 * @Description Metodo setter de la variable 'nombre'
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @Name getTipo
	 * @Description Metodo getter de la variable 'tipo'
	 */
	
	public String getTipo() {
		return tipo;
	}

	/**
	 * @Name setTipo
	 * @Description Metodo setter de la variable 'tipo'
	 */
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	 * @Name getEntrada
	 * @Description Metodo getter de la variable 'entrada'
	 */
	
	public String getEntrada() {
		return entrada;
	}

	/**
	 * @Name setEntrada
	 * @Description Metodo setter de la variable 'entrada'
	 */
	
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	/**
	 * @Name getDescripcion
	 * @Description Metodo getter de la variable 'descripcion'
	 */
	
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @Name setDescripcion
	 * @Description Metodo setter de la variable 'descripcion'
	 */
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @Name getHorario
	 * @Description Metodo getter de la variable 'horario'
	 */
	
	public String getHorario() {
		return horario;
	}

	/**
	 * @Name setHorario
	 * @Description Metodo setter de la variable 'horario'
	 */
	
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @Name getDuracionVisita
	 * @Description Metodo getter de la variable 'duracionVisita'
	 */
	
	public String getDuracionVisita() {
		return duracionVisita;
	}
	
	/**
	 * @Name setDuracionVisita
	 * @Description Metodo setter de la variable 'duracionVisita'
	 */
	
	public void setDuracionVisita(String duracionVisita) {
		this.duracionVisita = duracionVisita;
	}

	/**
	 * @Name toString
	 */
	
	public String toString() {
		return nombre;
	}

	
}
