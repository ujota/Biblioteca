package biblioteca;



public class Livro {
	private String isbn;
	private String titulo;
	private String editora;
	private int ano;
	private int exemplares;
	
	Livro(String isbn, String titulo, String editora, int ano, int exemplares){
		this.isbn = isbn;
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
		this.exemplares = exemplares;
	}
	public String pegarIsbn() {
		return this.isbn;
	}
	public String pegarTitulo() {
		return this.titulo;
	}
	public String pegarEditora() {
		return this.editora;
	}
	public int pegarAno() {
		return this.ano;
	}
	public int pegarExemplares() {
		
		return this.exemplares;
	}
 }
