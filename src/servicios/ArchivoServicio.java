package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
			String rutAnterior="";
			while (line != null) {
				String[] values = line.split(SEPARATOR);
				alumno = new Alumno(values[0], values[1]);
				
				String rut=values[0];
				
				
				if (!rutAnterior.equals(rut)){
				listado.add(alumno);
				}
				line = br.readLine();
				rutAnterior=rut;
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
		System.out.println(listaAlumnos);

		return listaAlumnos;

	}
	
	public static Map<String, HashSet<Materia>> crearMateriaxAlumno(List<Alumno> listaAlumnos,String nombreArchivo) {

		Map<String , HashSet<Materia>> mapa = new HashMap<String,HashSet<Materia>>();
		List<Double>notas=new ArrayList <Double>();
		HashSet<Materia>listaMaterias=new HashSet<Materia>();
		Materia materiaAlumno;
		String rut="";
		
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(nombreArchivo));
			String line = br.readLine();

			while (line != null) {
				String[] values = line.split(SEPARATOR);
				rut = values[0];
				MateriaEnum mat=MateriaEnum.valueOf(values[2]);
				materiaAlumno = new Materia (mat);
				for (Alumno alumno:listaAlumnos) {
					if (rut.equals(alumno.getRut())&&(materiaAlumno.getNombre()==mat)) {
						notas.add(Double.parseDouble(values[3]));
						materiaAlumno.setNotas(notas);
						listaMaterias.add(materiaAlumno);
						mapa.put(rut,listaMaterias);				
					
					} else if (rut.equals(alumno.getRut())&&materiaAlumno.getNombre()==mat){
						notas.add(Double.parseDouble(values[3]));
						materiaAlumno.setNotas(notas);
						mapa.put(rut,listaMaterias);
					}
					
			}
					
				
				line = br.readLine();
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
		return mapa;

	}
	
}
