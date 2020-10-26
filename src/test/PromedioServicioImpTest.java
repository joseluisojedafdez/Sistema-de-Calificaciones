package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servicios.PromedioServicioImp;

public class PromedioServicioImpTest {
	
	List<Double> lista=new ArrayList<Double>();
	PromedioServicioImp promedio=null;
	
	@BeforeEach
	void setup(){
		promedio=new PromedioServicioImp();	
		
	}
	
	
	@Test
	@DisplayName ("Calcular promedio con valores nulos")
	void calcularZero () {
	
	Double resultado=promedio.calcularPromedio(lista);
	
	assertEquals(resultado,null);
		
	}
	
	@Test
	@DisplayName ("Calcular promedio caso feliz")
	void calcularHappyCase() {
		lista.add(4.0);
		lista.add(3.0);
		Double resultado=promedio.calcularPromedio(lista);
		assertEquals(resultado,3.5,0.0);
		
	}

}
