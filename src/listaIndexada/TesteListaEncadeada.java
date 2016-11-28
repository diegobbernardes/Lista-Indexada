package listaIndexada;

public class TesteListaEncadeada {
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
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
		
		Iterador iter = lista.iterator();
		while (iter.hasNext()) {
			if (iter.next().getNome().equals("B")) {
				pessoa = new Pessoa(6,"f");
				iter.insertBefore(pessoa);
				pessoa = new Pessoa(7,"g");
				iter.insertAfter(pessoa);
				iter.remove();
				break;
			}
		}
		
		for (Pessoa s : lista) {
			System.out.println(s.getNome());
		}
	}
	
}
