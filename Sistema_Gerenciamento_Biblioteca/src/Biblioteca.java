import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Biblioteca {
    static ArrayList<Livro> livro;
    static ArrayList<Usuario> usuario;
    static Usuario logged;
    static boolean logar;

    
    public static void main(String[] args) {

        livro = new ArrayList<>();
        usuario = new ArrayList<>();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        livro.add(new Livro("Bom", 1, "Edtor", 1995, "Cara", true));
        livro.add(new Livro("hey", 2, "Edtor", 1999, "Vara", true));
        livro.add(new Livro("mae", 4, "Remarker", 2003, "Cara", true));
        livro.add(new Livro("primos", 1, "Redar", 1986, "Para", true));

        
        /*@SuppressWarnings("deprecation")
        usuario.add(new Professor("joao", "12", new Date(2000, 02, 31), "autodidata"));
        usuario.add(new Aluno("Samuel", "11", new Date(2006, 04, 08), "Coltec"));
        usuario.add(new Morador("Paçoca", "10", new Date(1988, 11, 20))); */

        cadastroUsuario();

        while(logar == false) {
            System.out.println("-------Faz login--------");
            logged = Login(); 
        }

        while(logar) {
            System.out.print("--------Digite o que deseja--------");
            System.out.print("\n1 - Devolver Livro\n2 - Pegar livro\n3 - Cadastrar um Usuario\n4 - Doar um livro\n5 - Logout\n: ");
            int op = scanner.nextInt();

            if(op == 1) {
                realizarDevolucao();

            } else if (op == 2) {
                realizarEmprestimo();

            } else if (op == 3) {
                cadastroUsuario();
                
            } else if (op == 4) {
                cadastroLivro();

            } else if (op == 5) {
                for(Usuario user : usuario) {
                    if(user.getNome().equalsIgnoreCase(logged.getNome()) && user.getCpf().equalsIgnoreCase(logged.getCpf())) {
                        user = logged;
                    }
                }
                do {
                    System.out.println("------Faça login denovo------");
                    logged = Login(); 
                } while(logar == false);
            } else {
                System.out.println("Digite algo valido");
            }
        }
    }

    static Usuario Login() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da conta: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o cpf: ");
        String cpf = scanner.nextLine();

        for(Usuario user : usuario) {
            if(user.getNome().equalsIgnoreCase(nome) && user.getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("Voce logou como: " + nome);
                logar = true;
                return user;
            }
        }

        logar = false;
        return null;
    }

    static void cadastroUsuario() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tipo de Usuario(professor, aluno ou morador): ");
        String tipo = scanner.nextLine();

        if(!(tipo.equalsIgnoreCase("morador") || tipo.equalsIgnoreCase("professor") || tipo.equalsIgnoreCase("aluno"))) {
            tipo = "morador";
        }

        Usuario novoUsuario = null;
        switch (tipo) {
            case "aluno":
                novoUsuario = cadastrarAluno();
                break;
            case "professor":
                novoUsuario = cadastrarProfessor();
                break;
            case "morador":
                novoUsuario = cadastrarMorador();
                break;
            default:
                System.out.println("Tipo de usuário inválido!");
                break;
        }
        if (novoUsuario != null) {
            usuario.add(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
        }

    }

    static Usuario cadastrarAluno() {
        Usuario aluno;

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do Aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String CPF = scanner.nextLine();

        System.out.print("Digite a data de nascimento (dd mm aaaa)");
        Date Birth = DataScaner();

        System.out.print("Digite sua escola: ");
        String escola = scanner.nextLine();

        for(Usuario user : usuario) {
            if(user.getCpf().equalsIgnoreCase(CPF) && user.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nao aceitamos contas com mesmo nome e cpf"); 
                System.out.println("se quer criar uma nova conta com seu cpf crie com nome diferente");
                return null;
            }
        }
        aluno = new Aluno(nome, CPF, Birth, escola);

        return aluno;
        
    }

    static Usuario cadastrarProfessor() {
        Usuario professor;

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do Professor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String CPF = scanner.nextLine();

        System.out.print("Digite a data de nascimento (dd mm aaaa)");
        Date Birth = DataScaner();

        System.out.print("Digite sua formação: ");
        String formacao = scanner.nextLine();

        for(Usuario user : usuario) {
            if(user.getCpf().equalsIgnoreCase(CPF) && user.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nao aceitamos contas com mesmo nome e cpf"); 
                System.out.println("se quer criar uma nova conta com seu cpf crie com nome diferente");
                return null;
            }
        }

        professor = new Professor(nome, CPF, Birth, formacao);

        return professor;
    }
    
    static Usuario cadastrarMorador() {
        Usuario morador;

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do Morador: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String CPF = scanner.nextLine();

        System.out.print("Digite a data de nascimento (dd mm aaaa)");
        Date Birth = DataScaner();

        for(Usuario user : usuario) {
            if(user.getCpf().equalsIgnoreCase(CPF) && user.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nao aceitamos contas com mesmo nome e cpf"); 
                System.out.println("se quer criar uma nova conta com seu cpf crie com nome diferente");
                return null;
            }
        }

        morador = new Morador(nome, CPF, Birth);

        return morador;

    }
    
    @SuppressWarnings("deprecation")
    static Date DataScaner() {
        Date data;

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);

        System.out.print("\nDia: ");
        int dia = scan.nextInt();

        System.out.print("Mês: ");
        int mes = scan.nextInt();

        System.out.print("Ano: ");
        int ano = scan.nextInt();

        data = new Date(ano, mes, dia);

        return data;
    }

    static void cadastroLivro() {
        Livro livros = cadastrarLivro();
        if (livro != null) { 
            livro.add(livros);
            System.out.println("Livro cadastrado com sucesso!");
        }
    }

    static Livro cadastrarLivro() {
        Livro book;

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o Autor: ");
        String Autor = scanner.nextLine();

        System.out.print("Digite a editora: ");
        String editora = scanner.nextLine();

        System.out.print("Digite o ano de publicação: ");
        int birth = scanner.nextInt();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        book = new Livro(titulo, quantidade, editora, birth, Autor, true);

        for(Livro bok : livro) {
            if(bok.getTitulo().equalsIgnoreCase(titulo)) {
                bok.setQuantidade(quantidade);
                System.out.println("Ja temos esse livro aqui, aumentamos sua quantidade");
                return new Livro("primos", 0, "Redar", 1986, "Para", false);
            }
        }


        return book;
    }

    static void imprimirLivros() {
        System.out.println("---------Livros---------");
            for(Livro livro : livro){
                System.out.println("----");
                livro.imprimir(true);
            }
        System.out.println("------------------------");
    }

    static void realizarDevolucao() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Mostra os livros que tem alugado
        logged.imprimirLivros(true);

        // Qual livro
        System.out.print("Agora o nome do livro que deseja devolver: ");
        String livrorefer = scanner.nextLine();

        for(Livro book : livro) {
            if(book.getTitulo().equalsIgnoreCase(livrorefer)) {
                logged.devolverLivro(book);
                logged.imprimirLivros(false);
            }
        }
        // Fim de qual livro
        
    }

    static void realizarEmprestimo() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Mostra os livros
        imprimirLivros();

        // Qual livro
        System.out.print("Agora o nome do livro que deseja pegar emprestado: ");
        String livrorefer = scanner.nextLine();

        for(Livro book : livro) {
            if(book.getTitulo().equalsIgnoreCase(livrorefer)) {
                logged.pegarLivro(book);
            }
        }
        // Fim de qual livro

    }
}
