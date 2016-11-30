package listaIndexada;

public class index {
	public static void main(String[] args) {
		
		ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
		for (int i = 0; i <= 10000; i++) {
			lista.append(i);
		}
		lista.listaCreateSkips();
		System.out.println("Buscando numero 1250;");
		lista.buscaOtimizada(9349);
		
		
	}
}
