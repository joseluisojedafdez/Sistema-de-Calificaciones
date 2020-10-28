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
			FileReader fr=new FileReader(nombreArchivo);
			br = new BufferedReader(fr);
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
			br.close();
			fr.close();
		}

		catch (Exception e) {

		} finally {
			if (null != br) {

			}

		}
		
		
		
		return listado;

	}

	public Set<Alumno> crearListaAlumnos(String nombreArchivo) {

		Set<Alumno> listaAlumnos = new HashSet<Alumno>();
		listaAlumnos = listarAlumnos(nombreArchivo);

		return listaAlumnos;

	}

	public List<String[]> addValuesfromFile() {
		System.out.println("Comenzando a añadir los valores");
		BufferedReader br = null;
		String nombreArchivo="notas.csv";
		List<String[]> listaValores = new ArrayList<String[]>();
		
		try {
			FileReader fr= new FileReader(nombreArchivo);
			System.out.println("Abriendo el archivo");
			br = new BufferedReader(fr);
			String line = br.readLine();

			while (line!=null) {
				String[] values = line.split(SEPARATOR);
				System.out.println("Añadiendo línea");
				listaValores.add(values);

			}
				br.close();
				fr.close();
		}

		catch (Exception e) {

		} finally {
			if (null != br) {

			}

		}
		
	
		return listaValores;
	}

}
