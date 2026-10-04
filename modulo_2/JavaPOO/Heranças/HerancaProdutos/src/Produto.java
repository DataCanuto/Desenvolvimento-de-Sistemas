public class Produto {
    private String nome;
    private double preco;
    private String codigoBarras;

    
    public Produto(String nome, double preco, String codigoBarras) {
        this.nome = nome;
        this.preco = preco;
        this.codigoBarras = codigoBarras;
    }


    public Produto() {
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String getCodigoBarras() {
        return codigoBarras;
    }


    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void exibirEtiqueta(){
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Código de Barras: " + codigoBarras);
        System.out.println("Valor do frete: R$ " + calcularFrete());
        System.out.println("Preço com desconto de 10%: R$ " + calcularDesconto(10));
        System.out.println("Preço final: R$ " + valorFinal());
    }

    public double calcularFrete(){
        return 10.0; // Valor fixo para o frete
    }

    public double calcularDesconto(double percentual) {
        setPreco(this.preco - (this.preco * percentual / 100));
        return this.preco;
    }

    public double valorFinal(){
        return this.preco + calcularFrete();
    }

    
    
}
