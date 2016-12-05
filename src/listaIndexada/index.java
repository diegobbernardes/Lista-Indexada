package listaIndexada;

import java.util.Scanner;

public class index {
	private static Scanner sc;
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		Opcao imprimirInicio = new Opcao("Mostra Lista Inicio");
		Opcao imprimirFim = new Opcao("Mostra Lista Fim");
		Opcao busca = new Opcao("Buscar");
		Opcao sair = new Opcao("Sair");
		
		menu.addOpcao(imprimirInicio);
		menu.addOpcao(imprimirFim);
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
				case 1 :
					lista.mostraListaFim();
					break;
				case 2:
					int numero = digita("Digite um numero para busca: ");
					lista.buscaOtimizada(numero);
					lista.buscaNaoOtimizada(numero);
					break;
				case 3:
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
