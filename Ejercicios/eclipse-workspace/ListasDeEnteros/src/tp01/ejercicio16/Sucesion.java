package tp01.ejercicio16;

import tp01.ejercicio1.ListaDeEnteros;
import tp01.ejercicio1.ListaDeEnterosEnlazada;

public class Sucesion {
	
	public static ListaDeEnteros calcularSucesion(int n) {
		ListaDeEnteros sucesion; 
		if(n==1) {
			sucesion = new ListaDeEnterosEnlazada();
			sucesion.agregarInicio(1);
		}
		else {
			if(n%2 == 0) {
				sucesion = calcularSucesion(n/2);
			}
			else {
				sucesion = calcularSucesion (3*n+1);
			}
			sucesion.agregarInicio(n);
		}
	  return sucesion;
   }
}
		
