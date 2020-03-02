package dominio;

/**
 * @author Daniel Loro Durán
 */
public class Turista {

	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	private String correo;
	private String foto;
	private int edad;
	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param telefono
	 * @param correo
	 * @param foto
	 * @param edad
	 */
	public Turista(String nombre, String apellidos, String dni, String telefono, String correo, String foto, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.foto = foto;
		this.edad = edad;
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
	 * @Name getApellidos
	 * @Description Metodo getter de la variable 'apellidos'
	 */
	
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @Name setApellidos
	 * @Description Metodo setter de la variable 'apellidos'
	 */
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @Name getDni
	 * @Description Metodo getter de la variable 'dni'
	 */
	
	public String getDni() {
		return dni;
	}

	/**
	 * @Name setDni
	 * @Description Metodo setter de la variable 'dni'
	 */
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @Name getTelefono
	 * @Description Metodo getter de la variable 'telefono'
	 */
	
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @Name setTelefono
	 * @Description Metodo setter de la variable 'telefono'
	 */
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @Name getCorreo
	 * @Description Metodo getter de la variable 'correo'
	 */
	
	public String getCorreo() {
		return correo;
	}

	/**
	 * @Name setCorreo
	 * @Description Metodo setter de la variable 'correo'
	 */
	
	public void setCorreo(String correo) {
		this.correo = correo;
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
	 * @Name getEdad
	 * @Description Metodo getter de la variable 'edad'
	 */
	
	public int getEdad() {
		return edad;
	}

	/**
	 * @Name setEdad
	 * @Description Metodo setter de la variable 'edad'
	 */
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @Name toString
	 */
	
	public String toString() {
		return nombre;
	}
	
}
