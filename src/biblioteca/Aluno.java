package biblioteca;


public class Aluno {
	private String ra;
	private String nome;
	private String curso;
	private String email;
	
	Aluno(String ra, String nome, String curso, String email){
		this.ra = ra;
		this.nome = nome;
		this.curso = curso;
		this.email = email;
	}
	public String pegarRa() {
		return this.ra;
	}
	public String pegarNome() {
		return this.nome;
	}
	public String pegarCurso() {
		return this.curso;
	}
	public String pegarEmail() {
		return this.email;
	}
	
}