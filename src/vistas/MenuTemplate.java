package vistas;


import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import modelo.Alumno;
import utilidades.UtilidadesMenu;

public abstract class MenuTemplate {
	protected Scanner scanner = new Scanner(System.in);

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Set<Alumno> cargarDatos() {
		// ejecuta la carga de datos del archivo
		return null;
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

	}

	public boolean iniciarMenu() {
		boolean continuar = true;
		UtilidadesMenu opcionMenu = new UtilidadesMenu();
		List<String> opciones = opcionMenu.crearOpciones();
		int opcionUsuario = contruirMenu(opciones, scanner);
		Menu menuPrincipal = new Menu();

		if (opcionUsuario == 1) {
			menuPrincipal.crearAlumno();
		} else if (opcionUsuario == 2) {
			menuPrincipal.listarAlumnos();
		} else if (opcionUsuario == 3) {
			menuPrincipal.agregarMateria();

		} else if (opcionUsuario == 4) {
			menuPrincipal.agregarNotaPasoUno();
		} else if (opcionUsuario == 5) {

			menuPrincipal.cargarDatos();

		} else if (opcionUsuario == 6) {
			menuPrincipal.exportarDatos();
		} else {
			continuar = false;
		}

		return continuar;

	}

	public int contruirMenu(List<String> pOpcionesMenu, Scanner leer) {

		List<String> opcionesMenu = pOpcionesMenu;
		int largo = opcionesMenu.size();

		for (int i = 0; i < largo; i++) {
			System.out.println(i + 1 + " " + opcionesMenu.get(i));
		}
		return seleccionValida(largo, leer);
	}

	public int seleccionValida(int largo, Scanner leer) {
		int opcion = 0;
		boolean valida = false;
		while (!valida) {
			System.out.print("Ingresar opción: ");
			try {
				opcion = leer.nextInt();
			} catch (Exception error) {
				leer.nextLine();
			}

			if (opcion < 1 || opcion >= largo + 1) {
				System.out.println("Opción inválida, intente de nuevo");
			} else {
				valida = true;
			}
		}
		return opcion;
	}

}
