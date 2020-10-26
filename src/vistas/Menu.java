package vistas;

import java.util.Scanner;

import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

public class Menu extends MenuTemplate {
	private Scanner currScanner = new Scanner(System.in);
	AlumnoServicio currServicioAlumno = new AlumnoServicio();
	ArchivoServicio currServicioArchivo = new ArchivoServicio();

	@Override
	public void cargarDatos() {

	}

	@Override
	public void exportarDatos() {

	}

	@Override
	public void crearAlumno() {

	}

	@Override
	public void agregarMateria() {

	}

	@Override
	public void agregarNotaPasoUno() {

	}

	@Override
	public void listarAlumnos() {

	}

	@Override
	public void terminarPrograma() {

	}

	public Scanner getCurrScanner() {
		return currScanner;
	}

	public void setCurrScanner(Scanner currScanner) {
		this.currScanner = currScanner;
	}
}