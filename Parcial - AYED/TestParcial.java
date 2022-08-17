package NicolasDeRose;

import tp02.ArbolesBinarios.ArbolBinario;

public class TestParcial {
	public static void main(String[] args) {
		
		ArbolBinario <Integer> ab = new ArbolBinario <Integer>(2);
		ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		ab.agregarHijoDerecho(new ArbolBinario<Integer>(5));
		ab.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		ab.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(0));
		ab.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(8));
		ArbolBinario <Integer> aux = ab.getHijoDerecho().getHijoIzquierdo();
		aux.agregarHijoDerecho(new ArbolBinario<Integer>(22));
		
		System.out.println("---- TEST IMPRESIÓN POR NIVELES----");
		ab.recorridoPorNiveles();
		System.out.println("\n\n");
		
		System.out.print(Parcial.resolver(ab));


	}
	
}
