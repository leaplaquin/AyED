package tp01.ejercicio16;

import tp01.ejercicio1.ListaDeEnterosEnlazada;

public class ejercicio16 {
	
	public static void main(String [] args) {
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		int n = 16;
		lista = (ListaDeEnterosEnlazada) Sucesion.calcularSucesion(n);
		  for(int i = lista.tamanio(); i>= 1; i--) {
			  System.out.println(lista.elemento(i));
			  System.out.println(" ");
		  }	
		
	}

}
