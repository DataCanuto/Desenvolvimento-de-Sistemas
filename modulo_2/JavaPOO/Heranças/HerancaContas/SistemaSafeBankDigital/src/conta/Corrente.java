package conta;
public class Corrente extends Conta {
    private double limite;

    public Corrente() {}

    // Construtor sem limite (limite pode ser definido depois via setLimite)
    public Corrente(String titular, String agencia, String numeroConta, double saldo, int senha) {
        super(titular, agencia, numeroConta, saldo, senha);
    }

    // Construtor completo com limite
    public Corrente(String titular, String agencia, String numeroConta, double saldo, int senha, double limite) {
        super(titular, agencia, numeroConta, saldo, senha);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor > this.getSaldo()) {
            System.out.println("Saldo insuficiente");
            if (valor - this.getSaldo() > this.limite){
                System.out.println("Limite insuficiente");
            }else{
                setLimite(getLimite() - (valor - this.getSaldo()));
                setSaldo(0);
                System.out.println("Saque realizado com sucesso utilizando o limite");
            }
        }else{
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso");
        }   
    }
    public void depositar(double valor){
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito de "+ valor +" realizado com sucesso");
    }
}
