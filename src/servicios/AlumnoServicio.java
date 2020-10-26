package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Alumno;
import modelo.Materia;

public class AlumnoServicio {
private List<Alumno> listaAlumnos;

public void crearAlumno (Alumno pAlumno) {
	
}

public void agregarMateria(String pRutAlumno, Materia currentMate) {
	
}

public List<Materia> materiasPorAlumno (String pRutAlumno){
	
	List <Materia> materias=new ArrayList <Materia>();
	
	return materias;
}
public Map<String,Alumno> listarAlumnos(){
	
	Map<String, Alumno> listaAlumnos = new HashMap<String,Alumno>();
	
	return listaAlumnos;
}

public List<Alumno> getListaAlumnos() {
	return listaAlumnos;
}

public void setListaAlumnos(List<Alumno> listaAlumnos) {
	this.listaAlumnos = listaAlumnos;
}

}
