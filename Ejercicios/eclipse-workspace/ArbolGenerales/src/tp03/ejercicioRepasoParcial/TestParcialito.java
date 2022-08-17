package tp03.ejercicioRepasoParcial;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolGeneral;

public class TestParcialito {
	public static void main(String[] args) {
		
	ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(1);
	ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(-1);
	ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(3);
	ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
	hijos.agregarFinal(a1);
	hijos.agregarFinal(a2);
	hijos.agregarFinal(a3);
	
	ArbolGeneral<Integer> a = new ArbolGeneral<Integer> (0,hijos);
	System.out.println("Datos del arbol postOrden: " + a.postOrden());
	System.out.println("cantidad: " + Parcialito.resolver(a));

}
	
}