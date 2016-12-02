package listaIndexada;

import java.util.Scanner;

public class Menu {
	Opcao opcoes[] = new Opcao[5];
	int numOpcao = 0;
	private Scanner sc;

	public void addOpcao(Opcao opcao) {
		opcoes[numOpcao] = opcao;
		numOpcao++;
	}

	public void show() {
		for (int i = 0; i < numOpcao; i++) {
			System.out.println("["+(i+1)+"]"+opcoes[i].getTexto());
		}

	}

	public int getOpcaoUsuario() {
		int opcaoSelecionada;
		sc = new Scanner(System.in);
		System.out.print("Selecione a opção:");
		opcaoSelecionada = sc.nextInt()-1;
		if(opcaoSelecionada >= 0 && opcaoSelecionada < numOpcao){
			//return opcoes[opcaoSelecionada];
			return opcaoSelecionada;
		}
		
		return -1;
	}

}
