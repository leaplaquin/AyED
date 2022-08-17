package ej3;

public class Test {
	

	public static void main(String[] args) {
		
		Estudiante [] vecEstudiantes = new Estudiante [2]; //declaro el vector de tipo estudiante 
		Profesor [] vecProfesores = new Profesor [3];	//declaro el vector de tipo profesor 	
		
		vecEstudiantes[0] = new Estudiante(); //cargo un estudiante en la pos 0 del vector
		vecEstudiantes[1] = new Estudiante();
		
		vecEstudiantes[0].setNombre(new String ("Juan"));
		vecEstudiantes[0].setApellido(new String ("Gonzalez"));
		vecEstudiantes[0].setComision(2);
		vecEstudiantes[0].setEmail(new String ("juangonza@gmail.com"));
		vecEstudiantes[0].setDireccion(new String ("143 y 28 bis"));
		
		
		vecEstudiantes[1].setNombre(new String ("Maria"));
		vecEstudiantes[1].setApellido(new String ("Elena"));
		vecEstudiantes[1].setComision(5);
		vecEstudiantes[1].setEmail(new String ("mariaele@gmail.com"));
		vecEstudiantes[1].setDireccion(new String ("524 y 38"));
		
		vecProfesores[0] = new Profesor();
		vecProfesores[1] = new Profesor();
		vecProfesores[2] = new Profesor(); 
		
		vecProfesores[0].setNombre(new String ("Veronica"));
		vecProfesores[0].setApellido(new String ("Aguirre"));
		vecProfesores[0].setEmail(new String ("veroagui@hotmail.com"));
		vecProfesores[0].setCatedra(new String("OO1"));
		vecProfesores[0].setFacultad(new String ("Informática"));
		
		vecProfesores[1].setNombre(new String ("Pablo"));
		vecProfesores[1].setApellido(new String ("Gustavo"));
		vecProfesores[1].setEmail(new String ("pablogu@hotmail.com"));
		vecProfesores[1].setCatedra(new String("Mate1"));
		vecProfesores[1].setFacultad(new String ("Exactas"));
		
		vecProfesores[2].setNombre(new String ("Ester"));
		vecProfesores[2].setApellido(new String ("Terri"));
		vecProfesores[2].setEmail(new String ("est@hotmail.com"));
		vecProfesores[2].setCatedra(new String("Taller"));
		vecProfesores[2].setFacultad(new String ("Informática"));
		
		System.out.println("Estudiantes:");
		int i = 0;
		while (i<2) {
			System.out.println(vecEstudiantes[i].tusDatos());
			i++;
		}
		
		System.out.println("Profesores:");
		int j = 0;
		while (j<3){
			System.out.println(vecProfesores[j].tusDatos());
			j++;
		}
	}

}
