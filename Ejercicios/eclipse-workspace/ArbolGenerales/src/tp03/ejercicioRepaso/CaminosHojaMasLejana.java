package tp03.ejercicioRepaso;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolGeneral;

public class CaminosHojaMasLejana {

	//encontrar el camino a la hoja mas lejana. Si hay mas de una, devolver el primer camino
	
	public static ListaGenerica<Integer> caminoAHojaMasLejana(ArbolGeneral<Integer> a){
		ListaGenerica <Integer> camAct = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica <Integer> camMasLargo = new ListaEnlazadaGenerica<Integer>();
		if(!a.esVacio())
			caminoAHojaMasLejanoRec(a,camAct,camMasLargo);
		return camMasLargo;	
	}

	private static void caminoAHojaMasLejanoRec(ArbolGeneral<Integer> a, ListaGenerica<Integer> camAct,
			                                                           ListaGenerica<Integer> camMasLargo) {	
		camAct.agregarFinal(a.getDatoRaiz());
		
		if(a.esHoja()) {
			if(camAct.tamanio() > camMasLargo.tamanio()) {
				camMasLargo.eliminarTodos();
				camAct.comenzar();
				while(!camAct.fin()) {
					camMasLargo.agregarFinal(camAct.proximo());
				}
			}		
		}
		else {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				caminoAHojaMasLejanoRec(hijos.proximo(),camAct,camMasLargo);
				camAct.eliminarEn(camAct.tamanio());
			}
		}
	}

}
