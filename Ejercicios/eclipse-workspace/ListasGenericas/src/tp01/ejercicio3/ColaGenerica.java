package tp01.ejercicio3;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class ColaGenerica <T>{
	
	private ListaGenerica <T> datos;
	
	public ColaGenerica() {
		datos = new ListaEnlazadaGenerica<T>(); 
	}
	
	public void encolar (T elem) {
		datos.agregarFinal(elem);
	}
	
	public T desencolar() {
		if(!this.esVacia()) {
			T tmp = datos.elemento(1);
			datos.eliminarEn(1);
		    return tmp; 
		}
		return null; 
	}
	
	public T tope() {
		return datos.elemento(1);
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
	
	


}
