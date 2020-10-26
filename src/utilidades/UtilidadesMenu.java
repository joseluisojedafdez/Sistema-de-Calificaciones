package utilidades;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UtilidadesMenu {

	public int contruirMenu(List<String> pOpcionesMenu, Scanner leer) {

		List<String> opcionesMenu = pOpcionesMenu;
		int largo = opcionesMenu.size();

		for (int i = 0; i < largo; i++) {
			System.out.println(i + 1 + " " + opcionesMenu.get(i));
		}
		return seleccionValida(largo, leer);
	}

	private int seleccionValida(int largo, Scanner leer) {
		int opcion = 0;
		boolean valida = false;
		while (!valida) {
			System.out.print("Ingresar opción: ");
			try {
				opcion = leer.nextInt();
			} catch (Exception error) {
				leer.nextLine();
			}

			if (opcion < 1 || opcion >= largo + 1) {
				System.out.println("Opción inválida, intente de nuevo");
			} else {
				valida = true;
			}
		}
		return opcion;
	}

	
				
		
			

}
