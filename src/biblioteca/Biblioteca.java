package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {

	private List<Aluno> alunos = new ArrayList<>();
	private List<Livro> livros = new ArrayList<>();
	private List<Emprestimo> emprestimos = new ArrayList<>();

	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public void adicionarLivro(Livro livro) {
		this.livros.add(livro);
	}

	public void criarEmprestimo(Date dataDeRetirada, Aluno aluno, Livro livro) {
		Emprestimo emprestimo = new Emprestimo(dataDeRetirada, aluno, livro);
		this.emprestimos.add(emprestimo);
	}

	public Aluno buscarAluno(String ra) {
		for (Aluno a : this.alunos) {
			if (a.pegarRa().equals(ra)) {
				return a;
			}
		}
		return null;
	}

	public void removerAluno(Aluno aluno) {
		this.alunos.remove(aluno);
	}

	public List<Aluno> listarAlunos() {
		return this.alunos;
	}

	public Livro buscarLivroPorIsbn(String isbn) {
		for (Livro isb : this.livros) {
			if (isb.pegarIsbn().equals(isbn)) {

				return isb;
			}
		}
		return null;
	}

	public Livro buscarLivroPorTitulo(String nome) {
		for (Livro liv : this.livros) {
			if (liv.pegarTitulo().equals(nome)) {

				return liv;
			}
		}

		return null;

	}

	public void removerLivro(Livro livro) {
		this.livros.remove(livro);
	}

	public List<Livro> listarLivros() {
		return this.livros;
	}

	public List<Emprestimo> buscaEmprestimoPeloAluno(Aluno aluno) {
		List<Emprestimo> emprestimosAluno = new ArrayList<Emprestimo>();
		for (Emprestimo e : this.emprestimos) {
			if (e.pegarAluno().pegarRa().equals(aluno.pegarRa())) {
				emprestimosAluno.add(e);
			}
		}
		return emprestimosAluno;
	}
	public List<Emprestimo> buscaEmprestimoPeloLivro(Livro livro) {
		List<Emprestimo> emprestimosAluno = new ArrayList<Emprestimo>();
		for (Emprestimo e : this.emprestimos) {
			if (e.pegarLivro().pegarIsbn().equals(livro.pegarIsbn())) {
				emprestimosAluno.add(e);
			}
		}
		return emprestimosAluno;
	}

	public List<Emprestimo> listarEmprestimoVencidos() {
		List<Emprestimo> listEmprestimosVencidos = new ArrayList<Emprestimo>();
		for (Emprestimo eL : this.emprestimos) {
			Date dataVencimento = eL.pegarData();
			dataVencimento.setDate(dataVencimento.getDate() + 7);

			Date dataAtual = new Date();
			long epochDataVencimento = dataVencimento.getTime();
			long epochDataAtual = dataAtual.getTime();
			if (epochDataVencimento < epochDataAtual) {
				listEmprestimosVencidos.add(eL);
			}

		}
		return listEmprestimosVencidos;

	}

	public boolean verificarSeAlunoPossuiEmprestimoEmAtraso(Aluno aluno) {
		boolean possuiAtraso = false;
		for (Emprestimo e : this.listarEmprestimoVencidos()) {
			if (e.pegarAluno().pegarRa().equals(aluno.pegarRa())) {
				possuiAtraso = true;
			}
		}
		return possuiAtraso;
	}
	public void removerEmprestimo(Aluno aluno, Livro livro) {
		Emprestimo emprestimoARemover = null;
		for (Emprestimo eR : this.emprestimos) {
			if (eR.pegarAluno().pegarRa().equals(aluno.pegarRa()) && eR.pegarLivro().pegarIsbn().equals(livro.pegarIsbn())) {
				emprestimoARemover = eR;
			}
			
		}
		this.emprestimos.remove(emprestimoARemover);
	}

}
