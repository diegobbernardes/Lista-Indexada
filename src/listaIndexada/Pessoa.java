package listaIndexada;

public class Pessoa {
	
	public Pessoa(int indice,String nome){
		this.indice = indice;
		this.nome = nome;
	}
	
	private int indice;
	private String nome;
	
	public String getNome(){
		return this.nome;
	}
	
	public int getIndice(){
		return this.indice;
	}
	
	
}
