package vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
	protected Scanner scanner;

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public void cargarDatos() {
		// ejecuta la carga de datos del archivo
	}

	public void exportarDatos() {
		// llama a un método para exportar los promedios
	}

	public void crearAlumno() {
		// solicita ingreso de datos y llena objeto tipo alumno
	}

	public void agregarMateria() {
		// muestra menu para asignar materia a un alumno
	}

	public void agregarNotaPasoUno() {
		// muestra menu para asignar nota a un alumno
	}

	public void listarAlumnos() {
		// mustra lista de alumnos
	}

	public void terminarPrograma() {
		// finaliza la ejecución del sistema
	}

}
