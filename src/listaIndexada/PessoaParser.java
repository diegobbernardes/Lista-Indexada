package listaIndexada;

import java.util.Scanner;

public class PessoaParser implements Parser<Pessoa> {

	@Override
	public Pessoa parseObject(String dadosCSV) {
		Scanner parser = new Scanner(dadosCSV);
		parser.useDelimiter(",");
		
		int indice = parser.nextInt();
		String nome = parser.next();
		
		Pessoa pessoa = new Pessoa(indice,nome);
		
		parser.close();
		
		return pessoa;
	}
	
}
