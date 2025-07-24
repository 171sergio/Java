import java.util.Date;

public class Aluno extends Usuario{

    String escola;

    public Aluno(String nome, String cpf, Date dataNascimento, String escola) {
        super(nome, cpf, dataNascimento);
        this.escola = escola;
    }

    boolean pegarLivro(Livro livro){
        boolean pego = false;
        if(livrosAlugados.size() < 5)
            pego = super.pegarLivro(livro);
        else
            System.out.println("Limite máximo de livros alugados alcançado");
        return pego;
    }
}