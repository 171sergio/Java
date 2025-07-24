import java.util.Date;
import java.util.ArrayList;

public class Usuario {

    String nome;
    String cpf;
    Date dataNascimento;
    static int id = 0;
    ArrayList<Livro> livrosAlugados  = new ArrayList<>();;

    public Usuario(String nome, String cpf, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        id = id++;
    }

    boolean devolverLivro(Livro livro) {
        boolean devolvido = false;
        if(livrosAlugados.contains(livro)) {
            livro.setQuantidade(1);
            livrosAlugados.remove(livro);
            devolvido = true;
            System.out.println("Sucesso");
        }
        return devolvido;
    }

    boolean pegarLivro(Livro livro) {
        boolean pego = false;
        if (livro.quantidade > 0) {
            livro.setQuantidade(-1);
            livrosAlugados.add(livro);
            pego = true;
            System.out.println("Sucesso");
        } else if (livro.quantidade == 0) {
            System.out.println("Todas as copias ja foram alugadas...");
        } else {
            System.out.println("Não temos esse livro ou não existe...");
    }

        this.imprimirLivros(false);
        return pego;
    }

    void imprimirLivros(boolean amount){
        System.out.println("-------Livros Alugados-------");
        for(Livro livro : livrosAlugados){
            livro.imprimir(amount);
        }
        System.out.println("-----------------------------");
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

}
