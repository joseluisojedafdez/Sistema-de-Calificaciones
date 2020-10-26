package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Alumno;

public class ArchivoServicio {
	
private List <Alumno> alumnosACargar;

PromedioServicioImp promediosServicioImp=new PromedioServicioImp();

public List<PromedioServicioImp> exportarDatos(String pArchivo){
	List <PromedioServicioImp> listaPromedios=new ArrayList<PromedioServicioImp>();
	
	return listaPromedios;
}

public void exportarDatos (Map<String,Alumno> pAlumnos,String pRutaArchivo) {
	
}

public List <Alumno> getAlumnosACargar() {
	return alumnosACargar;
}

public void setAlumnosACargar(List <Alumno> alumnosACargar) {
	this.alumnosACargar = alumnosACargar;
}

	
}
