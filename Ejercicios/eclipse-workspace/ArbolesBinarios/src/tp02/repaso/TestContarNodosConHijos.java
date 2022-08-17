package tp02.repaso;

import tp02.ArbolesBinarios.ArbolBinario;

public class TestContarNodosConHijos {
	public static void main(String[] args) {
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(9);
		ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		ab.agregarHijoDerecho(new ArbolBinario<Integer>(2));
		
		System.out.println("---- TEST IMPRESIÓN POR NIVELES----");
		ab.recorridoPorNiveles();
		System.out.println("\n\n");
		
		ContarNodosConHijos c = new ContarNodosConHijos(ab);
		System.out.println("la cantidad de nodos con dos hijos es " + c.contar());
	}
}
