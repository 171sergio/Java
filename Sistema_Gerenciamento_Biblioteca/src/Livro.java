
public class Livro {
    String titulo;
    String autor;
    int AnoDePublicacao;
    String editora;
    int quantidade;
    boolean existo;

    public Livro(String titulo, int quantidade, String editora, int birth, String autor, boolean existo) {
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.editora = editora;
        this.AnoDePublicacao = birth;
        this.autor = autor;
        this.existo = existo;
    }

    public void imprimir(boolean amount) {
        if(!existo) {
            return;
        }
        System.out.println("Livro:" + titulo + " de: " + autor);
        System.out.println("Em: " + AnoDePublicacao + " Pela Editora:" + editora);

        //nem sempre eu quero que a quantidade seja visivel
        if(amount) {
            System.out.println("Quantidade: " + quantidade);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }
}