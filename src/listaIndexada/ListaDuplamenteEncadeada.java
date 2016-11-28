package listaIndexada;

public class ListaDuplamenteEncadeada<T>{
	private class Node {
		private T data;
		private Node next;
		private Node previous;
		
		public Node(T value) {
			data = value;
		}		
		public T getData(){
			return data;
		}
	}
	
	public void mostraListaInicio() {
        Node current = head;
        while (current != null) {
            System.out.println(((Pessoa) current.getData()).getNome());
            current = current.next;
        }
    }
	
	public void mostraListaFim() {
        Node current = tail;
        while (current != null) {
            System.out.println(((Pessoa) current.getData()).getNome());
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
