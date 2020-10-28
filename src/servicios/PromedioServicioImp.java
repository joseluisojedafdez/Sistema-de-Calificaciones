package servicios;

import java.util.List;

public class PromedioServicioImp {

	public Double calcularPromedio(List<Double>plista) {
		
		Double resultado=0.0;
		Double suma=0.0;
				
		if (plista.isEmpty()==true) {
			resultado=null;
		} else {
		
		for (int i=0;i<plista.size();i++) {
			suma=suma+plista.get(i);
		}
				
		resultado=(double) Math.round(suma/plista.size()*10d/10d);
		}
		
		return resultado;
	}
	
}
