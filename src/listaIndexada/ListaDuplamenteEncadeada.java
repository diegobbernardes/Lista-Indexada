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
		
		private Node skip1000Next;
		private Node skip1000Previous;
		
		public Node(T value) {
			data = value;
		}		
		public T getData(){
			return data;
		}
	}
		
	public void buscaOtimizada(int numero) {
		Node current = head;
        boolean found = false;
        int saltosOtm = 0;      

		while (current != null) {
            //System.out.println("Verificando node com o valor: " + current.data); // debug            
            if ((Integer)current.getData() != numero) {
            	saltosOtm++;
            	if ((current.skip1000Next != null) && ((Integer)current.skip1000Next.data <= numero)) { 
                	current = current.skip1000Next; 
            	}else if ((current.skip100Next != null) && ((Integer)current.skip100Next.data <= numero)) { 
                	current = current.skip100Next; 
            	}else if ((current.skip25Next != null) && ((Integer)current.skip25Next.data <= numero)) { 
            		current = current.skip25Next; 
        		}
                else { 
                	current = current.next; 
            	}
            }
            else {
            	found = true;
                break;
            }            
        }		                 
        if (found) {          	
        	System.out.println("Numero de saltos otimizados:"+saltosOtm);
    	}        
    }
	
	public void buscaNaoOtimizada(int numero) {
		Node current = head;
		int saltos = 0;
        boolean found = false;
        while (current != null) {
        	if ((Integer)current.getData() > numero) { break; }	
        	if ((Integer)current.getData() != numero) {
        		current = current.next; 
        		saltos++;
        	}else{
        		found = true;
                break;
        	}        	
        }
        if(found){
        	System.out.println("Numero de saltos sem otimização:"+saltos);
        }else { 
        	System.out.println("Numero não encontrado."); 
    	}
        
	}

	public void listaCreateSkips(){
		Node skip25 = head;
		Node skip100 = head;
		Node skip1000 = head;
		
		Node current = head;
		
		skip25.skip25Next = tail;
		skip100.skip100Next = tail;
		skip1000.skip1000Next = tail;
		
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
			if((cont % 1000) == 0){
				skip1000.skip1000Next = current;
				current.skip1000Previous = skip1000;
				current.skip1000Next = tail;
				
				skip1000 = current;
			}
			current = current.next;
			cont++;
		}
		if(tail.skip25Previous == null)
			tail.skip25Previous = skip25;
		if(tail.skip100Previous == null)
			tail.skip100Previous = skip100;
		if(tail.skip1000Previous == null)
			tail.skip1000Previous = skip1000;
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
	private int tamanhoLista=0;

	void append(T value) {
		Node novo = new Node(value);
		tamanhoLista++;
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
