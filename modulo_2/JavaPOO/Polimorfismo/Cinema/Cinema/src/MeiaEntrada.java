public class MeiaEntrada extends Ingresso {
    private String tipoMeia;

    public MeiaEntrada(double valor, String nomeFilme, boolean legendado, String tipoMeia) {
        super(valor, nomeFilme, legendado);
        this.tipoMeia = tipoMeia;
    }   

    public MeiaEntrada() {}

    public String getTipoMeia() {
        return tipoMeia;
    }

    public void setTipoMeia(String tipoMeia) {
        this.tipoMeia = tipoMeia;
    }
    
}
