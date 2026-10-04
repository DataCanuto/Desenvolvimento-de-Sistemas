public class Livro implements Publicacao {
    private String titulo;
    private String autor;
    private int totPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    //Construtor
    public Livro(String titulo, String autor, int totPaginas, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totPaginas = totPaginas;
        this.leitor = leitor;
    }

    public Livro() {
    }

    //Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPaginas() {
        return totPaginas;
    }

    public void setTotPaginas(int totPaginas) {
        this.totPaginas = totPaginas;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    public void detalhes() {
        System.out.println("Livro " + this.getTitulo() + " escrito por " + this.getAutor());
        System.out.println("Está aberto? " + this.isAberto());
        System.out.println("Páginas: " + this.getTotPaginas() + " página atual: " + this.getPagAtual());
        System.out.println("Sendo lido por " + this.getLeitor().getNome());
    }

    @Override
    public String toString() {
        return "Livro: {" +
                "\ntitulo='" + titulo + '\'' +
                "\nautor='" + autor + '\'' +
                "\ntotPaginas=" + totPaginas +
                "\npagAtual=" + pagAtual +
                "\naberto=" + aberto +
                "\nleitor=" + leitor.getNome() +
                '}';
    }

    @Override
    public void abrir() {
        setAberto(true);
        System.out.println("O livro " + this.getTitulo() + " foi aberto.");
    }

    @Override
    public void fechar() {
        setAberto(false);
    }

    @Override
    public void folhear(int p) {
        abrir();
        if (p > this.getTotPaginas()) {
            setPagAtual(0);
            fechar();
        } else {
            this.setPagAtual(p);
        }
    }

    @Override
    public void avancarPag() {
        setPagAtual(getPagAtual() + 1);
    }

    @Override
    public void voltarPag() {
        if (getPagAtual() > 0) {
            setPagAtual(getPagAtual() - 1);
        } else {
            setPagAtual(0);
            setAberto(false);
        }
    }

    


}
