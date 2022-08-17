package tp02.ArbolesBinarios;

public class testRecorridos {
	public static void main(String[] args) {
		
	            //     4       altura = 3 (cuento desde la raiz hasta la hoja mas lejana) 
	           //    /   \
	          //    2     6
	         //    / \   / \
	        //    1   3 5   7
	       //      \       /
	      //        9     9  
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(4);
		ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		ab.agregarHijoDerecho(new ArbolBinario<Integer>(6));
		ab.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		ab.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(3));
		ab.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		ab.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(7));
		ArbolBinario <Integer> aux = ab.getHijoIzquierdo().getHijoIzquierdo();
		aux.agregarHijoDerecho(new ArbolBinario<Integer>(9));
		aux = ab.getHijoDerecho().getHijoDerecho();
		aux.agregarHijoIzquierdo(new ArbolBinario<Integer>(9));
		
		System.out.println("---- TEST IMPRESIÓN POR NIVELES----");
		ab.recorridoPorNiveles();
		System.out.println("\n\n");
		System.out.println("El arbol es par?: " + ab.esArbolPar() + "\n");
		int n, m;
		n=1; m=3;
		System.out.println("Los datos entre los niveles: " + n + " y " + m + " son:");
		ab.entreNiveles(n, m);
		System.out.println("El árbol es lleno? " + ab.lleno());
		
		
         //	    1       
        //    /   \
       //    2     3
      //    / \   / \
     //    4   5 6  
    //          
		
		ArbolBinario <Integer> ab2 = new ArbolBinario <Integer>(1);
		ab2.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		ab2.agregarHijoDerecho(new ArbolBinario<Integer>(3));
		ab2.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		ab2.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(5));
		ab2.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		
		System.out.println("");
		System.out.println("---- TEST IMPRESIÓN POR NIVELES----");
		ab2.recorridoPorNiveles();
		System.out.println("\n\n");
		ArbolBinario <Integer> espejo = ab2.espejo();
		espejo.recorridoPorNiveles();
		
	}

}
