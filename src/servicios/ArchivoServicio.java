package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;

public class ArchivoServicio {

	final static String SEPARATOR = ",";
	static List<String> listaDatos = new ArrayList<String>();

	public List<PromedioServicioImp> exportarDatos(String pArchivo) {
		List<PromedioServicioImp> listaPromedios = new ArrayList<PromedioServicioImp>();

		return listaPromedios;
	}

	public void exportarDatos(Map<Alumno, String> pAlumnos, String pRutaArchivo) {

	}

	public Set<Alumno> listarAlumnos(String nombreArchivo) {

		Set<Alumno> listado = new HashSet<Alumno>();
		Alumno alumno = new Alumno();
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(nombreArchivo));
			String line = br.readLine();
			String rutAnterior = "";
			while (line != null) {
				String[] values = line.split(SEPARATOR);
				alumno = new Alumno(values[0], values[1]);

				alumno.getMaterias();
				String rut = values[0];

				if (!rutAnterior.equals(rut)) {
					listado.add(alumno);
				}
				line = br.readLine();
				rutAnterior = rut;
			}
		}

		catch (Exception e) {

		} finally {
			if (null != br) {

			}

		}
		try {
			br.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
		return listado;

	}

	public Set<Alumno> crearListaAlumnos(String nombreArchivo) {

		Set<Alumno> listaAlumnos = new HashSet<Alumno>();
		listaAlumnos = listarAlumnos(nombreArchivo);

		return listaAlumnos;

	}

	public void addMaterias(Set<Alumno> listaAlumnos, String nombreArchivo) {

		BufferedReader br = null;
		Set<Materia> listaMaterias = new HashSet<Materia>();
		List<Double> notas = new ArrayList<Double>();
		System.out.println(listaAlumnos);
		try {

			br = new BufferedReader(new FileReader(nombreArchivo));
			String line = br.readLine();

			while (line.contains(",")) {
				String[] values = line.split(SEPARATOR);
				
				for (Alumno alumno : listaAlumnos) {
					if (alumno.getRut().equals(values[0])) {
						listaMaterias = alumno.getMaterias();
						MateriaEnum mat = MateriaEnum.valueOf(values[2]);
						Materia materiaNueva = new Materia(mat);
						Double valorNota = Double.parseDouble(values[3]);
						notas = materiaNueva.getNotas();
						notas.add(valorNota);
						listaMaterias.add(materiaNueva);
						alumno.setMaterias(listaMaterias);

					}
				}
			}System.out.println("Archivo importado: "+nombreArchivo);

		} 

		catch (Exception e) {

		} finally {
			if (null != br) {

			}

		}
		try {
			br.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

}
