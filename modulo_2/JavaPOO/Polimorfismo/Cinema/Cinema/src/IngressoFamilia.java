public class IngressoFamilia extends Ingresso {
    private int quantidadePessoas;

    public IngressoFamilia(double valor, String nomeFilme, boolean legendado, int quantidadePessoas) {
        super(valor, nomeFilme, legendado);
        this.quantidadePessoas = quantidadePessoas;
    }

    public IngressoFamilia() {}

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }
    
}
