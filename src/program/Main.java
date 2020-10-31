package program;



import utilidades.UtilidadesMenu;
import vistas.Menu;


public class Main {
	
	
	public static void main(String[] args) {
		
		
		
		Menu menuPrincipal=new Menu();
		
		boolean continuar=true;
		
		
		while (continuar==true) {
			//UtilidadesMenu menu=new UtilidadesMenu();
			//menu.limpiarPantalla();
			continuar=menuPrincipal.iniciarMenu();
			
		}
		menuPrincipal.terminarPrograma();
		
		
		
		
	
		
		
		
			
	}

}
