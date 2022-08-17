package tp02.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp02.ArbolesBinarios.ArbolBinario;

public class ContadorArbol {
	private ArbolBinario<Integer> a;
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.a = arbol;	
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesPostOrden(){ //retorna una lista de enteros 
		ListaEnlazadaGenerica <Integer> l = new ListaEnlazadaGenerica<Integer>(); //creo una instancia de lista 
		postOrden(a,l); //paso a el metodo privado las dos instancias 
		return l; 
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesInOrden(){ 
		ListaEnlazadaGenerica <Integer> l = new ListaEnlazadaGenerica<Integer>(); 
		inOrden(a,l);
		return l; 
	}
	
	private void postOrden(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> lista) { //recibe dos instancias 
		if(!arbol.getHijoIzquierdo().esVacio())
			postOrden(arbol.getHijoIzquierdo(), lista);
		if(!arbol.getHijoDerecho().esVacio())
			postOrden(arbol.getHijoDerecho(), lista);
		if(arbol.getDatoRaiz()%2 == 0) 
			lista.agregarFinal(arbol.getDatoRaiz());
	}
	
	private void inOrden(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> lista) { 
		if(!arbol.getHijoIzquierdo().esVacio())
			inOrden(arbol.getHijoIzquierdo(), lista);
		if(arbol.getDatoRaiz()%2 == 0) 
			lista.agregarFinal(arbol.getDatoRaiz());
		if(!arbol.getHijoDerecho().esVacio())
			inOrden(arbol.getHijoDerecho(), lista);	
	}
}
