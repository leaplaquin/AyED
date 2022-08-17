package tp05.ejercicio3;
import tp01.ejercicio2.ListaGenerica;

public class CaminoCiudades<T> {
	
	private void dfsCamino (Grafo<String> mapaCiudades, Vertice<String> vIni, Vertice<String> vFin,
			               ListaGenerica<String> caminoActual, ListaGenerica<String> camino, boolean[] visitados) {
		
		caminoActual.agregarFinal(vIni.dato());
		visitados[vIni.getPosicion()] = true;
		if(vIni == vFin) { //si llegue al destino 
			if(camino.esVacia() || camino.tamanio() > caminoActual.tamanio()) //si el camino que encontre es mayor al camino actual, reemplazo
				copiarLista(caminoActual, camino);
		}
		else {
			 ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vIni);
			 ady.comenzar();
			 while(!ady.fin()) {
				 Vertice <String> vAux = ady.proximo().verticeDestino();
				 if(!visitados[vAux.getPosicion()]) { //para cada ady si no está visitado llama recursivamente a dfs
					 dfsCamino(mapaCiudades,vAux,vFin,caminoActual,camino,visitados);
				 }
					 
			 }
		}
		
		caminoActual.eliminarEn(caminoActual.tamanio()); 
		visitados[vIni.getPosicion()] = false; //desmarca el v visitado 
	}

	private void copiarLista(ListaGenerica<String> caminoActual, ListaGenerica<String> camino) {
		while (!camino.esVacia())
			camino.eliminarEn(1);
		caminoActual.comenzar();
		while (!caminoActual.fin()) {
			camino.agregarFinal(caminoActual.proximo());
		}
		
	}
		
		
	

}
