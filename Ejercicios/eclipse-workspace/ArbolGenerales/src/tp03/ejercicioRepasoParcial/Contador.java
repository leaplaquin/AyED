package tp03.ejercicioRepasoParcial;

public class Contador {
	private int cantPositivos;
	private int cantNegativos;
	
	public Contador() {
		this.cantPositivos = 0;
		this.cantNegativos = 0;
	}
	
	public int getCantPositivos() {
		return cantPositivos;
	}
	
	public void setCantPositivos(int cantPositivos) {
		this.cantPositivos = cantPositivos;
	}
	
	public int getCantNegativos() {
		return cantNegativos;
	}
	
	public void setCantNegativos(int cantNegativos) {
		this.cantNegativos = cantNegativos;
	}
	
	public int totalNodos() {
		return this.getCantNegativos() + this.getCantPositivos();
	}
	
	public void evaluar(int dato) {
		if(dato >= 0) 
			this.cantPositivos++;
		else
			this.cantNegativos++;
	}
	
	public int resultado () {
		if(this.getCantPositivos() % 2 == 0)
			return this.totalNodos();
		else
			return this.getCantNegativos();
	}
	

}
