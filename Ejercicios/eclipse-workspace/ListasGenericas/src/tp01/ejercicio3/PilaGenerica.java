package tp01.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
	private ListaGenerica <T> datos;
	
	public PilaGenerica() {
		datos = new ListaEnlazadaGenerica<T>(); 
	}
	
	public void apilar(T elem) {
		datos.agregarInicio(elem);
	}
	
	public T desapilar() {
		if(!datos.esVacia()) {
			T tmp = datos.elemento(0);
			
			datos.eliminarEn(0);	
			
			return tmp; 
		}
		return null;
	}
	
	public T tope() {
		return datos.elemento(0);
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
}
