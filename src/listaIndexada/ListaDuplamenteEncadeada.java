package listaIndexada;

public class ListaDuplamenteEncadeada<T>{
	private class Node {
		private T data;
		private Node next;
		private Node previous;
		
		private Node skip25Next;
		private Node skip25Previous;
		
		private Node skip100Next;
		private Node skip100Previous;
		
		public Node(T value) {
			data = value;
		}		
		public T getData(){
			return data;
		}
	}
	
	public void mostraHead(){
		System.out.println(head.skip25Next + " - " +head.skip25Previous + " - " + head );
	}
	public void mostraTail(){
		System.out.println(tail.skip25Next + " - " +tail.skip25Previous + " - " + tail );
	}
	
	public void listaCreateSkips(){
		Node skip25 = head;
		Node skip100 = head;
		
		Node current = head;
		
		skip25.skip25Next = tail;
		skip100.skip100Next = tail;
		
		int cont = 1;
		while(current != null){
			if((cont % 25) == 0){
				skip25.skip25Next = current;
				current.skip25Previous = skip25;
				current.skip25Next = tail;
				
				skip25 = current;
			}
			if((cont % 100) == 0){
				skip100.skip100Next = current;
				current.skip100Previous = skip100;
				current.skip100Next = tail;
				
				skip100 = current;
			}
			current = current.next;
			cont++;
		}
		if(tail.skip25Previous == null)
			tail.skip25Previous = skip25;
		if(tail.skip100Previous == null)
			tail.skip100Previous = skip25;
	}
	
	public void mostraListaInicioSkip25() {
        Node current = head;
        while (current != null) {
            System.out.println((current.getData()));
            current = current.skip100Next;
        }
    }
	
	public void mostraListaFimSkip25() {
        Node current = tail;
        while (current != null) {
            System.out.println((current.getData()));
            current = current.skip25Previous;
        }
    }
	
	public void mostraListaInicio() {
        Node current = head;
        while (current != null) {
            System.out.println((current.getData()));
            current = current.next;
        }
    }
	
	public void mostraListaFim() {
        Node current = tail;
        while (current != null) {
            System.out.println((current.getData()));
            current = current.previous;
        }
    }
	
	private Node head;
	private Node tail;

	void append(T value) {
		Node novo = new Node(value);
		if (tail != null){   
			if(head.next==null){
				head.next = novo;
				tail = novo;
				tail.previous=head;
			}else{
				novo.previous=tail;
				tail.next = novo;
				tail = novo;
			}	
		}
		else{
			head = novo;
			tail = novo;
		}				
	}	
}
