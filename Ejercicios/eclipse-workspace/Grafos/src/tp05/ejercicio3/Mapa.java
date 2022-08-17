package tp05.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class Mapa {
	
	private Grafo <String> mapaCiudades; //bosque es un grafo de string
	
	public Mapa (Grafo<String> unMapa) { //constructor
		this.mapaCiudades = unMapa;
	}
	
	public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2){ // devuelve un listado con las ciudades que conforman el recorrido encontrado. 
		ListaGenerica<String> lis = new ListaEnlazadaGenerica<String>(); //lista para el camino a retornar
		boolean [] marca = new boolean [mapaCiudades.listaDeVertices().tamanio()+1]; //para controlar si el vertice fue visitado
		
		Vertice<String> vInicio = buscarCiudad(ciudad1); //busca la ciudad inicio 1
		devolverCaminoPrivado(vInicio.getPosicion(),lis,marca,ciudad2);
		return lis;	
	}
	
	private Boolean devolverCaminoPrivado(int posV, ListaGenerica<String> lis, boolean[] marca, String ciudad2) {
		
		Boolean encontre = false; //para terminar al encontrar un camino 
		marca[posV] = true; //el v se marca como visitado
		Vertice<String> vert = mapaCiudades.vetice(posV); //toma el vertice de la lista en la pos correspondiente a posV
		lis.agregarFinal(vert.dato()); //agrego el vertice al camino 
		
		if(vert.dato().equals(ciudad2)) // caso base
			encontre = true; //para dejar de recorrer 
		
		else { 
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vert); //tomo la lista de adyacentes al vertice 
			ady.comenzar(); 
			while(!ady.fin() && !encontre) {
				Arista<String> a = ady.proximo();
				int j = a.verticeDestino().getPosicion(); // j es la pos del ady del vertice 
				if(!marca[j]) //si el ady no está marcado sigo 
						encontre = devolverCaminoPrivado(j,lis,marca,ciudad2); //llamado recursivo desde el ady j 	
			}
			if (!encontre)
				lis.eliminarEn(lis.tamanio()); //si llegue al fin de un v que no puede conducir al destino lo elimino del camino
		}
		return encontre;	
		
	}
	
	public ListaGenerica<String> devolverCaminoExceptuado (String ciudad1, String ciudad2, ListaGenerica<String> ciudades){ // devuelve un listado con las ciudades que conforman el recorrido encontrado. 
		ListaGenerica<String> listaCiudades = new ListaEnlazadaGenerica<String>(); //lista para el camino a retornar
		boolean [] marca = new boolean [mapaCiudades.listaDeVertices().tamanio()+1]; //para controlar si el vertice fue visitado
		
		Vertice<String> vInicio = buscarCiudad(ciudad1);
		devolverCaminoExceptuadoPrivado(vInicio.getPosicion(),listaCiudades,marca,ciudades,ciudad2);
		return listaCiudades;	
	}
	
	
	private Boolean devolverCaminoExceptuadoPrivado(int posV, ListaGenerica<String> camino, boolean[] marca, 
			                                         ListaGenerica<String> ciudades, String ciudad2 ) {
		
		Boolean encontre = false; //para terminar al encontrar un camino 
		
		Vertice<String> vert = mapaCiudades.vetice(posV); //toma el vertice de la lista en la pos correspondiente a posV
		
		marca[posV] = true; 
		camino.agregarFinal(vert.dato()); 
		
		if(vert.dato().equals(ciudad2)) // caso base
			encontre = true; 
		
		else { 
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vert); //tomo la lista de adyacentes al vertice 
			ady.comenzar(); 
			while(!ady.fin() && !encontre) {
				Arista<String> a = ady.proximo();
				int j = a.verticeDestino().getPosicion(); 
				if((!marca[j]) && (!ciudades.incluye(a.verticeDestino().dato())))
						encontre = devolverCaminoExceptuadoPrivado (j,camino,marca,ciudades,ciudad2); //llamado recursivo desde el ady j 	
			}
			if (!encontre)
				camino.eliminarEn(camino.tamanio()); //si llegue al fin de un v que no puede conducir al destino lo elimino del camino
		}
		return encontre;	
		
	}
	

	public ListaGenerica<String> caminoMasCorto (String ciudad1, String ciudad2){ 
		
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();  
	    AyudanteMapa ayudante = new AyudanteMapa();
		boolean [] marca = new boolean [mapaCiudades.listaDeVertices().tamanio()+1]; 
		Integer longCaminoActual = 0;
		Vertice<String> vInicio = buscarCiudad(ciudad1); 
		caminoMasCortoPrivado(vInicio, ciudad2, caminoActual, ayudante, marca, longCaminoActual);
		return ayudante.getCamino();	
	}
	
		
		private void caminoMasCortoPrivado( Vertice<String> ciudadActual, String ciudadDestino, ListaGenerica<String> caminoActual,
				                            AyudanteMapa ayudante,  boolean[] visitados, Integer longCaminoActual) {
			
			visitados[ciudadActual.getPosicion()] = true; //el v se marca como visitado
			caminoActual.agregarFinal(ciudadActual.dato()); //agrego el vertice al camino 
			
			if(ciudadActual.dato().equals(ciudadDestino)) { //caso base 
				if( longCaminoActual < ayudante.getLongCamino()) { //comparo la suma de todas las aristas de mi camino actual con la suma de todas las aristas del ultimo camino
					ayudante.actualizar(caminoActual, longCaminoActual); //actualizo caminoMin con camActual y su longitud 
				}
			}
			
			else { //caso general 
				ListaGenerica<Arista<String>> rutas = mapaCiudades.listaDeAdyacentes(ciudadActual); //tomo la lista de adyacentes al vertice 
				Arista <String> rutaActual; //declaro la arista 
				Vertice<String> ciudadSiguiente;
				
				rutas.comenzar(); 
				while(!rutas.fin()) {
					rutaActual = rutas.proximo(); //tomo la arista 
				    ciudadSiguiente = rutaActual.verticeDestino(); //tomo el proximo v 
				    
				    Integer longConCiudadSiguiente = longCaminoActual + rutaActual.peso(); //long del camino actual, el total de los pesos de todo lo que recorri + el peso de la arista que pienso recorrer 
				    
				    if (!visitados[ciudadSiguiente.getPosicion()] && longConCiudadSiguiente < ayudante.getLongCamino()) {
				        caminoMasCortoPrivado(ciudadSiguiente, ciudadDestino, caminoActual, ayudante, visitados, longConCiudadSiguiente); //llamado recursivo desde el ady  	
				    }
				}
			}	
		    visitados [ciudadActual.getPosicion()] = false;
			caminoActual.eliminarEn(caminoActual.tamanio()); //si llegue al fin de un v que no puede conducir al destino lo elimino del camino
		}
	
	
		
		private Vertice<String> buscarCiudad(String ciudad1) { 
			ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		    Vertice <String> V = null;
		    vertices.comenzar();
		    while(!vertices.fin()) { 
		    	V = vertices.proximo();
			    if(V.dato().equals(ciudad1))
			    	return V;
			}
		    return V;
		}

}
