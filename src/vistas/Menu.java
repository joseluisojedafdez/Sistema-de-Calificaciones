package vistas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
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
import servicios.PromedioServicioImp;

public class Menu extends MenuTemplate {
	private Scanner currScanner = new Scanner(System.in);
	AlumnoServicio currServicioAlumno = new AlumnoServicio();
	ArchivoServicio currServicioArchivo = new ArchivoServicio();
	static Set<Alumno> listaAlumnos = new HashSet<Alumno>();
	List<String[]> listaValores = new ArrayList<String[]>();
	

	@Override
	public Set<Alumno> cargarDatos() {
		ArchivoServicio cargaDatos = new ArchivoServicio();
		listaAlumnos = cargaDatos.crearListaAlumnos("notas.csv");
		System.out.println("Lista de alumnos cargada");
		//listaValores=cargaDatos.addValuesfromFile();
		//ystem.out.println("Lista de valores cargada");
		//addMaterias();
		//System.out.println("Archivo notas.csv importado.");
		return listaAlumnos;
	}

	@Override
	public void exportarDatos() {
		System.out.println("Exportando Datos a promedios.txt");
		FileWriter archivo = null;
		BufferedWriter escribir = null;
		
		try {
			archivo = new FileWriter("promedios.txt");
			escribir = new BufferedWriter(archivo);
			for (Alumno alumno : listaAlumnos) {
				Map<String, Double> promedioMaterias = calculaPromedios(alumno);
				escribir.write("Alumno: " + alumno.getRut().toString() + " - " + alumno.getNombre().toString()+"\n");
				for (Map.Entry<String, Double> entry : promedioMaterias.entrySet()) {
					escribir.write("Materia: " + entry.getKey().toString() + " - Promedio: " + entry.getValue().toString()+"\n");

				}
			}
			System.out.println("Datos exportados a promedios.txt");

		}
		// En caso de un erros al crear nuevo archivo
		catch (Exception error) {
			System.out.println("El archivo promedios.txt no se pudo crear " + error);

		}

		try {
			escribir.close();
			archivo.close();
		} catch (Exception error) {
			System.out.println("El archivo promedios.txt no se pudo cerrar " + error);

		}
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
		Alumno nuevoAlumno = new Alumno(rut, nombre, apellido, direccion, new HashSet<Materia>());
		listaAlumnos.add(nuevoAlumno);
		System.out.println("---------------------------------");

	}

	@Override
	public void agregarMateria() {
		System.out.println("Introduzca Rut Alumno: ");

		String rut = scanner.nextLine();

		for (Alumno alumno : listaAlumnos) {

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
			} else {
				System.out.println("Alumno con RUT: " + rut + " no existe");

			}

		}
	}

	@Override
	public void agregarNotaPasoUno() {

		System.out.println("Introduzca Rut Alumno: ");

		String rut = scanner.nextLine();

		for (Alumno alumno : listaAlumnos) {

			if (alumno.getRut().equals(rut)) {
				System.out.println("Materias por Alumno: ");
				System.out.println(alumno.getMaterias());
				System.out.println("¿Qué Materia quiere calificar: ");
				String añadirMateria = scanner.nextLine();
				MateriaEnum mat = MateriaEnum.valueOf(añadirMateria);
				for (Materia materia : alumno.getMaterias()) {
					if (materia.getNombre() == mat) {
						System.out.println("Indique Calificación: ");
						Double nota = Double.parseDouble(scanner.nextLine());
						List<Double> notas = materia.getNotas();
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
			System.out.println("	Dirección: " + alumno.getDireccion());
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

	public Map<String, Double> calculaPromedios(Alumno pAlumno) {

		Map<String, Double> materiasPromedio = new HashMap<String, Double>();
		PromedioServicioImp avgCalc = new PromedioServicioImp();
		Set<Materia> materiasAlumno = pAlumno.getMaterias();
		for (Materia materia : materiasAlumno) {
			Double promedio = avgCalc.calcularPromedio(materia.getNotas());
			materiasPromedio.put(materia.getNombre().toString(), promedio);
		}

		return materiasPromedio;
	}
	
	public void addMaterias() {
		
		for (Alumno alumno : listaAlumnos) {
			String rutAlumno=alumno.getRut();
			System.out.println("Añadiendo materias al alumno "+rutAlumno);		
			for(String[] valorArchivo:listaValores) {

			if (rutAlumno.equals(valorArchivo[0])) {
				
				MateriaEnum mat = MateriaEnum.valueOf(valorArchivo[2]);
				Materia materiaNueva = new Materia(mat);
				Set<Materia> materias = alumno.getMaterias();
				materias.add(materiaNueva);
				System.out.println("Añadiendo "+materiaNueva+" al alumno "+rutAlumno);
				alumno.setMaterias(materias);
			} 
				

			}

		}
	}
}