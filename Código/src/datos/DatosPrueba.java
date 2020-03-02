package datos;

import java.util.ArrayList;
import dominio.*;

/**
 * @author Daniel Loro Durán
 */
public class DatosPrueba {

	public ArrayList<Usuario> usuarios;
	public ArrayList<Guia> guias;
	public ArrayList<PuntoInteres> puntoInteres;
	public ArrayList<Turista> turistasGeneral;
	public ArrayList<Turista> turistasG1;
	public ArrayList<Turista> turistasG2;
	public ArrayList<GrupoTuristas> grupoTurista;
	public ArrayList<Ruta> rutas;
	public ArrayList<Promocion> promociones;
	
	public DatosPrueba() {
		
		cargarDatos();
		
	}
	
	public void cargarDatos() {
		
		//Crear usuarios
		
		usuarios = new ArrayList<Usuario>();
		
		Usuario usuario1 = new Usuario("usuario1", "/presentacion/usuario1.jpg");
		Usuario usuario2 = new Usuario("root", "");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		// Crear guias
		
		guias = new ArrayList<Guia>();
		
		Guia guia1 = new Guia("Raúl", "Díaz", "/presentacion/cara1.jpg", "3/5 estrellas", "Español,Inglés", "611111111", "3€", "30€", "11111111-D", "Lunes; 8-14h");
		Guia guia2 = new Guia("Antonio", "Perez", "/presentacion/cara3.jpg", "1/5 estrellas", "Español", "622222222", "5€", "50€", "22222222-A", "Martes: 10-12h");
		Guia guia3 = new Guia("Lola", "Jimenez", "/presentacion/cara2.jpg", "4/5 estrellas", "Español, Inglés, Francés", "633333333", "3€", "25€", "33333333-Q", "Sábados y Domingos");
		
		guias.add(guia1);
		guias.add(guia2);
		guias.add(guia3);
		
		// Crear puntos de interés
		
		puntoInteres = new ArrayList<PuntoInteres>();

		
		PuntoInteres pi1 = new PuntoInteres("Iglesia de Santa María", "Iglesia", "/presentacion/iglesia.jpg", "Gratuita", "Descripción de la iglesia", "Todos días de 8:00h a 22:00h", "30 minutos");
		PuntoInteres pi2 = new PuntoInteres("Estatua de piedra", "Estatua", "/presentacion/estatua.jpg", "Gratuita", "Descripción de la estatua", "Cuando se quiera", "5 minutos");
		PuntoInteres pi3 = new PuntoInteres("Museo de aviación", "Museo", "/presentacion/museo.jpg", "2€/persona", "Descripción del museo", "Todos días de 8:00h a 22:00h", "2 horas");
		PuntoInteres pi4 = new PuntoInteres("Cuadro & arte", "Exposición", "/presentacion/galería.jpg", "Gratuita", "Descripción de la exposición", "Martes y Domingo, de 9:00h a 14:00h", "3 horas");
		
		puntoInteres.add(pi1);
		puntoInteres.add(pi2);
		puntoInteres.add(pi3);
		puntoInteres.add(pi4);
		
		// Crear turistas
		
		turistasG1 = new ArrayList<Turista>();
		turistasG2 = new ArrayList<Turista>();
		turistasGeneral = new ArrayList<Turista>();
		
		Turista turista1 = new Turista("Antonia", "Lopez", "44444444-I", "655555555", "antonia@correo.es", "/presentacion/cara5.jpg", 23);
		Turista turista2 = new Turista("Ana", "Rosa", "55555555-I", "666666666", "rosa@correo.es", "/presentacion/cara6.png", 50);
		Turista turista3 = new Turista("Pepe", "Lopez", "66666666-K", "677777777", "pepe@correo.es", "/presentacion/cara1.jpg", 65);
		Turista turista4 = new Turista("Roberto", "Asín", "77777777-L", "688888888", "roberto@correo.es", "/presentacion/personagenerica.png", 43);
		Turista turista5 = new Turista("Elena", "Jimenez", "88888888-N", "699999999", "elena@correo.es", "/presentacion/personagenerica.png", 20);
		Turista turista6 = new Turista("Roberta", "Gonzalez", "99999999-M", "699999991", "roberta@correo.es", "/presentacion/personagenerica.png", 72);
		Turista turista7 = new Turista("José", "Domingo", "11111112-D", "611111112", "jose@correo.es", "/presentacion/personagenerica.png", 30);
		Turista turista8 = new Turista("Lolo", "Cañiz", "12345678-H", "123456789", "lolo@correo.es", "/presentacion/personagenerica.png", 47);
		Turista turista9 = new Turista("Pepa", "Diez", "12345678-Q", "987654321", "pepa@correo.es", "/presentacion/personagenerica.png", 32);
		Turista turista10 = new Turista("Angel", "Ortega", "23232323-A", "623232323", "angel@correo.es", "/presentacion/cara1.jpg", 41);
		
		turistasGeneral.add(turista1);
		turistasGeneral.add(turista2);
		turistasGeneral.add(turista3);
		turistasGeneral.add(turista4);
		turistasGeneral.add(turista5);
		turistasGeneral.add(turista6);
		turistasGeneral.add(turista7);
		turistasGeneral.add(turista8);
		turistasGeneral.add(turista9);
		turistasGeneral.add(turista10);
		
		
		turistasG1.add(turista1);
		turistasG1.add(turista2);
		turistasG1.add(turista3);
		turistasG1.add(turista4);
		turistasG1.add(turista5);
		turistasG1.add(turista6);
		
		turistasG2.add(turista7);
		turistasG2.add(turista8);
		turistasG2.add(turista9);
		turistasG2.add(turista10);
		
		// Crear grupos de turistas
		
		grupoTurista = new ArrayList<GrupoTuristas>();
		
		GrupoTuristas gt1 = new GrupoTuristas("Grupo 1", "Tipo 1", "Descripción del grupo 1", "Intereses del grupo 1", "Restricciones del grupo 1");
		GrupoTuristas gt2 = new GrupoTuristas("Grupo 2", "Tipo 2", "Descripción del grupo 2", "Intereses del grupo 2", "Restricciones del grupo 2");
		
		gt1.setTuristas(turistasG1);
		gt2.setTuristas(turistasG2);
		gt1.setNumIntegrantes();
		gt2.setNumIntegrantes();
		grupoTurista.add(gt1);
		grupoTurista.add(gt2);
		
		
		// Crear promociones
		
		promociones = new ArrayList<Promocion>();
		
		Promocion promo1 = new Promocion("Promocion 1", "Mensaje a enviar de la promoción 1");
		Promocion promo2 = new Promocion("Promocion 2", "Mensaje a enviar de la promoción 2");
		
		promociones.add(promo1);
		promociones.add(promo2);
		
		// Crear rutas
		
		rutas = new ArrayList<Ruta>();
		
		Ruta ruta1 = new Ruta("Ruta1", "Pendiente", "50€", "Opiniones de ruta 1", "Incidencias de ruta 1", "Sugerencias de ruta 1", "Ciudad Real");
		Ruta ruta2 = new Ruta("Ruta2", "Realizada", "100€", "Opiniones de ruta 2", "Incidencias de ruta 2", "Sugerencias de ruta 2", "Malagón");
		Ruta ruta3 = new Ruta("Ruta3", "Pendiente", "50€", "Opiniones de ruta 3", "Incidencias de ruta 3", "Sugerencias de ruta 3", "Miguelturra");
		Ruta ruta4 = new Ruta("Ruta4", "Realizada", "100€", "Opiniones de ruta 4", "Incidencias de ruta 4", "Sugerencias de ruta 4", "Puertollano");
		Ruta ruta5 = new Ruta("Ruta5", "Pendiente", "50€", "Opiniones de ruta 5", "Incidencias de ruta 5", "Sugerencias de ruta 5", "Fuente el Fresno");
		Ruta ruta6 = new Ruta("Ruta6", "Realizada", "100€", "Opiniones de ruta 6", "Incidencias de ruta 6", "Sugerencias de ruta 6", "Los Cortijos");
		
		ruta1.getGrupoTuristas().add(gt1);
		ruta1.setTuristasTotal();
		ruta1.getPuntoInteres().add(pi1);
		ruta1.getPuntoInteres().add(pi2);
		guia1.getRutas().add(ruta1);
		guia1.getRutas().add(ruta2);
		
		ruta2.getGrupoTuristas().add(gt2);
		ruta2.setTuristasTotal();
		ruta2.getPuntoInteres().add(pi3);
		ruta2.getPuntoInteres().add(pi4);
		guia2.getRutas().add(ruta3);
		guia2.getRutas().add(ruta4);
		
		rutas.add(ruta1);
		rutas.add(ruta2);
		rutas.add(ruta3);
		rutas.add(ruta4);
		rutas.add(ruta5);
		rutas.add(ruta6);
	
	}
	
}
