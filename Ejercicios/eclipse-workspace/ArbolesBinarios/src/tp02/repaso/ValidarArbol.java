package tp02.repaso;
//tengo un ab de enteros y tengo que devolver el promedio del arbol. 
//El arbol forma parte de la clase validarArbol,y es su v.i

import tp02.ArbolesBinarios.ArbolBinario;

public class ValidarArbol {
	private ArbolBinario<Integer> arbol;
	
	public ValidarArbol() {
		
	}
	
	public ValidarArbol(ArbolBinario<Integer> unArbol) {
		this.arbol = unArbol;	
	}
	
	public float buscarPromedio() {
		
		if (!this.arbol.esVacio()) {
			Promedio p = new Promedio();
			this.buscarPromedioRecursivo(arbol,p);
			return p.getSuma()/p.getCant();
		}
		else return 0; //si el arbol esta vacio retorna 0
	}
	
	private void buscarPromedioRecursivo(ArbolBinario<Integer> arbol, Promedio prom) {
		
		prom.setSuma(prom.getSuma() + arbol.getDatoRaiz());
		prom.setCant(prom.getCant() + 1);
		
		if(!arbol.getHijoIzquierdo().esVacio())
			this.buscarPromedioRecursivo(arbol.getHijoIzquierdo(), prom);
		
		if(!arbol.getHijoDerecho().esVacio())
			this.buscarPromedioRecursivo(arbol.getHijoDerecho(), prom);
		
	}
}
