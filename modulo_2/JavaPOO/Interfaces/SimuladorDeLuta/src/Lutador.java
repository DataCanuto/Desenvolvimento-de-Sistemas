public class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;

    public Lutador() {
    }

    public Lutador(float altura, int derrotas, int empates, int idade, String nacionalidade, String nome, float peso, int vitorias) {
        this.altura = altura;
        this.derrotas = derrotas;
        this.empates = empates;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.nome = nome;
        this.setPeso(peso);
        this.vitorias = vitorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria() {
        if (this.peso < 52.2) {
            this.categoria = "Inválido";
        } else if (this.peso <= 70.3) {
            this.categoria = "Leve";
        } else if (this.peso <= 83.9) {
            this.categoria = "Médio";
        } else if (this.peso <= 120.2) {
            this.categoria = "Pesado";
        } else {
            this.categoria = "Inválido";
        }        
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = this.getVitorias() + 1;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = this.getDerrotas() + 1;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = this.getEmpates() + 1;
    }

    public void apresentar() {
        System.out.println("------------------------------");
        System.out.println("Lutador: " + this.getNome());
        System.out.println("Origem: " + this.getNacionalidade());
        System.out.println(this.getIdade() + " anos");
        System.out.println(this.getAltura() + " m de altura");
        System.out.println("Pesando: " + this.getPeso() + " kg");
        System.out.println("Ganhou: " + this.getVitorias());
        System.out.println("Perdeu: " + this.getDerrotas());
        System.out.println("Empatou: " + this.getEmpates());
    }

    public void status() {
        System.out.println("------------------------------");
        System.out.println(this.getNome() + " é um peso " + this.getCategoria());
        System.out.println("Ganhou: " + this.getVitorias() + " vezes");
        System.out.println("Perdeu: " + this.getDerrotas() + " vezes");
        System.out.println("Empatou: " + this.getEmpates() + " vezes");
    }

    public void vencerLuta() {
        setVitorias(this.getVitorias() + 1);        
    }

    public void perderLuta() {
        setDerrotas(this.getDerrotas() + 1);
    }

    public void empatarLuta() {
        setEmpates(this.getEmpates() + 1);
    }





}
