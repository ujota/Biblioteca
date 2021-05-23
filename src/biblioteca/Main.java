package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		char opcao;

		while (true) {
			String ra;
			String isbn;
			Aluno alunoEmprestimo;
			
			System.out.println("\n-----------------------------MENU--------------------------\n");
			System.out.println(
					"Escolha uma opção: \na - Cadastrar Aluno"
					+ "\nb - Consultar Aluno Cadastrado"
					+ "\nc - Cadastrar Livro"
					+ "\nd - Consultar Livro Cadastrado"
					+ "\ne - Listar Alunos Cadastrados"
					+ "\nf - Listar Livros Cadastrados"
					+ "\ng - Remover Aluno Cadastrado"
					+ "\nh - Remover Livro Cadastrado"
					+ "\ni - Criar Emprestimo de Livro"
					+ "\nj - Listar Emprestimos Vencidos"
					+ "\nk - Listar Alunos que Emprestaram um Determinado Livro"
					+ "\nl - Remover Emprestimo");
			System.out.println("\n-----------------------------------------------------------");
			opcao = sc.next().charAt(0);

			switch (opcao) {
			case 'a':
				System.out.println("Digite ra: ");
				ra = sc.next();
				Aluno buscaA = biblioteca.buscarAluno(ra);
				if (buscaA == null) {

					System.out.println("Digite nome: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.println("Digite o curso: ");
					String curso = sc.nextLine();
					System.out.println("Digite o email: ");
					String email = sc.next();

					Aluno novoAluno = new Aluno(ra, nome, curso, email);
					biblioteca.adicionarAluno(novoAluno);

					System.out.println("ALUNO ADICIONADO COM SUCESSO!");
				} else {
					System.out.println("ALUNO COM ESTE RA JÁ É CADASTRADO");
				}
				break;
			case 'b':
				System.out.println("Digite um RA: ");
				ra = sc.next();

				Aluno aluno = biblioteca.buscarAluno(ra);
				if (aluno != null) {
					
					System.out.println("------------------------------\n");
					System.out.println("RA: " + aluno.pegarRa());
					System.out.println("Nome: " + aluno.pegarNome());
					System.out.println("Curso: " + aluno.pegarCurso());
					System.out.println("Email: " + aluno.pegarEmail());
					System.out.println("\n------------------------------");
				} else {
					System.out.println("ALUNO NÃO CADASTRADO");
				}
				break;
			case 'c':
				System.out.println("Digite ISBN do livro: ");
				isbn = sc.next();
				Livro buscaL = biblioteca.buscarLivroPorIsbn(isbn);
				if (buscaL == null) {

					System.out.println("Digite titulo do livro: ");
					sc.nextLine();
					String titulo = sc.nextLine();
					System.out.println("Digite o nome da editora do livro: ");
					String editora = sc.nextLine();
					System.out.println("Digite o ano do livro: ");
					int ano = sc.nextInt();
					System.out.println("Digite a quantidade de exemplares deste livro: ");
					int exemplares = sc.nextInt();

					Livro novoLivro = new Livro(isbn, titulo, editora, ano, exemplares);
					biblioteca.adicionarLivro(novoLivro);

					System.out.println("LIVRO ADICIONADO COM SUCESSO");
				} else {
					System.out.println("LIVRO COM ESTÉ ISBN JÁ CADASTRADO");
				}
				break;
			case 'd':
				System.out.println("Se deseja consultar por ISBN; '1'\nSe deseja consultar por NOME; '2'");
				String consulta = sc.next();
				if (consulta.equals("1")) {
					System.out.println("Digite ISBN do Livro: ");
					isbn = sc.next();

					Livro livroIsbn = biblioteca.buscarLivroPorIsbn(isbn);
					if (livroIsbn != null) {
						System.out.println("---------------------------------------\n");
						System.out.println("ISBN: " + livroIsbn.pegarIsbn());
						System.out.println("Titulo: " + livroIsbn.pegarTitulo());
						System.out.println("Editora: " + livroIsbn.pegarEditora());
						System.out.println("Ano: " + livroIsbn.pegarAno());
						System.out.println("\n---------------------------------------");
					} else {
						System.out.println("LIVRO NÁO CADASTRADO");
					}

				} else if (consulta.equals("2")) {
					System.out.println("Digite o TITULO do livro: ");
					sc.nextLine();
					String titulo = sc.nextLine();

					Livro livroTitulo = biblioteca.buscarLivroPorTitulo(titulo);
					if (livroTitulo != null) {
						System.out.println("---------------------------------------\n");
						System.out.println("ISBN: " + livroTitulo.pegarIsbn());
						System.out.println("Titulo: " + livroTitulo.pegarTitulo());
						System.out.println("Editora: " + livroTitulo.pegarEditora());
						System.out.println("Ano: " + livroTitulo.pegarAno());
						System.out.println("\n---------------------------------------");
					} else {
						System.out.println("LIVRO NÃO CADASTRADO");
					}
				}
				break;
			case 'e':
				List<Aluno> lista = biblioteca.listarAlunos();
				for (Aluno aluno1 : lista) {
					System.out.println("------------------------------\n");
					System.out.println("RA: " + aluno1.pegarRa());
					System.out.println("NOME: " + aluno1.pegarNome());
					System.out.println("CURSO: " + aluno1.pegarCurso());
					System.out.println("EMAIL: " + aluno1.pegarEmail());
					System.out.println("\n------------------------------");
				}
				break;
			case 'f':
				List<Livro> listaLivro = biblioteca.listarLivros();
				for (Livro livro : listaLivro) {
					System.out.println("-----------------------------\n");
					System.out.println("ISBN: " + livro.pegarIsbn());
					System.out.println("TITULO: " + livro.pegarTitulo());
					System.out.println("EDITORA: " + livro.pegarEditora());
					System.out.println("ANO: " + livro.pegarAno());
					System.out.println("\n-----------------------------");
				}
				break;
			case 'g':
				System.out.println("Digitar RA: ");
				ra = sc.next();
				Aluno estudate = biblioteca.buscarAluno(ra);
				biblioteca.removerAluno(estudate);
				System.out.println("ALUNO REMOVIDO COM SUCESSO");
				break;
			case 'h':
				System.out.println("Digite ISBN: ");
				isbn = sc.next();
				Livro livroRemovido = biblioteca.buscarLivroPorIsbn(isbn);
				biblioteca.removerLivro(livroRemovido);
				System.out.println("LIVRO REMOVIDO COM SUCESSO");
				break;
			case 'i':
				System.out.println("Data do emprestimo: EX: 'dd-mm-aaaa'");
				String dataEmprestimo = sc.next();
				SimpleDateFormat formatadorData = new SimpleDateFormat("dd-MM-yyyy");
				Date dataDaRetirada = formatadorData.parse(dataEmprestimo);

				System.out.println("Digite RA Aluno: ");
				ra = sc.next();
				alunoEmprestimo = biblioteca.buscarAluno(ra);
				if (alunoEmprestimo == null) {
					System.out.println("Este aluno não EXISTE");
				} else {
					if (biblioteca.verificarSeAlunoPossuiEmprestimoEmAtraso(alunoEmprestimo)) {
						System.out.println("ALUNO POSSUI EMPRESTIMOS EM ATRASO!");
					} else {
						System.out.println("Digite ISBN Livro: ");
						isbn = sc.next();

						Livro livroEmprestimo = biblioteca.buscarLivroPorIsbn(isbn);
						if (livroEmprestimo == null) {
							System.out.println("ESTE LIVRO NÃO EXISTE");
						} else {
							if (biblioteca.buscaEmprestimoPeloLivro(livroEmprestimo).size() >= livroEmprestimo
									.pegarExemplares()) {
								System.out.println("EXEMPLAR INDISPONÍVEL PARA EMPRESTIMO");
							} else {
								biblioteca.criarEmprestimo(dataDaRetirada, alunoEmprestimo, livroEmprestimo);
								System.out.println("EMPRESTIMO CRIADO COM SUCESSO");
							}
						}
					}
				}
				break;
			case 'j':
				List<Emprestimo> listVencidos = biblioteca.listarEmprestimoVencidos();
				for (Emprestimo eV : listVencidos) {
					Date dataVencimento = eV.pegarData();
					dataVencimento.setDate(dataVencimento.getDate() + 7);
					System.out.println("Ra: " + eV.pegarAluno().pegarRa() + "\nNome: " + eV.pegarAluno().pegarNome()
							+ "\nIsbn: " + eV.pegarLivro().pegarIsbn() + "\nTitulo: " + eV.pegarLivro().pegarTitulo()
							+ "\nData Venceu dia: " + dataVencimento.toLocaleString());
				}
				break;
			case 'k':
				System.out.println("Digite o ISBN do Livro: ");
				isbn = sc.next();
				Livro livro = biblioteca.buscarLivroPorIsbn(isbn);
				List<Emprestimo> listEmpres = biblioteca.buscaEmprestimoPeloLivro(livro);
				for (Emprestimo e : listEmpres) {
					Aluno aluno2 = e.pegarAluno();
					System.out.println("------------------------------\n");
					System.out.println("RA: " + aluno2.pegarRa());
					System.out.println("Nome: " + aluno2.pegarNome());
					System.out.println("Curso: " + aluno2.pegarCurso());
					System.out.println("Email: " + aluno2.pegarEmail());
					System.out.println("\n------------------------------");
				}
				break;
			case 'l':

				System.out.println("Digite RA Aluno: ");
				ra = sc.next();
				alunoEmprestimo = biblioteca.buscarAluno(ra);
				if (alunoEmprestimo == null) {
					System.out.println("ESTE ALUNO NÃO EXISTE");
				} else {

					System.out.println("Digite ISBN Livro: ");
					isbn = sc.next();

					Livro livroEmprestimo = biblioteca.buscarLivroPorIsbn(isbn);
					if (livroEmprestimo == null) {
						System.out.println("ESTE LIVRO NÃO EXISTE");
					} else {
						biblioteca.removerEmprestimo(alunoEmprestimo, livroEmprestimo);
						System.out.println("EMPRESTIMO REMOVIDO COM SUCESSO");
					}
				}
				break;
			default:
				System.out.println("VALOR SELECIONADO INVALIDO");

			}

		}

	}

}
