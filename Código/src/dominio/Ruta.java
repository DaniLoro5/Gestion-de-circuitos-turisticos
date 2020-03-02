package dominio;

import java.util.ArrayList;

/**
 * @author Daniel Loro Durán
 */
public class Ruta {

	private String idRuta;
	private String estado;
	private String coste;
	private int personas;
	private String opiniones;
	private String incidencias;
	private String sugerencias;
	
	private String localidad;
	private ArrayList<PuntoInteres> puntoInteres;
	private ArrayList<GrupoTuristas> grupoTuristas;
	
	private int turistasTotal=0;

	/**
	 * @param idRuta
	 * @param estado
	 * @param coste
	 * @param opiniones
	 * @param incidencias
	 * @param sugerencias
	 * @param localidad
	 * @param puntoInteres
	 * @param grupoTuristas
	 */
	
	public Ruta(String idRuta, String estado, String coste, String opiniones, String incidencias, String sugerencias,
			String localidad) {
		this.idRuta = idRuta;
		this.estado = estado;
		this.coste = coste;
		this.opiniones = opiniones;
		this.incidencias = incidencias;
		this.sugerencias = sugerencias;
		this.localidad = localidad;
		this.puntoInteres = new ArrayList<PuntoInteres>();
		this.grupoTuristas = new ArrayList<GrupoTuristas>();
	}

	
	/**
	 * @Name getIdRuta
	 * @Description Metodo getter de la variable 'idRuta'
	 */
	
	public String getIdRuta() {
		return idRuta;
	}

	/**
	 * @Name setIdRuta
	 * @Description Metodo setter de la variable 'idRuta'
	 */
	
	public void setIdRuta(String idRuta) {
		this.idRuta = idRuta;
	}

	/**
	 * @Name getEstado
	 * @Description Metodo getter de la variable 'estado'
	 */
	
	public String getEstado() {
		return estado;
	}

	/**
	 * @Name setEstado
	 * @Description Metodo setter de la variable 'estado'
	 */
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @Name getCoste
	 * @Description Metodo getter de la variable 'coste'
	 */
	
	public String getCoste() {
		return coste;
	}

	/**
	 * @Name setCoste
	 * @Description Metodo setter de la variable 'coste'
	 */
	
	public void setCoste(String coste) {
		this.coste = coste;
	}

	/**
	 * @Name getPersonas
	 * @Description Metodo getter de la variable 'personas'
	 */
	
	public int getPersonas() {
		return personas;
	}

	/**
	 * @Name setPersonas
	 * @Description Metodo setter de la variable 'personas'
	 */
	
	public void setPersonas(int personas) {
		this.personas = personas;
	}

	/**
	 * @Name getOpiniones
	 * @Description Metodo getter de la variable 'opiniones'
	 */
	
	public String getOpiniones() {
		return opiniones;
	}

	/**
	 * @Name setOpiniones
	 * @Description Metodo setter de la variable 'opiniones'
	 */
	
	public void setOpiniones(String opiniones) {
		this.opiniones = opiniones;
	}

	/**
	 * @Name getIncidencias
	 * @Description Metodo getter de la variable 'incidencias'
	 */
	
	public String getIncidencias() {
		return incidencias;
	}

	/**
	 * @Name setIncidencias
	 * @Description Metodo setter de la variable 'incidencias'
	 */
	
	public void setIncidencias(String incidencias) {
		this.incidencias = incidencias;
	}

	/**
	 * @Name getSugerencias
	 * @Description Metodo getter de la variable 'sugerencias'
	 */
	
	public String getSugerencias() {
		return sugerencias;
	}

	/**
	 * @Name setSugerencias
	 * @Description Metodo setter de la variable 'sugerencias'
	 */
	
	public void setSugerencias(String sugerencias) {
		this.sugerencias = sugerencias;
	}

	/**
	 * @Name getLocalidad
	 * @Description Metodo getter de la variable 'localidad'
	 */
	
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @Name setLocalidad
	 * @Description Metodo setter de la variable 'localidad'
	 */
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @Name getPuntoInteres
	 * @Description Metodo getter de la variable 'puntoInteres'
	 */
	
	public ArrayList<PuntoInteres> getPuntoInteres() {
		return puntoInteres;
	}

	/**
	 * @Name setPuntoInteres
	 * @Description Metodo setter de la variable 'puntoInteres'
	 */
	
	public void setPuntoInteres(ArrayList<PuntoInteres> puntoInteres) {
		this.puntoInteres = puntoInteres;
	}

	/**
	 * @Name getGrupoTuristas
	 * @Description Metodo getter de la variable 'grupoTuristas'
	 */
	
	public ArrayList<GrupoTuristas> getGrupoTuristas() {
		return grupoTuristas;
	}

	/**
	 * @Name setGrupoTuristas
	 * @Description Metodo setter de la variable 'grupoTuristas'
	 */
	
	public void setGrupoTuristas(ArrayList<GrupoTuristas> grupoTuristas) {
		this.grupoTuristas = grupoTuristas;
	}

	/**
	 * @Name getTuristasTotal
	 * @Description Metodo getter de la variable 'turistasTotal'
	 */
	
	public int getTuristasTotal() {
		return turistasTotal;
	}

	
	/**
	 * @Name setTuristasTotal
	 * @Description Metodo setter de la variable 'turistasTotal'
	 */
	
	public void setTuristasTotal() {
		this.turistasTotal = 0;
		for(int i = 0; i < this.grupoTuristas.size();i++) {
			this.turistasTotal += this.grupoTuristas.get(i).getTuristas().size();
		}
	}

	/**
	 * @Name toString
	 */
	
	public String toString() {
		return idRuta;
	}
}
