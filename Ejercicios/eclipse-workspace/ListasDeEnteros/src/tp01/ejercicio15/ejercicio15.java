package tp01.ejercicio15;

import tp01.ejercicio1.ListaDeEnterosEnlazada;

public class ejercicio15 {
	public static void metodoRecursivo (ListaDeEnterosEnlazada lista) { //para imprimir recursivamente en sentido inverso  
	  if(!lista.fin()) {
	     int elem = lista.proximo();
	     metodoRecursivo(lista);
	     System.out.println(elem + ", ");
	}

}
}
