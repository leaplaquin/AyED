package tp05.ejercicio4;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp05.ejercicio3.Arista;
import tp05.ejercicio3.Grafo;
import tp05.ejercicio3.Vertice;

public class Recorridos<T> {
	
	public ListaGenerica<T> dfs(Grafo<T> grafo){
		ListaGenerica<T> resultado = new ListaEnlazadaGenerica<T> (); //lista para retornar el camino de todo el grafo 
		if(!grafo.esVacio()) {
			boolean [] visitados = new boolean [grafo.listaDeVertices().tamanio()+1]; //creo el arreglo de visitados 
			ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices(); //tomo la lista de vertices 
			listaDeVertices.comenzar();
			while(!listaDeVertices.fin()) { //recorro toda la lista de vertices 
				Vertice<T> vInicial = listaDeVertices.proximo();
				if(!visitados[vInicial.getPosicion()]) { //si no esta visitado el vertice, aplico dfs 
					dfs(vInicial,visitados,resultado,grafo);
				}
			}	
		}	
		return resultado;	
	}

	private void dfs(Vertice<T> vActual, boolean[] visitados, ListaGenerica<T> resultado, Grafo<T> grafo) {
		visitados[vActual.getPosicion()] = true; //lo marco como visitado
		resultado.agregarFinal(vActual.dato()); //agrego el v al camino que estoy armando
		ListaGenerica<Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual); //tomo los adyacentes del v actual 
		listaDeAdyacentes.comenzar(); 
		while(!listaDeAdyacentes.fin()) { //recorro todos sus adyacentes 
			Vertice <T> vSiguiente = listaDeAdyacentes.proximo().verticeDestino(); 
			if(!visitados[vSiguiente.getPosicion()]) {
				dfs(vSiguiente, visitados, resultado, grafo);
			}
		}	
	}
	
	public ListaGenerica<T> bfs(Grafo<T> grafo){
		ListaGenerica<T> resultado = new ListaEnlazadaGenerica<T> (); //lista para retornar el camino de todo el grafo 
		if(!grafo.esVacio()) {
			boolean [] visitados = new boolean [grafo.listaDeVertices().tamanio()+1]; //creo el arreglo de visitados 
			ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices(); //tomo la lista de vertices 
			listaDeVertices.comenzar();
			while(!listaDeVertices.fin()) { //recorro toda la lista de vertices 
				Vertice<T> vInicial = listaDeVertices.proximo();
				if(!visitados[vInicial.getPosicion()]) { //si no esta visitado el vertice, aplico dfs 
					bfs(vInicial,visitados,resultado,grafo);
				}
			}	
		}	
		return resultado;	
	}

	private void bfs(Vertice<T> vInicial, boolean[] visitados, ListaGenerica<T> resultado, Grafo<T> grafo) {
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		cola.encolar(vInicial);
		visitados[vInicial.getPosicion()] = true; //lo marco como visitado
		while(!cola.esVacia()) {
			Vertice <T> vActual = cola.desencolar(); //desencolo el v de la cola 
			resultado.agregarFinal(vActual.dato()); //agrego el v al camino que estoy armando
			ListaGenerica<Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual); //tomo los adyacentes del v actual 
			listaDeAdyacentes.comenzar(); 
			while(!listaDeAdyacentes.fin()) { //recorro todos sus adyacentes 
				Vertice <T> vSiguiente = listaDeAdyacentes.proximo().verticeDestino(); //tomo el v adyacente 
				if(!visitados[vSiguiente.getPosicion()]) { //si no esta visitado, lo visito 
					visitados[vSiguiente.getPosicion()] = true; //lo marco como visitado 
					cola.encolar(vSiguiente); //lo encolo 
				}
			}
		}
	}	
	
}

