package tp03.ejercicioRepaso;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolGeneral;

//Escribir el metodo frontera de un arbol general de numeros enteros.
//Debe devolver una lista. La frontera de un arbol son todas las hojas de izquierda a derecha

public class LaFrontera {
	private ArbolGeneral<Integer> arbol;
	
	public ListaEnlazadaGenerica<Integer> frontera() {
		ListaEnlazadaGenerica<Integer> listaFrontera = new ListaEnlazadaGenerica<Integer>();
		if((this.arbol != null) && !arbol.esVacio())
			this.fronteraRecursiva(listaFrontera,arbol);
		return listaFrontera;
	}

	private void fronteraRecursiva (ListaGenerica<Integer> lis,  ArbolGeneral<Integer> arbol) {
		if(arbol.esHoja())
			lis.agregarFinal(arbol.getDatoRaiz());
		else {
			ListaGenerica<ArbolGeneral<Integer>> lhijos = arbol.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin()) {
				fronteraRecursiva(lis,lhijos.proximo());
			}
		}
	}

}