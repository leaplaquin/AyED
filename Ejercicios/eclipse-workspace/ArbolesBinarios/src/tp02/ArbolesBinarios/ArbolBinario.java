package tp02.ArbolesBinarios;

import tp01.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;

	public ArbolBinario(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinario(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho() {
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}

	public void eliminarHijoIzquierdo() {
		this.raiz.setHijoIzquierdo(null);
	}

	public void eliminarHijoDerecho() {
		this.raiz.setHijoDerecho(null);
	}

	public boolean esVacio() {
		return this.getDatoRaiz() == null;
	}

	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	
	
	public int contarHojas() {
		if(this.esVacio()) {
			return 0; 
		}
		else {
			if(this.esHoja()) {
				return 1;
			}
			else {
				return this.getHijoIzquierdo().contarHojas() + this.getHijoDerecho().contarHojas();
			}
		}	
	}
	
	public ArbolBinario<T> espejo(){
		ArbolBinario<T> a = new ArbolBinario<T>(this.getDatoRaiz());
		if(this.esHoja()) {
			return a;
		}
		else {
			if(!this.getHijoIzquierdo().esVacio()) 
				a.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			if(!this.getHijoDerecho().esVacio())
				a.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		}
		return a; 		
	}
		
	
	
	
	public void recorridoPorNiveles() {
		
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>(); //instancio la cola de tipo ArbolBinario
		
		if(!this.esVacio()) {
			
			cola.encolar(this); //encolo el arbol en la cola
		    cola.encolar(null); //encolo el null que sirve para indicar el salto de linea
		    
		    while (!cola.esVacia()) {
		    	
		    	ArbolBinario<T> arbol = cola.desencolar(); //a arbol le asigno lo que esta en el tope de la cola
		    	
		    	if (arbol != null) {
		    		System.out.print(arbol.getDatoRaiz()+ " ");
		    		
		    		if (!arbol.getHijoIzquierdo().esVacio()) 
		    			cola.encolar(arbol.getHijoIzquierdo());
		    		if (!arbol.getHijoDerecho().esVacio())
		    			cola.encolar(arbol.getHijoDerecho());	
		    	}
		    	else 
		    		if (!cola.esVacia()) {
		    			cola.encolar(null);
		    			System.out.println(); //cambio de nivel
		    		}
			}
	    }
    }
	
	public Boolean esArbolPar() {
		
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>(); //instancio la cola de tipo ArbolBinario
		
		int sumaNivel = 0; 
		boolean esPar = true;
		
		cola.encolar(this); //encolo el arbol en la cola
		cola.encolar(null); //encolo el null que sirve para indicar el salto de linea
		   
		while (!cola.esVacia() && esPar) {
			
			ArbolBinario<T> arbol = cola.desencolar(); //a arbol le asigno lo que esta en el tope de la cola
		    if (arbol != null) {
		    	sumaNivel+= (Integer)arbol.getDatoRaiz();
		    	if (!arbol.getHijoIzquierdo().esVacio()) 
		    		cola.encolar(arbol.getHijoIzquierdo());
		    	if (!arbol.getHijoDerecho().esVacio())
		    		cola.encolar(arbol.getHijoDerecho());	
		    }
		    else { //cambie de nivel 
		    		
		    	if(sumaNivel%2 != 0) 
		    		esPar = false; // el arbol no es par, corto el while 
		    	if (!cola.esVacia()) {
		    		cola.encolar(null);
		    		sumaNivel = 0;}
		    }
		}
		return esPar;
	}
	
	
	public void entreNiveles(int n, int m) {
		
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>(); //instancio la cola de tipo ArbolBinario
		int nivelAct = 0; //llevo un contador del nivel actual 
		
		if(!this.esVacio()) {
			cola.encolar(this);
			cola.encolar(null); 
		    
		    while (!cola.esVacia()) {
		    	ArbolBinario<T> a = cola.desencolar(); //a "a" le asigno lo que esta en el tope de la cola
		    	if (a != null) {
		    		if (!a.getHijoIzquierdo().esVacio()) 
		    			cola.encolar(a.getHijoIzquierdo());
		    		if (!a.getHijoDerecho().esVacio())
		    			cola.encolar(a.getHijoDerecho());	
		    		if((nivelAct>=n && nivelAct <=m)) //si el nivel en el que está mi nodo está dentro del rango, imprimo su dato
		    			System.out.print(a.getDatoRaiz()+ " ");
		    	}
		    	else {
		    		System.out.println(); //cambio de nivel
		    	    nivelAct++; //paso al siguiente nivel
		    		if (!cola.esVacia()) 
		    			cola.encolar(null);
		    	}
		    		
			}
	    }
    }
	
	public Boolean lleno() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>(); //instancio la cola de tipo ArbolBinario
		
		cola.encolar(this); 
		cola.encolar(null); 
		int cant_nodos = 0;
		boolean esLleno = true;
		int nivel = 1;
		   
		while (!cola.esVacia() && esLleno) {
			
		    arbol = cola.desencolar(); //a arbol le asigno lo que esta en el tope de la cola
		    if (arbol != null) {
		    	if (!arbol.getHijoIzquierdo().esVacio()) {
		    		cola.encolar(arbol.getHijoIzquierdo());
		    	    cant_nodos++;
		    	}
		    	if (!arbol.getHijoDerecho().esVacio()) {
		    		cola.encolar(arbol.getHijoDerecho());
		    	    cant_nodos++;
		    	}
		    }
		    else 
		    	if (!cola.esVacia()) {
		    		
		    		if(cant_nodos == Math.pow(2, nivel)) { //despues de evaluar si cant nodos = 2^nivel, inc el nivel 
		    			nivel++;
		    			cola.encolar(null); //marca que se paso a otro nivel 
		    			cant_nodos = 0;}
		    		else esLleno = false; 
		        }
		}
		return esLleno;
	}
	
	public void printPreorden() {
		System.out.println(this.getDatoRaiz());
		if (!this.getHijoIzquierdo().esVacio()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (!this.getHijoDerecho().esVacio()) {
			this.getHijoDerecho().printPreorden();
		}
	}
		
}
	