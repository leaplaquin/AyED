package tp03.ejercicio7;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
	private ArbolGeneral<Double> arbolRed;
	
	public RedDeAguaPotable(ArbolGeneral<Double> unArbol){
		this.arbolRed = unArbol;
	}
	
	public double minimoCaudal(int caudal) {
		return minCaudal(arbolRed,caudal);	
	}

	private double minCaudal(ArbolGeneral<Double> arbol, double caudal) {
		if(arbol.esHoja()) 
			return caudal;
		ListaGenerica<ArbolGeneral<Double>> hijos = arbol.getHijos();
		double min = caudal;
		hijos.comenzar();
		while(!hijos.fin()) {
			ArbolGeneral<Double> hijo = hijos.proximo();
			min = Math.min(min, minCaudal(hijo, caudal/hijos.tamanio()));
		}		
		return min;
	}
}
