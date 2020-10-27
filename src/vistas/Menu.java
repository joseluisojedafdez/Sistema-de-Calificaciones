package vistas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.List;



import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

public class Menu extends MenuTemplate {
	private Scanner currScanner = new Scanner(System.in);
	AlumnoServicio currServicioAlumno = new AlumnoServicio();
	ArchivoServicio currServicioArchivo = new ArchivoServicio();
	static Set<Alumno> listaAlumnos = new HashSet<Alumno>();
	Map<Alumno, Set<Materia>> listaMateriasxAlumno = new HashMap<Alumno, Set<Materia>>();

	@Override
	public Set<Alumno> cargarDatos() {

		listaAlumnos = new ArchivoServicio().crearListaAlumnos("notas.csv");
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
		System.out.println("Ingrese Direcci�n: ");
		String direccion = leer.nextLine();
		Alumno nuevoAlumno = new Alumno(rut, nombre, apellido, direccion, new HashSet<Materia>());
		listaAlumnos.add(nuevoAlumno);
		System.out.println("---------------------------------");

	}

	@Override
	public void agregarMateria() {
		System.out.println("Introduzca Rut Alumno: ");

		String rut = scanner.nextLine();
		System.out.println(listaAlumnos.size());
		for (Alumno alumno : listaAlumnos) {

			if (alumno.getRut().equals(rut)) {
				System.out.println("Materias por Alumno: ");
				System.out.println(alumno.getMaterias());
				System.out.println("�Qu� Materia quiere a�adir?: ");
				System.out.println(MateriaEnum.MATEMATICAS);
				System.out.println(MateriaEnum.LENGUAJE);
				System.out.println(MateriaEnum.CIENCIA);
				System.out.println(MateriaEnum.HISTORIA);
				String a�adirMateria = scanner.nextLine();
				MateriaEnum mat = MateriaEnum.valueOf(a�adirMateria);
				Materia materiaNueva = new Materia(mat);
				Set<Materia> materias = alumno.getMaterias();
				materias.add(materiaNueva);
				alumno.setMaterias(materias);
			} else {

			}

		}
	}

	@Override
	public void agregarNotaPasoUno() {
		
		System.out.println("Introduzca Rut Alumno: ");

		String rut = scanner.nextLine();
		System.out.println(listaAlumnos.size());
		for (Alumno alumno : listaAlumnos) {

			if (alumno.getRut().equals(rut)) {
				System.out.println("Materias por Alumno: ");
				System.out.println(alumno.getMaterias());
				System.out.println("�Qu� Materia quiere calificar: ");
				String a�adirMateria = scanner.nextLine();
				MateriaEnum mat = MateriaEnum.valueOf(a�adirMateria);
				for(Materia materia:alumno.getMaterias()) {
					if (materia.getNombre()==mat) {
						System.out.println("Indique Calificaci�n: ");
						Double nota=Double.parseDouble(scanner.nextLine());
						List<Double>notas= materia.getNotas();
						notas.add(nota);
						materia.setNotas(notas);
					}
						
					}
				}
			}
	}

	@Override
	public void listarAlumnos() {
		System.out.println("---------------------------------");

		for (Alumno alumno : listaAlumnos) {
			System.out.println("Datos Alumno");
			System.out.println("	RUT: " + alumno.getRut());
			System.out.println("	Nombre: " + alumno.getNombre());
			System.out.println("	Apellido: " + alumno.getApellido());
			System.out.println("	Direcci�n: " + alumno.getDireccion());
			System.out.println("Materias");
			for (Materia materia : alumno.getMaterias()) {
				System.out.println("	" + materia.getNombre());
				System.out.println("		Notas");
				System.out.println("		" + materia.getNotas());
			}

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