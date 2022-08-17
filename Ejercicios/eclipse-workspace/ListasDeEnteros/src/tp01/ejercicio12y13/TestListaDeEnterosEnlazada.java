package tp01.ejercicio12y13;

import tp01.ejercicio1.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {
	public static void main(String[] args) {
		 int [] array = {1,2,3,4,5,6};
		 ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		 
		 for (int i =0; i < array.length; i++) {
		      lista.agregarFinal(array[i]);
		    }
		 
		 lista.comenzar(); //con este mensaje sabemos que actual va a estarapuntando al primer nodo de la lista 
		 System.out.println(lista.tamanio());
		 System.out.println(lista.fin()); //devuelve true o false ya que contempla que actual referencia a un nodo o no 
		 while (!lista.fin()) {
		    System.out.println(lista.proximo());
		 }
		 
    }
		 
 }

		 
		 
