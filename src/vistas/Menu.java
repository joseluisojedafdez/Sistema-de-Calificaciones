package vistas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import modelo.Alumno;
import modelo.Materia;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

public class Menu extends MenuTemplate {
	private Scanner currScanner = new Scanner(System.in);
	AlumnoServicio currServicioAlumno = new AlumnoServicio();
	ArchivoServicio currServicioArchivo = new ArchivoServicio();
	List<Alumno> listaAlumnos = new ArrayList<Alumno>();
	static Map <Alumno,Materia> listaMateriasxAlumno=new HashMap <Alumno,Materia>();

	

	@Override
	public Map<Alumno,Materia> cargarDatos() {
		listaMateriasxAlumno.putAll(ArchivoServicio.cargarAlumnos());
		System.out.println(listaMateriasxAlumno);
		System.out.println(listaAlumnos);
		return listaMateriasxAlumno;
	}

	@Override
	public void exportarDatos() {
		System.out.println("Exportando Datos");

	}

	@Override
	public void crearAlumno() {
		Scanner leer = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("Ingrese RUT: ");
		String rut = leer.nextLine();
		System.out.println("Ingrese Nombre: ");
		String nombre = leer.nextLine();
		System.out.println("Ingrese Apellido: ");
		String apellido = leer.nextLine();
		System.out.println("Ingrese Dirección: ");
		String direccion = leer.nextLine();
		Alumno nuevoAlumno = new Alumno(rut, nombre, apellido, direccion, null);
		listaAlumnos.add(nuevoAlumno);
		System.out.println("---------------------------------");

	}

	@Override
	public void agregarMateria() {
		System.out.println("Agregando Materia");
		System.out.println(listaMateriasxAlumno.isEmpty());
	}

	@Override
	public void agregarNotaPasoUno() {
		System.out.println("Agregando Notas");

	}

	@Override
	public void listarAlumnos() {
		System.out.println("---------------------------------");

		System.out.println(listaMateriasxAlumno.isEmpty());
		for (Map.Entry<Alumno, Materia> entry : listaMateriasxAlumno.entrySet()) {
			System.out.println("Datos Alumno");
			System.out.println("	RUT: " + entry.getKey().getRut());
			System.out.println("	Nombre: " + entry.getKey().getNombre());
			System.out.println("	Apellido: " + entry.getKey().getApellido());
			System.out.println("	Dirección: " + entry.getKey().getDireccion());
			System.out.println("Materias");
			System.out.println("	" + entry.getValue().getNombre());
			System.out.println("		Notas");
			System.out.println("		" + entry.getValue().getNotas());
		}

		System.out.println("---------------------------------");

	}

	@Override
	public void terminarPrograma() {
		System.out.println("Programa Finalizado. Hasta Pronto....");
	}

	public Scanner getCurrScanner() {
		return currScanner;
	}

	public void setCurrScanner(Scanner currScanner) {
		this.currScanner = currScanner;
	}
}