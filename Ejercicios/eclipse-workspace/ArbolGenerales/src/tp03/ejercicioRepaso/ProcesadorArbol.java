package tp03.ejercicioRepaso;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolGeneral;

//Mayor cantidad de hijos. Defina dentro de la clase ProcesadorArbol que tiene como variable de instancia un ArbolGeneral de caracteres,
//el método MayorCantidadLetra(Character letra) que tetorna una lista con todos los elementos del nivel con mayor cantidad de ocurrencias
//de la letra recibida como parametro. 

public class ProcesadorArbol {
	private ArbolGeneral<Character> arbol;
	
	public ProcesadorArbol (ArbolGeneral<Character> unArbol){
		this.arbol = unArbol;
	}
	
	public ListaGenerica<Character> mayorCantidadLetra (char letra) {
		return MayorCantidadLetra(letra);
	}

	private ListaGenerica<Character> MayorCantidadLetra(Character letra) {
		ColaGenerica<ArbolGeneral<Character>> cola = new ColaGenerica<ArbolGeneral<Character>>();
		ListaGenerica<Character> nivelAct = new ListaEnlazadaGenerica<Character>();
		ListaGenerica<Character> nivelMaximo = new ListaEnlazadaGenerica<Character>();
		ArbolGeneral<Character> actual;
		int cant = 0; int max = -1;
		cola.encolar(this.arbol);
		cola.encolar(null);
		while (!cola.esVacia()) {
			actual = cola.desencolar();
			if (actual != null) {
				if(actual.getDatoRaiz() == letra) cant++;
				nivelAct.agregarFinal(actual.getDatoRaiz());
				ListaGenerica<ArbolGeneral<Character>> hijos = actual.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else 
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			    if (cant > max) {
			    	max = cant;
			    	nivelMaximo = nivelAct.clonar();
			    }
			    cant = 0;
			    nivelAct = new ListaEnlazadaGenerica<Character>();
		}
		return nivelMaximo;
	}
	

}
