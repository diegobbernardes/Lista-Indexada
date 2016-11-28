package listaIndexada;

import java.util.Iterator;

public interface Iterador extends Iterator<Pessoa> {
	void insertAfter(Pessoa dado);
	void insertBefore(Pessoa dado);
}