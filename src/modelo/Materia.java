package modelo;

import java.util.ArrayList;
import java.util.List;

public class Materia {

	
	private MateriaEnum nombre;
	private List<Double> notas;
	
	public Materia() {
		
	}
	public Materia(MateriaEnum materiaAlumno) {
		this.nombre=materiaAlumno;
		this.notas=new ArrayList<Double>();
	}
	
	public Materia(MateriaEnum nombre, List<Double> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}
	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
	}

	public MateriaEnum getNombre() {
		return nombre;
	}
	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}

	

}
