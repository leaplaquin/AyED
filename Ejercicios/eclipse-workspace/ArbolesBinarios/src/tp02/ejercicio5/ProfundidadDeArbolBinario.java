package tp02.ejercicio5;

import tp01.ejercicio3.ColaGenerica;
import tp02.ArbolesBinarios.ArbolBinario;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> ab;

	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		this.ab = arbol;
	}

	public int sumaElementosProfundidad(int p) { // devuelve la suma de todos los nodos del arbol que se encuentren en el nivel pasado como argumento

		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();

		int nivelAct = 0;
		int sumaNodos = 0;
		
		if (!this.ab.esVacio()) {
			cola.encolar(this.ab);
			cola.encolar(null);

			ArbolBinario<Integer> a;
			while ((!cola.esVacia()) & (nivelAct<=p)) {
				a = cola.desencolar();
				if (a != null) {
					if ((nivelAct == p)) { // si el nivel en el que estoy es igual al nivel recibido lo sumo a mi variable
						sumaNodos = sumaNodos + a.getDatoRaiz();
					}
					if (!a.getHijoIzquierdo().esVacio())
						cola.encolar(a.getHijoIzquierdo());
					if (!a.getHijoDerecho().esVacio())
						cola.encolar(a.getHijoDerecho());
				} 
				else { 
					nivelAct++;
					if (!cola.esVacia()) {
						cola.encolar(null);
					}
				}

			}
		}
		return sumaNodos;
	}

}
