package listaIndexada;

public class TesteListaEncadeada {
	public static void main(String[] args) {
		ListaEncadeada<Pessoa> lista = new ListaEncadeada<>();
		Pessoa pessoa = new Pessoa(1,"Andre");
		lista.append(pessoa);
		pessoa = new Pessoa(2,"B");
		lista.append(pessoa);
		pessoa = new Pessoa(3,"c");
		lista.append(pessoa);
		pessoa = new Pessoa(4,"d");
		lista.append(pessoa);
		pessoa = new Pessoa(5,"e");
		lista.append(pessoa);
		
		Iterador<Pessoa> iter = lista.iterator();
		iter.next();		
		System.out.println(iter.next());
		pessoa = new Pessoa(6,"f");
		iter.insert(pessoa);
		iter.next();
		pessoa = new Pessoa(7,"g");
		iter.insert(pessoa);
		
		for (Pessoa s : lista) {
			System.out.println(s.getNome());
		}
	}
	
}
