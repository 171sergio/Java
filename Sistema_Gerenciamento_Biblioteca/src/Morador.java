import java.util.Date;

public class Morador extends Usuario{

    public Morador(String nome, String cpf, Date dataNascimento) {
        super(nome, cpf, dataNascimento);
    }

    boolean pegarLivro(Livro livro){
        boolean pego = false;
        if(livrosAlugados.size() < 2)
            pego = super.pegarLivro(livro);
        else
            System.out.println("Limite máximo de livros alugados alcançado");
        return pego;
    }
}