public class Livro extends Produto {
    private String autor;
    private String isbn;
    private int numeroPaginas;

    public Livro() {
    }

    public Livro(String autor, String isbn, int numeroPaginas) {
        super();
        this.autor = autor;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void exibirEtiqueta() {
        super.exibirEtiqueta();
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Número de Páginas: " + numeroPaginas);
    }

    public void abrirPrevisualizacao() {
        System.out.println("Abrindo pré-visualização do livro...");
    }


    

    
    
}
