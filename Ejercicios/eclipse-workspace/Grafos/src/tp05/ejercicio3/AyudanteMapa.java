package tp05.ejercicio3;

import tp01.ejercicio2.ListaGenerica;

public class AyudanteMapa {
	
	private Integer longCamino = Integer.MAX_VALUE; //camino min 
	private ListaGenerica<String> camino; 
	
	public Integer getLongCamino() {
		return longCamino;
	}
	
	public void setLongCamino(Integer longCamino) {
		this.longCamino = longCamino;
	}
	
	public ListaGenerica<String> getCamino() {
		return camino;
	}
	
	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}
	
	 public void actualizar(ListaGenerica<String> caminoNuevo, Integer unaLongitud) { //reemplazo por el nuevo camino 
		 this.longCamino = unaLongitud; 
		 camino.comenzar();
		 while (!camino.fin()) { //recorro todo el camino que tenia guardado 
			 camino.eliminarEn(1); 
		 }
         caminoNuevo.comenzar(); 
         while (!caminoNuevo.fin()) { //agrego todos los elementos del caminoNuevo a mi camino 
        	 camino.agregarFinal(caminoNuevo.proximo());
         }
	}
	

}
