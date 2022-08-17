package tp05.ejercicio3;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class BuscadorDeCaminos {
	
	private Grafo<String> bosque; //bosque es un grafo de string
	
	public BuscadorDeCaminos(Grafo<String> unBosque) { //constructor
		this.bosque = unBosque;
	}
	
	public ListaGenerica<String> recorridoMasSeguro(){ // devuelve un listado con los claros que conforman el recorrido encontrado. 
		ListaGenerica<String> lis = new ListaEnlazadaGenerica<String>(); //lista para el camino a retornar
		boolean [] marca = new boolean [bosque.listaDeVertices().tamanio()+1]; //para controlar si el vertice fue visitado
		
		Vertice<String> v;
		
		v = buscarCasaCaperusita(); //busqueda de la casa de caperusita 
		dfs(v.getPosicion(),lis,marca);
		return lis;	
	}
	
	private Boolean dfs(int posV, ListaGenerica<String> lis, boolean[] marca) {
		
		Boolean encontre = false; //para terminar al encontrar un camino 
		marca[posV] = true; //el v se marca como visitado
		Vertice<String> vert = bosque.vetice(posV); //toma el vertice de la lista en la pos correspondiente a posV
		lis.agregarFinal(vert.dato()); //agrego el vertice al camino 
		
		if(vert.dato().equals("Casa Abuelita")) // caso base
			encontre = true; //para dejar de recorrer 
		
		else { 
			ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(vert); //tomo la lista de adyacentes al vertice 
			ady.comenzar(); 
			while(!ady.fin() && !encontre) {
				Arista<String> a = ady.proximo();
				int j = a.verticeDestino().getPosicion(); // j es la pos del ady del vertice 
				if(!marca[j]) //si el ady no está marcado sigo 
					if(a.peso()<5)
						encontre = dfs(j,lis,marca); //llamado recursivo desde el ady j 	
			}
			if (!encontre)
				lis.eliminarEn(lis.tamanio()); //si llegue al fin de un v que no puede conducir al destino lo elimino del camino
		}
		return encontre;	
		
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
