public class Eletronico extends Produto{
    private int voltagem;
    private int garantiaMeses;

    public Eletronico() {
    }

    public Eletronico(int voltagem, int garantiaMeses){
        super();
        this.voltagem = voltagem;
        this.garantiaMeses = garantiaMeses;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void exibirEtiqueta() {
        super.exibirEtiqueta();
        System.out.println("Voltagem: " + voltagem + "V");
        System.out.println("Garantia: " + garantiaMeses + " meses");
    }

    public double calcularFrete() {
        return 20.0; // Valor fixo para o frete de eletrônicos
    }

    public double aplicarDesconto(double percentual) {
        setPreco(this.getPreco() - (this.getPreco() * percentual / 100));
        return this.getPreco();
    }

    public double valorFinal() {
        return this.getPreco() + calcularFrete();
    }

    public void verificaCompatibilidade(int voltagem) {
        if (this.voltagem == voltagem) {
            System.out.println("Compatível com a voltagem informada.");
        } else {
            System.out.println("Incompatível com a voltagem informada.");
        }
    }
    
    public double calcularConsumo(int horasUso) {
        double potencia = this.voltagem * 0.5; // Exemplo de potência em watts
        return (potencia * horasUso / 1000.0); // Exemplo de cálculo de consumo em kw/h       
    }


    
}
