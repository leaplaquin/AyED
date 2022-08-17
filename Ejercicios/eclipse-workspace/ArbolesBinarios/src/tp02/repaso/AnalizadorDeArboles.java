package tp02.repaso;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp02.ArbolesBinarios.ArbolBinario;

//Implemente en la clase AnalizadorDeArboles un método que reciba un árbol binario de enteros 
//y retorne una lista que conforme el camino desde la raíz a una hoja cuya suma sea mínima. 
//Si hubiese más de un camino que cumpla con la condición establecida, devuelva uno de ellos. 

public class AnalizadorDeArboles {

	public ListaEnlazadaGenerica<Integer> caminoSumaMin (ArbolBinario<Integer> a){
		ListaEnlazadaGenerica <Integer> camAct = new ListaEnlazadaGenerica <Integer>();
		ListaEnlazadaGenerica <Integer> camARetornar = new ListaEnlazadaGenerica <Integer>();
		int sumaAct = 0;
		int sumaMin = 9999;
		
		if(!a.esVacio()) {
			caminoSumaMinRec(a,camAct,camARetornar,sumaAct,sumaMin);
		}
		return camARetornar;
		
	}

	private static Integer caminoSumaMinRec(ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> camAct, 
			                                                  ListaEnlazadaGenerica<Integer> camARetornar, int sumaAct, int sumaMin) {
		camAct.agregarFinal(a.getDatoRaiz());
		sumaAct = sumaAct + a.getDatoRaiz();
		
		if(a.esHoja()) {
			if(sumaMin<sumaAct) {
				sumaMin = sumaAct;
				camARetornar.eliminarTodos();
				camAct.comenzar();
				while(!camAct.fin()) {
					camARetornar.agregarFinal(camAct.proximo());
				}
				
			}	
		}
		
		else
			if(!a.getHijoIzquierdo().esVacio()) {
				sumaMin = Math.min(caminoSumaMinRec(a.getHijoIzquierdo(),camAct,camARetornar,sumaAct,sumaMin), sumaMin);
				camAct.eliminarEn(camAct.tamanio());
			}
		    
		    if(!a.getHijoDerecho().esVacio()) {
		    	sumaMin = Math.min(caminoSumaMinRec(a.getHijoDerecho(),camAct,camARetornar,sumaAct,sumaMin), sumaMin);
		    	camAct.eliminarEn(camAct.tamanio());
		    }
		    
			return sumaMin;    
	}
}

