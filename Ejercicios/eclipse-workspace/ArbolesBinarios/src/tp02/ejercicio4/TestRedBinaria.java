package tp02.ejercicio4;

import tp02.ArbolesBinarios.ArbolBinario;

public class TestRedBinaria {
	public static void main(String[] args) {
			
	        //     1       altura = 2 
	       //    /   \
	      //    2     10
	     //    / \   /  \
	    //    1   3 5    8       
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(1);
		ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		ab.agregarHijoDerecho(new ArbolBinario<Integer>(10));
		ab.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		ab.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(3));
		ab.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		ab.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(8));

		System.out.println("---- IMPRESIÓN POR NIVELES ----");
		ab.recorridoPorNiveles();
		
		RedBinariaLlena retardoMax = new RedBinariaLlena();
		System.out.println("");
		System.out.println("retardo maximo del arbol: " + retardoMax.retardoReenvio(ab) );
	}


}
