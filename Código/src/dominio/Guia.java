package dominio;

import java.util.ArrayList;

/**
 * @author Daniel Loro Durán
 */
public class Guia {

	private String nombre;
	private String apellidos;
	private String foto;
	private String puntuacion;
	private String idiomas;
	private String telefono;
	private String disponibilidad;
	private String precioHora;
	private String precioDia;
	private String dni;
	private ArrayList<Ruta> rutas;
	/**
	 * @param nombre
	 * @param apellidos
	 * @param foto
	 * @param puntuacion
	 * @param idiomas
	 * @param telefono
	 * @param disponibilidad
	 * @param precioHora
	 * @param precioDia
	 * @param dni
	 * @param rutas
	 */
	public Guia(String nombre, String apellidos, String foto, String puntuacion, String idiomas, String telefono, String precioHora, String precioDia, String dni, String disponibilidad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.foto = foto;
		this.puntuacion = puntuacion;
		this.idiomas = idiomas;
		this.telefono = telefono;
		this.disponibilidad = disponibilidad;
		this.precioHora = precioHora;
		this.precioDia = precioDia;
		this.dni = dni;
		this.rutas = new ArrayList<Ruta>();
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
	 * @Name getPuntuacion
	 * @Description Metodo getter de la variable 'puntuacion'
	 */
	
	public String getPuntuacion() {
		return puntuacion;
	}

	/**
	 * @Name setPuntuacion
	 * @Description Metodo setter de la variable 'puntuacion'
	 */
	
	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	/**
	 * @Name getIdiomas
	 * @Description Metodo getter de la variable 'idiomas'
	 */
	
	public String getIdiomas() {
		return idiomas;
	}

	/**
	 * @Name setIdiomas
	 * @Description Metodo setter de la variable 'idiomas'
	 */
	
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
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
	 * @Name getDisponibilidad
	 * @Description Metodo getter de la variable 'disponibilidad'
	 */
	
	public String getDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * @Name setDisponibilidad
	 * @Description Metodo setter de la variable 'disponibilidad'
	 */
	
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	/**
	 * @Name getRutas
	 * @Description Metodo getter de la variable 'rutas'
	 */
	
	public ArrayList<Ruta> getRutas() {
		return rutas;
	}

	/**
	 * @Name setRutas
	 * @Description Metodo setter de la variable 'rutas'
	 */
	
	public void setRutas(ArrayList<Ruta> rutas) {
		this.rutas = rutas;
	}

	/**
	 * @Name getPrecioHora
	 * @Description Metodo getter de la variable 'precioHora'
	 */
	
	public String getPrecioHora() {
		return precioHora;
	}
	
	/**
	 * @Name setPrecioHora
	 * @Description Metodo setter de la variable 'precioHora'
	 */
	
	public void setPrecioHora(String precioHora) {
		this.precioHora = precioHora;
	}
	
	/**
	 * @Name getPrecioDia
	 * @Description Metodo getter de la variable 'precioDia'
	 */
	
	public String getPrecioDia() {
		return precioDia;
	}
	
	/**
	 * @Name setPrecioDia
	 * @Description Metodo setter de la variable 'precioDia'
	 */
	
	public void setPrecioDia(String precioDia) {
		this.precioDia = precioDia;
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
	 * @Name toString
	 */
	
	public String toString() {
		return nombre;
	}
	
}
