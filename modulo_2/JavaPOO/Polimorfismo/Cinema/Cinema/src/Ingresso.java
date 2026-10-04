public class Ingresso {    
    private double valor;
    private String nomeFilme;
    private boolean legendado;

    public Ingresso(double valor, String nomeFilme, boolean legendado) {
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.legendado = legendado;
    }

    public Ingresso() {}

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public boolean isLegendado() {
        return legendado;
    }

    public void setLegendado(boolean legendado) {
        this.legendado = legendado;
    }

    
    



}
