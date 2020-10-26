package servicios;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;

public class ArchivoServicio {
	
public List<PromedioServicioImp> exportarDatos(String pArchivo){
	List <PromedioServicioImp> listaPromedios=new ArrayList<PromedioServicioImp>();
	
	return listaPromedios;
}

public void exportarDatos (Map<Alumno,String> pAlumnos,String pRutaArchivo) {
	
}

public static Map <Alumno,Materia> cargarAlumnos() {
	
	Alumno alumno=new Alumno();
	Map <Alumno,Materia> alumnosACargar=new HashMap <Alumno,Materia>();
	List <Double> notas=new ArrayList<Double>();
	Materia materia=new Materia();
	notas.add(1.3);
	notas.add(4.4);
	notas.add(2.3);
	materia.setNombre(MateriaEnum.MATEMATICAS);
	materia.setNotas(notas);
	alumno.setNombre("Pepe");
	alumno.setRut("18.546.232-1");
	
	
	alumnosACargar.put(alumno,materia);
	
	return alumnosACargar;
}


	
}
