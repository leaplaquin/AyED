package tp03.ejercicioRepaso;
import tp03.ejercicio1.ArbolGeneral;

public class TestContadorArbolGeneral {
	
	public static void main(String[] args) {
		
		 //     A       
        //   /  |  \
       //   Z   S   L
      //   /   / \  |
     //   S   D   A S  
		
		ArbolGeneral<String> arbolA = new ArbolGeneral<String>("A");
		ArbolGeneral<String> arbolZ = new ArbolGeneral<String>("Z");
		ArbolGeneral<String> arbolS = new ArbolGeneral<String>("S");
		ArbolGeneral<String> arbolL = new ArbolGeneral<String>("L");
		ArbolGeneral<String> arbolS1 = new ArbolGeneral<String>("S");
		ArbolGeneral<String> arbolD = new ArbolGeneral<String>("D");
		ArbolGeneral<String> arbolA1 = new ArbolGeneral<String>("A");
		ArbolGeneral<String> arbolS2 = new ArbolGeneral<String>("S");
		
		arbolA.agregarHijo(arbolZ);
		arbolA.agregarHijo(arbolS);
		arbolA.agregarHijo(arbolL);
		arbolZ.agregarHijo(arbolS1);
		arbolS.agregarHijo(arbolD);
		arbolS.agregarHijo(arbolA1);
		arbolL.agregarHijo(arbolS2);
		
		String dato = "S";
		System.out.println("La cantidad de caracteres igual a "  + dato + " es: " 
		              +ContadorArbolGeneral.contarOcurrencias(arbolA, dato) + "\n");
	}

}
