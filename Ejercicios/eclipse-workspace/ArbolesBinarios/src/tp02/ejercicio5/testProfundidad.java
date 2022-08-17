package tp02.ejercicio5;
import tp02.ArbolesBinarios.ArbolBinario;

public class testProfundidad {
	public static void main(String[] args) {
		
        //     2       altura = 2 (cuento desde la raiz hasta la hoja mas lejana) 
       //    /   \
      //    5     8
     //    / \   / \
    //    1          
		
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(2);
		ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		ab.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		ab.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		
		
		System.out.println("---- IMPRESIÓN POR NIVELES ----");
		ab.recorridoPorNiveles();
		
		ProfundidadDeArbolBinario a = new ProfundidadDeArbolBinario(ab);
		int cant = a.sumaElementosProfundidad(1);
		System.out.println("cantidad de nodos del nivel 1: " + cant );
	}

}
