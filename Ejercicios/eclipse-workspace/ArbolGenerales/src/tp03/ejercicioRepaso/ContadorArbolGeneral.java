package tp03.ejercicioRepaso;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolGeneral;

public class ContadorArbolGeneral{
	
	/*La cantidad de las ocurrencias del arbol es:
	  La cantidad de ocurrencias del hijo izquierdo
	   +
	  1 (si la raiz = dato)
	   +
	  La cantidad de ocurrencias de los hijos restantes*/
	
	public static Integer contarOcurrencias(ArbolGeneral<String> a, String dato) {
		Integer cantVeces = 0;
		ListaGenerica<ArbolGeneral<String>> hijos = a.getHijos(); //lista de hijos
		
		if(!hijos.esVacia()){ //es lo mismo que preguntar si es hoja, si la lista de mi hijos es vacia = no tiene hijos 
			hijos.comenzar();
			cantVeces = cantVeces + contarOcurrencias(hijos.proximo(),dato);} 
		
		if(a.getDatoRaiz().equals(dato))
			cantVeces++;
		
		while(!hijos.fin()) 
			cantVeces = cantVeces + contarOcurrencias(hijos.proximo(),dato);
		
		return cantVeces;	
	}
	
	
	
	
}