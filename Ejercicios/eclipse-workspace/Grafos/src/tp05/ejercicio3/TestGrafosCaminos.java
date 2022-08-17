package tp05.ejercicio3;

import tp01.ejercicio2.ListaGenerica;

public class TestGrafosCaminos {
	
	public static void main(String[] args) {
		
		Grafo<String> grafo = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy <String> vertCap = new VerticeImplListAdy <String> ("Casa Caperusita");
		VerticeImplListAdy <String> vertAbu = new VerticeImplListAdy <String> ("Casa Abuelita");
		VerticeImplListAdy <String> vert1 = new VerticeImplListAdy <String> ("Claro 1");
		VerticeImplListAdy <String> vert2 = new VerticeImplListAdy <String> ("Claro 2");
		VerticeImplListAdy <String> vert3 = new VerticeImplListAdy <String> ("Claro 3");
		VerticeImplListAdy <String> vert4 = new VerticeImplListAdy <String> ("Claro 4");
		VerticeImplListAdy <String> vert5 = new VerticeImplListAdy <String> ("Claro 5");
		
		grafo.agregarVertice(vertCap);
		grafo.agregarVertice(vertAbu);
		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.agregarVertice(vert3);
		grafo.agregarVertice(vert4);
		grafo.agregarVertice(vert5);
		
		grafo.conectar(vertCap, vert1,3);
		grafo.conectar(vert1, vertCap,3);
		
		grafo.conectar(vertCap, vert2,4);
		grafo.conectar(vert2, vertCap,4);
		
		grafo.conectar(vertCap, vert3,4);
		grafo.conectar(vert3, vertCap,4);
		
		grafo.conectar(vert1, vert2,4);
		grafo.conectar(vert2, vert1,4);
		
		grafo.conectar(vert1, vert5,3);
		grafo.conectar(vert5, vert1,3);
		
		grafo.conectar(vert2, vert5,11);
		grafo.conectar(vert5, vert2,11);
		
		grafo.conectar(vert2, vert4,10);
		grafo.conectar(vert4, vert2,10);
		
		grafo.conectar(vert3, vert5,15);
		grafo.conectar(vert5, vert3,15);
		
		grafo.conectar(vert4, vertAbu,9);
		grafo.conectar(vertAbu, vert4,9);
		
		grafo.conectar(vert5, vertAbu,4);
		grafo.conectar(vertAbu, vert5,4);
		
		BuscadorTodosLosCaminos b = new BuscadorTodosLosCaminos (grafo);
		ListaGenerica<ListaGenerica<String>> lista = b.recorridosMasSeguros();
		
		System.out.print("Todos los caminos son: ");
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo()+ " ");
		}
	}
	
}
