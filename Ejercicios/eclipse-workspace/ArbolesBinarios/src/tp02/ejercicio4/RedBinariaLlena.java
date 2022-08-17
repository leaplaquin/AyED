package tp02.ejercicio4;

import tp02.ArbolesBinarios.ArbolBinario;

public class RedBinariaLlena {
	
	public int retardoReenvio(ArbolBinario<Integer> arbol) {
		if(arbol.esHoja()) {
			return arbol.getDatoRaiz(); //retorno el dato de la hoja 
		}
		return Math.max(retardoReenvio(arbol.getHijoIzquierdo()), retardoReenvio(arbol.getHijoDerecho())) + arbol.getDatoRaiz(); //retorno el max de los hijos + miValor 
	}

}
