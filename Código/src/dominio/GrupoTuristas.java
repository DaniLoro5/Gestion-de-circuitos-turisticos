package dominio;

import java.util.ArrayList;

/**
 * @author Daniel Loro Durán
 */
public class GrupoTuristas {

	private String nombreGrupo;
	private int numIntegrantes;
	private ArrayList<Turista> turistas;
	private String tipo;
	private String descripcion;
	private String intereses;
	private String restricciones;
	
	/**
	 * @param nombreGrupo
	 * @param turistas
	 * @param tipo
	 * @param descripcion
	 * @param intereses
	 * @param restricciones
	 */
	
	public GrupoTuristas(String nombreGrupo, String tipo, String descripcion, String intereses, String restricciones) {
		this.nombreGrupo = nombreGrupo;
		this.turistas = turistas;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.intereses = intereses;
		this.restricciones = restricciones;
		turistas = new ArrayList<Turista>();
		this.numIntegrantes = this.turistas.size();
	}

	
	/**
	 * @Name getNombreGrupo
	 * @Description Metodo getter de la variable 'nombreGrupo'
	 */
	
	public String getNombreGrupo() {
		return nombreGrupo;
	}


	/**
	 * @Name setNombreGrupo
	 * @Description Metodo setter de la variable 'nombreGrupo'
	 */
	
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * @Name getTuristas
	 * @Description Metodo getter de la variable 'turistas'
	 */
	
	public ArrayList<Turista> getTuristas() {
		return turistas;
	}

	/**
	 * @Name setTuristas
	 * @Description Metodo setter de la variable 'turistas'
	 */
	
	public void setTuristas(ArrayList<Turista> turistas) {
		this.turistas = turistas;
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
	 * @Name getIntereses
	 * @Description Metodo getter de la variable 'intereses'
	 */
	
	public String getIntereses() {
		return intereses;
	}

	/**
	 * @Name setIntereses
	 * @Description Metodo setter de la variable 'intereses'
	 */
	
	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}

	/**
	 * @Name getRestricciones
	 * @Description Metodo getter de la variable 'restricciones'
	 */
	
	public String getRestricciones() {
		return restricciones;
	}

	/**
	 * @Name setRestricciones
	 * @Description Metodo setter de la variable 'restricciones'
	 */
	
	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	/**
	 * @Name getNumIntegrantes
	 * @Description Metodo getter de la variable 'numIntegrantes'
	 */
	
	public int getNumIntegrantes() {
		return numIntegrantes;
	}

	/**
	 * @Name setNumIntegrantes
	 * @Description 
	 */
	
	public void setNumIntegrantes() {
		this.numIntegrantes = this.turistas.size();
	}

	
	/**
	 * @Name toString
	 */
	
	public String toString() {
		return nombreGrupo;
	}
	
}
