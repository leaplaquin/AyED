package tp02.ArbolesBinarios;

public class Test {
	
	public static void main(String[] args) {
		
		ArbolBinario <String> a = new ArbolBinario <String>("A");
		ArbolBinario <String> b = new ArbolBinario <String>("B");
		ArbolBinario <String> c = new ArbolBinario <String>("C");
		ArbolBinario <String> d = new ArbolBinario <String>("D");
		ArbolBinario <String> e = new ArbolBinario <String>("E");
		
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		
		System.out.println(a);
		
		
		
	}

}
