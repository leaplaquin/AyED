package tp05.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class BuscadorTodosLosCaminos {
	
	private Grafo<String> bosque; //bosque es un grafo de string
	
	public BuscadorTodosLosCaminos(Grafo<String> unBosque) { //constructor
		this.bosque = unBosque;
	}
	
	public ListaGenerica<ListaGenerica<String>> recorridosMasSeguros(){ // devuelve un listado con todos los caminos posibles 
		ListaGenerica<ListaGenerica<String>> resultado = new ListaEnlazadaGenerica<ListaGenerica<String>>(); //lista con las listas de caminos a retornar 
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>(); //para el camino que estoy recorriendo actualmente 
		boolean [] marca = new boolean [bosque.listaDeVertices().tamanio()+1]; 
		
		Vertice<String> v = buscarCasaCaperusita(); //busqueda de la casa de caperusita 
		caminoActual.agregarFinal(v.dato());
		marca[v.getPosicion()] = true;
		dfs(v,caminoActual,marca,resultado);
		return resultado;	
	}
	
	private void dfs(Vertice<String> v, ListaGenerica<String> caminoActual, boolean[] marca, 
			             ListaGenerica<ListaGenerica<String>> resultado) {
		
		 ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(v); //tomo la lista de adyacentes del v actual
		 ady.comenzar();
		 while(!ady.fin()) {
			 Arista<String> a = ady.proximo(); 
			 Vertice<String> vDest = a.verticeDestino(); //tomo el v ady
			 int posDest = vDest.getPosicion();
			 if(!marca[posDest] && a.peso() < 5) { //si el ady no esta marcado y el peso de la arista es menor que 5 
				 marca[posDest] = true;  //lo visito 
				 caminoActual.agregarFinal(vDest.dato()); //lo agrego al camino actual 
				 if(vDest.dato().equals("Casa Abuelita")){
						 resultado.agregarFinal(caminoActual.clonar()); //copio el camino actual en otra ref de memoria y a esa ref de mem la cargo en resultado 
				 }
				 else {
					 dfs(vDest, caminoActual, marca, resultado);
				 }
				 marca[posDest] = false;
				 caminoActual.eliminarEn(caminoActual.tamanio());
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

