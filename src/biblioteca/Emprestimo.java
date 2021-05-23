package biblioteca;

import java.util.Date;

public class Emprestimo {
	
	private Date dataRetirada;
	private Aluno aluno;
	private Livro livro;
	
	Emprestimo(Date dataRetirada, Aluno aluno, Livro livro){
		this.dataRetirada = dataRetirada;
		this.aluno = aluno;
		this.livro = livro;
	}
	public Aluno pegarAluno() {
		
		return this.aluno;
	}
	public Date pegarData() {
		
		
		
		return new Date(this.dataRetirada.getTime());
	}
	public Livro pegarLivro() {
		
		return this.livro;
	}
	
}
