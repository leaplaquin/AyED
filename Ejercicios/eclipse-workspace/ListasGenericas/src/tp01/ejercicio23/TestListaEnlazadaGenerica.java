package tp01.ejercicio23;

import ej3.Estudiante;
import tp01.ejercicio2.ListaEnlazadaGenerica;

public class TestListaEnlazadaGenerica {
	
	public static void main (String [] args) {
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
		
		Estudiante E1 = new Estudiante();
		E1.setNombre(new String ("Juan"));
		E1.setApellido(new String ("Gonzalez"));
		E1.setComision(2);
		E1.setEmail(new String ("juangonza@gmail.com"));
		E1.setDireccion(new String ("143 y 28 bis"));
		
		Estudiante E2 = new Estudiante();
		E2.setNombre(new String ("Maria"));
		E2.setApellido(new String ("Elena"));
		E2.setComision(5);
		E2.setEmail(new String ("mariaele@gmail.com"));
		E2.setDireccion(new String ("524 y 38"));
		
		Estudiante E3 = new Estudiante();
		E3.setNombre(new String ("Ariana"));
		E3.setApellido(new String ("Grande"));
		E3.setComision(3);
		E3.setEmail(new String ("arianagrande@gmail.com"));
		E3.setDireccion(new String ("115 Y 27"));
		
		Estudiante E4 = new Estudiante();
		E4.setNombre(new String ("Eduardo"));
		E4.setApellido(new String ("Gomez"));
		E4.setComision(2);
		E4.setEmail(new String ("edugomez@gmail.com"));
		E4.setDireccion(new String ("314 y 81"));
		
		lista.agregarFinal(E1);
		lista.agregarFinal(E2);
		lista.agregarFinal(E3);
		lista.agregarFinal(E4);
		
		System.out.println("cantidad de estudiantes:" + lista.tamanio());
		System.out.println("");
		
		for (int i =1; i <= lista.tamanio();  i++) {
		      System.out.println(lista.elemento(i).tusDatos());
		      System.out.println(" ");
		    }
	}

}
