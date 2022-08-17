package tp02.repaso;

import tp02.ArbolesBinarios.ArbolBinario;
//Dado un arbol binario de enteros definimos la "trayectoria con peso" como la suma de los elementos 
//del camino tal que para cada elemento antes de sumarlo, lo multiplicamos por el nivel en el que se encuentra. 

public class CalculadorArbol {
	
	public int maximaTrayectoria(ArbolBinario<Integer> arbol) {
		if(arbol.esVacio())
			return 0;
		else
			return maximaTrayectoriaRec(arbol,0);
	}

	private int maximaTrayectoriaRec(ArbolBinario<Integer> arbol, int nivel) {
		int pesoRaiz = arbol.getDatoRaiz() * nivel;
		int maxHijos = 0;
		
		// es lo mismo hacer aca nivel = nivel + 1
		
		if(!arbol.getHijoIzquierdo().esVacio()) {
			int trayectoriaIzquierda = maximaTrayectoriaRec(arbol.getHijoIzquierdo(), nivel+1);
			maxHijos = Math.max(trayectoriaIzquierda,maxHijos);
		}
		
		if(!arbol.getHijoDerecho().esVacio()) {
			int trayectoriaDerecha = maximaTrayectoriaRec(arbol.getHijoDerecho(), nivel+1);
			maxHijos = Math.max(trayectoriaDerecha,maxHijos);
		}
	
		return maxHijos + pesoRaiz;
		
		
		
	}
	
	

}
