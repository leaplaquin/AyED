package tp03.ejercicio1;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);

	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());

		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}

	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));

		}

		return lista;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);

			}
		}

	}

	public Integer altura() {
		int aux = -1;
		if (this.esHoja())
			return 0;
		ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
		lhijos.comenzar();
		while (!lhijos.fin()) {
			aux = Math.max(aux, lhijos.proximo().altura());
		}
		return aux + 1;
	}

	public Integer nivel(T dato) { // devuelve el nivel del dato en el árbol.
		int nivel = 0;
		ArbolGeneral<T> arbol = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.getDatoRaiz() == dato) {
					return nivel;
				}
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else if (!cola.esVacia()) {
				nivel++;
				cola.encolar(null);
			}
		}
		return -1;
	}

	public Integer ancho() { // devuelve la cantidad de nodos que se encuentran en el nivel que posee la
								// mayor cantidad de nodos.
		int total = 0, aux = 0;
		ArbolGeneral<T> arbol = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				aux++;
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else if (!cola.esVacia()) {
				if (aux > total) {
					total = aux;
				}
				aux = 0;
				cola.encolar(null);
			}
		}
		return total;
	}

	public Boolean esHoja() {
		return this.getHijos().esVacia(); // es hoja si la lista de hijos esta vacia
	}

	public Boolean esVacio() {
		return (this.getRaiz() == null); // si la raiz es null devuelve true
	}

	public ListaEnlazadaGenerica<T> preOrden() {
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		this.preOrden(lis);
		return lis;
	}

	private void preOrden(ListaGenerica<T> l) { // raiz - izquierdo - derecho
		l.agregarFinal(this.getDatoRaiz());
		ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
		lhijos.comenzar();
		while (!lhijos.fin()) {
			(lhijos.proximo()).preOrden(l);
		}
	}

	public ListaEnlazadaGenerica<T> postOrden() {
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		this.postOrden(lis);
		return lis;
	}

	private void postOrden(ListaGenerica<T> l) { // izquierdo - derecho - raiz
		ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
		lhijos.comenzar();
		while (!lhijos.fin()) {
			(lhijos.proximo()).postOrden(l);
		}
		l.agregarFinal(this.getDatoRaiz());
	}

	public ListaEnlazadaGenerica<T> inOrden() { // izquierdo - raiz - derecho
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		this.inOrden(lis);
		return lis;
	}

	private void inOrden(ListaGenerica<T> l) {
		ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
		lhijos.comenzar();
		if (!lhijos.fin())
			lhijos.proximo().inOrden(l);
		l.agregarFinal(this.getDatoRaiz());
		while (!lhijos.fin())
			lhijos.proximo().inOrden(l);
	}

	public ListaEnlazadaGenerica<T> recorridoPorNiveles() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		ArbolGeneral<T> arbol = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				lista.agregarFinal(arbol.getDatoRaiz());
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
			}
		}
		return lista;
	}
	

}
