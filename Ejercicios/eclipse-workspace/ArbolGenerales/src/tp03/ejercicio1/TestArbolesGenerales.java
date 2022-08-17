package tp03.ejercicio1;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class TestArbolesGenerales {
	public static void main(String[] args) {
		
		ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
		ArbolGeneral<String> a2 = new ArbolGeneral<String>("2");
		ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");
		ListaGenerica<ArbolGeneral<String>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		hijos.agregarFinal(a1);
		hijos.agregarFinal(a2);
		hijos.agregarFinal(a3);
		
		ArbolGeneral<String> a = new ArbolGeneral<String> ("0",hijos);
		System.out.println("Datos del arbol preOrden: " + a.preOrden());
		System.out.println("Datos del arbol postOrden: " + a.postOrden());
		System.out.println("Datos del arbol inOrden: " + a.inOrden());
		
		
	}

}
