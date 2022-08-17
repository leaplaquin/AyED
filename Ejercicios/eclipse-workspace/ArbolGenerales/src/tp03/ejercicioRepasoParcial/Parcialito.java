package tp03.ejercicioRepasoParcial;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolGeneral;

public class Parcialito {
	
	public static Integer resolver(ArbolGeneral<Integer> arbol) {
		int cant = 0;
		if(!arbol.esVacio()) {
			Contador c = new Contador();
			resolverRec(arbol,c);
			if(c.getCantPositivos() % 2 == 0)
				cant = c.totalNodos();
			else
				cant = c.getCantNegativos();
			
		}
		return cant;
	}

	private static void resolverRec (ArbolGeneral<Integer> arbol, Contador c) { // izquierdo - derecho - raiz
		ListaGenerica<ArbolGeneral<Integer>> lhijos = arbol.getHijos();
		lhijos.comenzar();
		while (!lhijos.fin()) {
			resolverRec(lhijos.proximo(),c);
		}
		if(arbol.getDatoRaiz() >= 0) 
			c.setCantPositivos(c.getCantPositivos()+1);
		else
			c.setCantNegativos(c.getCantNegativos()+1);
	}
	
	
	
	public static Integer resolver2(ArbolGeneral<Integer> arbol) {
		Contador c = new Contador();
		if(!arbol.esVacio()) {
			resolverRec2(arbol,c);
		}
		return c.resultado();
	}
	
	private static void resolverRec2 (ArbolGeneral<Integer> arbol, Contador c) { // izquierdo - derecho - raiz
		ListaGenerica<ArbolGeneral<Integer>> lhijos = arbol.getHijos();
		lhijos.comenzar();
		while (!lhijos.fin()) {
			resolverRec(lhijos.proximo(),c);
		}
		c.evaluar(arbol.getDatoRaiz());
	}
	
	public static Integer resolver3(ArbolGeneral<Integer> arbol) {
		ListaGenerica<Integer> positivos = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> negativos = new ListaEnlazadaGenerica<Integer>();
		if(!arbol.esVacio()) {
			resolverRec3(arbol,positivos,negativos);
		}
		if(positivos.tamanio() % 2 == 0) //si la cant de nodos pos es mayor que 0 
			return positivos.tamanio() + negativos.tamanio(); //total de nodos pos + total de nodos neg
		else
			return negativos.tamanio();
	}

	private static void resolverRec3(ArbolGeneral<Integer> arbol, ListaGenerica<Integer> positivos, ListaGenerica<Integer> negativos) {
		ListaGenerica <ArbolGeneral<Integer>> hijos = arbol.getHijos();
		hijos.comenzar();
		while(!hijos.fin()) {
			resolverRec3(arbol,positivos,negativos);
		}
		
		if(arbol.getDatoRaiz() >= 0) 
			positivos.agregarFinal(arbol.getDatoRaiz());
		else
			negativos.agregarFinal(arbol.getDatoRaiz());
	}
		
}


