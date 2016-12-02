package listaIndexada;

import java.util.Scanner;

public class index {
	private static Scanner sc;
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		Opcao imprimir = new Opcao("Mostra Lista");
		Opcao busca = new Opcao("Buscar");
		Opcao sair = new Opcao("Sair");
		
		menu.addOpcao(imprimir);
		menu.addOpcao(busca);
		menu.addOpcao(sair);
		
		ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
		for (int i = 0; i <= 10000; i++) {
			lista.append(i);
		}
		lista.listaCreateSkips();
		//System.out.println("Buscando numero 1250;");
		//lista.buscaOtimizada(9349);
		
		while(true){
			menu.show();
			switch(menu.getOpcaoUsuario()){
				case 0 :
					lista.mostraListaInicio();
					break;
				case 1:
					lista.buscaOtimizada(digita("Digite um numero para busca: "));
					break;
				case 2:
					System.exit(0);
				
			}
		}
		
	}
	public static int digita(String texto){
		sc = new Scanner(System.in);
		System.out.print(texto);
		return sc.nextInt();
	}
}
