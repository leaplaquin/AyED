package tp02.repaso;

import tp02.ArbolesBinarios.ArbolBinario;

public class ContarNodosConHijos {
	private ArbolBinario<Integer> arbol;
	
	public ContarNodosConHijos(ArbolBinario<Integer> unArbol) {
		this.arbol = unArbol;	
	}
	
	public int contar() {
		return contarNodosConDosHijos(arbol);
	}
	
	private int contarNodosConDosHijos(ArbolBinario<Integer> arbol) {
		int answer=0;
		if(!arbol.esVacio()) {
			if(!arbol.getHijoIzquierdo().esVacio() && !arbol.getHijoDerecho().esVacio()) {
				answer = 1;
			}
			answer = answer + contarNodosConDosHijos(arbol.getHijoIzquierdo());
			answer = answer + contarNodosConDosHijos(arbol.getHijoDerecho());
		}
		return answer;
	}

}
