package tp01.ejercicio12y13;

import tp01.ejercicio1.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglos {
	
	public static void main(String[] args) {
		 ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		 
		 lista.comenzar();
		 lista.agregarInicio(10);
		 lista.agregarEn(15, 2);
		 lista.agregarEn(20, 3);
		 lista.agregarEn(25, 4);
		 lista.agregarEn(30, 5);
		 lista.agregarEn(35, 6);
		 
		 int i = 1;
		 while ( i <= lista.tamanio()) {
			 System.out.println (lista.elemento(i));
			 i++;
		 }
		 
	}

}
