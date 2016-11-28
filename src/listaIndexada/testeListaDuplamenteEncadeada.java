package listaIndexada;

import java.io.FileNotFoundException;

public class testeListaDuplamenteEncadeada {
	public static void main(String[] args) {
		/*ListaDuplamenteEncadeada<Pessoa> lista = new ListaDuplamenteEncadeada<>();
		Pessoa pessoa = new Pessoa(1,"a");
		lista.append(pessoa);
		pessoa = new Pessoa(2,"b");
		lista.append(pessoa);
		pessoa = new Pessoa(3,"c");
		lista.append(pessoa);
		pessoa = new Pessoa(4,"d");
		lista.append(pessoa);			
		
		lista.mostraListaInicio();	
		System.out.println("//\\");
		lista.mostraListaFim();*/
		
		try {
			(new testeListaDuplamenteEncadeada()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
			System.err.println(e.getMessage());
		}
		
	}

	static void run() throws FileNotFoundException {
		Parser<Pessoa> parser = new PessoaParser();
		CSVFile<Pessoa> csvFuncionario = new CSVFile<>("csv/Lista_Nomes.csv", parser);	
		ListaDuplamenteEncadeada<Pessoa> lista = new ListaDuplamenteEncadeada<>();
		
		Pessoa p = null;
		do {
			p = csvFuncionario.readObject();
			if (p != null)
				lista.append(p);
		} while (p != null);
		
		lista.mostraListaInicio();	
		lista.mostraListaFim();	
	}
	
	
	
}
