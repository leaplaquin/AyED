package tp05.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class BuscadorCaminoMasCorto {
	
	private Grafo<String> bosque; //bosque es un grafo de string
	
	public BuscadorCaminoMasCorto(Grafo<String> unBosque) { //constructor
		this.bosque = unBosque;
	}
	
	public ListaGenerica<String> recorridoMasSeguro(){ 
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>(); //lista para el camino actual
		ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>(); //lista para el camino minimo a devolver  
		boolean [] marca = new boolean [bosque.listaDeVertices().tamanio()+1]; 
		Vertice<String> v = buscarCasaCaperusita(); //busqueda de la casa de caperusita 
		caminoActual.agregarFinal(v.dato());
		marca [v.getPosicion()] = true;
		dfs(v, caminoActual, marca, resultado);
		return resultado;	
	}
	
	private void dfs(Vertice <String> v, ListaGenerica<String> camAct, boolean[] marca, ListaGenerica<String> resultado) {
		
		ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			Arista<String> a = ady.proximo(); 
			Vertice<String> vDest = a.verticeDestino(); //tomo el v ady
			int posDest = vDest.getPosicion();
			if(!marca[posDest] && a.peso() < 5) { //si el ady no esta marcado y el peso de la arista es menor que 5 
				marca[posDest] = true;  //lo visito 
				camAct.agregarFinal(vDest.dato()); //lo agrego al camino actual 
				if((vDest.dato().equals("Casa Abuelita")) && (resultado.esVacia() || (camAct.tamanio()<resultado.tamanio()))){
					resultado.eliminarTodos();
					camAct.comenzar();
					while(!camAct.fin()) {
						resultado.agregarFinal(camAct.proximo()); //copio el camino actual en otra ref de memoria y a esa ref de mem la cargo en resultado 
					}
				}
				else {
					 dfs(vDest, camAct, marca, resultado);
				 }
				 marca[posDest] = false;
				 camAct.eliminarEn(camAct.tamanio());
			}
		}
	}

	private Vertice<String> buscarCasaCaperusita() { 
		
		ListaGenerica<Vertice<String>> vertices = bosque.listaDeVertices();
		Vertice <String> V = null;
		vertices.comenzar();
		while(!vertices.fin()) { //recorre el vector de v hasta encontrar la casa de caperusita 
			V = vertices.proximo();
			if(V.dato().equals("Casa Caperusita"))
			    return V;
		}
		return V;
	}	

}
