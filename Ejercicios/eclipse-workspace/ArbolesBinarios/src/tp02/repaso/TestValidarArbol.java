package tp02.repaso;
import tp02.ArbolesBinarios.ArbolBinario;

public class TestValidarArbol {
	public static void main(String[] args) {
		
         //	    9       altura = 3 (cuento desde la raiz hasta la hoja mas lejana) 
        //    /   \
       //    1     2
      //    / \     \
     //    5   4     1
    //        / \   / 
   //        1   1 3    
		
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(9);
		ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		ab.agregarHijoDerecho(new ArbolBinario<Integer>(2));
		ab.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		ab.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ab.getHijoDerecho().agregarHijoDerecho(new ArbolBinario <Integer>(1));
		ArbolBinario <Integer> aux = ab.getHijoIzquierdo().getHijoDerecho();
		aux.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		aux.agregarHijoDerecho(new ArbolBinario<Integer>(1));
		aux = ab.getHijoDerecho().getHijoDerecho();
		aux.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		
		System.out.println("---- TEST IMPRESIÓN POR NIVELES----");
		ab.recorridoPorNiveles();
		System.out.println("\n\n");
		
		ValidarArbol v = new ValidarArbol(ab);
		System.out.println("El promedio del arbol es:" + v.buscarPromedio());
		
		
	}

}
