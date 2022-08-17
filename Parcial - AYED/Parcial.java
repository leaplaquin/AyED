package NicolasDeRose;
import tp02.ArbolesBinarios.ArbolBinario;

public class Parcial {
	
	public static int resolver(ArbolBinario<Integer> arbol) {
		int suma = 0; 
		if(arbol.esVacio())
			return 0;
		else
			return resolverRec(arbol,suma);
		
	}

	private static int resolverRec(ArbolBinario<Integer> arbol, int suma) {
		if(arbol.esHoja()) {
			return arbol.getDatoRaiz();
		}
		if(arbol.getDatoRaiz() % 2 == 0) {
			if(!arbol.getHijoDerecho().esVacio()) 
				suma= suma + resolverRec(arbol.getHijoDerecho(),suma);
			else return -1;
		}
		else
			if(!arbol.getHijoIzquierdo().esVacio())
				suma= suma + resolverRec(arbol.getHijoIzquierdo(),suma);
			else return -1;
		return suma + arbol.getDatoRaiz();
				
		}
	}


