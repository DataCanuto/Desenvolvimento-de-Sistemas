package conta;
public class Poupanca extends Conta {
    private double taxaSaque;
    private double rendimento;

    public Poupanca() {}

    // Construtor sem taxaSaque/rendimento (podem ser definidos depois via setters)
    public Poupanca(String titular, String agencia, String numeroConta, double saldo, int senha) {
        super(titular, agencia, numeroConta, saldo, senha);
    }

    // Construtor completo com taxaSaque e rendimento
    public Poupanca(String titular, String agencia, String numeroConta, double saldo, int senha, double taxaSaque, double rendimento) {
        super(titular, agencia, numeroConta, saldo, senha);
        this.taxaSaque = taxaSaque;
        this.rendimento = rendimento;
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }

    public void setTaxaSaque(double taxaSaque) {
        this.taxaSaque = taxaSaque;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    @Override
    public void sacar(double valor){
        if (valor <= 0) {
            System.out.println("Valor de saque inválido");
            return;
        }
        if (valor > this.getSaldo()) {
            System.out.println("Saldo insuficiente");
        }else{
            setSaldo(getSaldo() - (valor + this.taxaSaque));
            System.out.println("Saque realizado com sucesso");            
        }
    }
    public void depositar(double valor){
        if(valor <= 0){
            System.out.println("Valor de depósito inválido");
            return;
        }
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito de "+ valor +" realizado com sucesso");
    }

    public void calcularRendimento(){
        setSaldo(getSaldo() + getSaldo() * this.rendimento);
        System.out.println("Rendimento: " + getSaldo());
        
        System.out.println("Rendimento calculado com sucesso");
    }
} 
