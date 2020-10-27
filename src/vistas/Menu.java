package vistas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

public class Menu extends MenuTemplate {
	private Scanner currScanner = new Scanner(System.in);
	AlumnoServicio currServicioAlumno = new AlumnoServicio();
	ArchivoServicio currServicioArchivo = new ArchivoServicio();
	Set<Alumno> listaAlumnos=new HashSet<Alumno>();
	Map<Alumno, Set<Materia>> listaMateriasxAlumno = new HashMap<Alumno, Set<Materia>>();

	@Override
	public Set<Alumno> cargarDatos() {
		
		listaAlumnos=new ArchivoServicio().crearListaAlumnos("notas.csv");
		System.out.println("Linea 29 Menu"+listaAlumnos);
		return listaAlumnos;
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
		listaMateriasxAlumno.put(nuevoAlumno, null);
		System.out.println("---------------------------------");
		
	}

	@Override
	public void agregarMateria() {
		System.out.println("Introduzca Rut Alumno: ");
	
		String rut = scanner.nextLine();
		
		for (Alumno alumno:listaAlumnos) {
				
			if (alumno.getRut().equals(rut)) {
				System.out.println("Materias por Alumno: ");
				System.out.println(alumno.getMaterias());
				System.out.println("¿Qué Materia quiere añadir?: ");
				System.out.println(MateriaEnum.MATEMATICAS);
				System.out.println(MateriaEnum.LENGUAJE);
				System.out.println(MateriaEnum.CIENCIA);
				System.out.println(MateriaEnum.HISTORIA);
				String añadirMateria = scanner.nextLine();
				MateriaEnum mat = MateriaEnum.valueOf(añadirMateria);
				Materia materiaNueva = new Materia(mat);
				Set<Materia> materias = alumno.getMaterias();
				materias.add(materiaNueva);
				alumno.setMaterias(materias);
			}
			else {
				
			}

		}
}

	@Override
	public void agregarNotaPasoUno() {
		System.out.println("Agregando Notas");

	}

	@Override
	public void listarAlumnos() {
		System.out.println("---------------------------------");

		for (Alumno alumno: listaAlumnos) {
			System.out.println("Datos Alumno");
			System.out.println("	RUT: " + alumno.getRut());
			System.out.println("	Nombre: " + alumno.getNombre());
			System.out.println("	Apellido: " + alumno.getApellido());
			System.out.println("	Dirección: " + alumno.getDireccion());
			System.out.println("Materias");
			System.out.println("	" + alumno.getMaterias());
			System.out.println("		Notas");
			System.out.println("		" + alumno.getMaterias());
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