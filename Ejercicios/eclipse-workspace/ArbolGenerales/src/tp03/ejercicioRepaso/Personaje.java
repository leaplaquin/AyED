package tp03.ejercicioRepaso;

public class Personaje {
	private String nombre;
	private String tipo;
	
	public Personaje(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo; //Dragon, Princesa, Animal, etc
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean esDragon() {
		return this.getTipo().equals("Dragon");
	}
	
	public boolean esPrincesa() {
		return this.getTipo().equals("Princesa");
	}
	
	
	
	

}
