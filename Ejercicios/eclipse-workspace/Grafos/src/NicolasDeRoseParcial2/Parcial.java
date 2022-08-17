package NicolasDeRoseParcial2;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp05.ejercicio3.Arista;
import tp05.ejercicio3.Grafo;
import tp05.ejercicio3.Vertice;

public class Parcial {
	

	
	public ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> ciudades, String ciudad1, String ciudad2, ListaGenerica<String> Prohibidos){ // devuelve un listado con todos los caminos posibles 
		ListaGenerica<ListaGenerica<String>> resultado = new ListaEnlazadaGenerica<ListaGenerica<String>>(); //lista con las listas de caminos posibles 
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>(); //para el camino que estoy recorriendo actualmente 
		boolean [] marca = new boolean [ciudades.listaDeVertices().tamanio()+1];
		
		Vertice<String> vInicio = buscarCiudadOrigen(ciudades,ciudad1); //busqueda de la ciudad Origen 
		Vertice<String> vFin = buscarCiudadDestino(ciudades,ciudad2); //busqueda de la ciudad Destino
		caminoActual.agregarFinal(vInicio.dato());
		marca[vInicio.getPosicion()] = true;
		Prohibidos.comenzar();
		while (!Prohibidos.fin()) { 
		    String ciudadx = Prohibidos.proximo(); //pido el proximo v de la lista con ciudades prohibidas 
		    Vertice<String> vertice = buscarVertice(ciudades, ciudadx); //busco la ciudadX en el grafo
		    marca[vertice.getPosicion()] = true; // marco como visitada a la ciudadX
		  }
		
		resolverPrivado(vInicio,vFin,caminoActual,marca,resultado,ciudades);
		return resultado;	
	}
	
	private void resolverPrivado(Vertice<String> vInicio, Vertice<String> vFin, ListaGenerica<String> caminoActual, boolean[] marca, 
			             ListaGenerica<ListaGenerica<String>> resultado, Grafo <String> ciudades) {
		
		 ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vInicio); //tomo la lista de adyacentes del v actual
		 ady.comenzar();
		 while(!ady.fin()) {
			 Arista<String> a = ady.proximo(); 
			 Vertice<String> vDest = a.verticeDestino(); //tomo el v ady
			 int posDest = vDest.getPosicion();
			 if(!marca[posDest]) { //me fijo si el ady no esta marcado 
				 marca[posDest] = true;  //lo visito 
				 caminoActual.agregarFinal(vDest.dato()); //lo agrego al camino actual 
				 if(vDest.dato().equals(vFin.dato())){
						 resultado.agregarFinal(caminoActual.clonar()); //copio el camino actual que me lleva al destino a la lista de caminos resultado 
				 }
				 else {
					 resolverPrivado(vDest, vFin, caminoActual, marca, resultado, ciudades); //lamado recursivo con el ady 
				 }
				 marca[posDest] = false; 
				 caminoActual.eliminarEn(caminoActual.tamanio());
			 }
		 }		 			
	}
	
	private Vertice<String> buscarCiudadOrigen(Grafo <String> ciudades, String ciudad1) { //busca la ciudad Origen en el grafo 
		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
	    Vertice <String> V = null;
	    vertices.comenzar();
	    while(!vertices.fin()) { 
	    	V = vertices.proximo();
		    if(V.dato().equals(ciudad1))
		    	return V;
		}
	    return V;
	}
	
	private Vertice<String> buscarCiudadDestino(Grafo <String> ciudades, String ciudad2) { //busca la ciudad Destino en el grafo  
		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
	    Vertice <String> V = null;
	    vertices.comenzar();
	    while(!vertices.fin()) { 
	    	V = vertices.proximo();
		    if(V.dato().equals(ciudad2))
		    	return V;
		}
	    return V;
	}
	
	private Vertice<String> buscarVertice(Grafo <String> ciudades, String ciudadX) { 
		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
	    Vertice <String> V = null;
	    vertices.comenzar();
	    while(!vertices.fin()) { 
	    	V = vertices.proximo();
		    if(V.dato().equals(ciudadX))
		    	return V;
		}
	    return V;
	}


}
