package ej01;
import java.util.Scanner;

public class TestPasajeDeParametros {
	
    public TestPasajeDeParametros() {
    	
    }
	
	public static void main(String[] args) {
		
		
//      Integer edadMadre = 0;
//      Integer edadHijo = 0;
//      TestPasajeDeParametros.pedirEdades(edadMadre,edadHijo);
		
		Edades ed =new Edades();
		TestPasajeDeParametros.pedirEdades(ed);
		System.out.println("La madre tuvo a su hijo a los: "+(ed.getEdadMadre() - ed.getEdadHijo())+" años");
		
	}
	
	//private static void pedirEdades(Integer edad1, Integer edad2){
	//	 Scanner input = new Scanner(System.in);
	//	 System.out.println("Ingrese la edad de la madre:");
    //   edad1 = input.nextInt();
    //   System.out.println("Ingrese la edad del hijo:");
	//   edad2 = input.nextInt();
    //   input.close();		
	

	
	private static void pedirEdades(Edades ed1) { 
		Scanner input = new Scanner(System.in); //Create a Scanner object
		System.out.println("Ingrese la edad de la madre:");
		ed1.setEdadMadre(input.nextInt());
		System.out.println("Ingrese la edad del hijo:");
		ed1.setEdadHijo(input.nextInt());
		input.close();		
	}
	
	

}
