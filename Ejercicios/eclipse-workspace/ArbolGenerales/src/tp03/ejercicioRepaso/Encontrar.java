package tp03.ejercicioRepaso;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolGeneral;

public class Encontrar {
	
	public void encontrarPrincesa(ArbolGeneral<Personaje> arbol ) {
		ListaGenerica<Personaje> lista = new ListaEnlazadaGenerica<Personaje>();
		lista.agregarInicio(arbol.getDatoRaiz());
		ListaGenerica<Personaje> camino = new ListaEnlazadaGenerica<Personaje>();
		encontrarPrincesa(arbol,lista,camino);
		System.out.println("Se encontro la princesa en el camino: " + camino);
	}

	private void encontrarPrincesa(ArbolGeneral<Personaje> arbol, ListaGenerica<Personaje> lista, ListaGenerica<Personaje> camino) {
		Personaje P = arbol.getDatoRaiz();
		if (P.esPrincesa()) {
			clonar(lista,camino);
		}
		if (camino.esVacia()) {
			ListaGenerica<ArbolGeneral<Personaje>> lHijos = arbol.getHijos();
			lHijos.comenzar();
			while(lHijos.fin() && camino.esVacia()) {
				ArbolGeneral<Personaje> aux = lHijos.proximo();
				if(!aux.getDatoRaiz().esDragon()) {
					lista.agregarFinal(aux.getDatoRaiz());
					encontrarPrincesa(aux,lista,camino);
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
			
	}
	
	public void clonar (ListaGenerica<Personaje> origen, ListaGenerica<Personaje> destino) {
		origen.comenzar();
		while(!origen.fin()) {
			destino.agregarFinal(origen.proximo());
		}
	}

}
