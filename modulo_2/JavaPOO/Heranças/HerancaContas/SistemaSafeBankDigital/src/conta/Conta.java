package conta;

public class Conta {
    private int id;
    private String titular;
    private String agencia;
    private String numeroConta;
    private double saldo;
    private int senha;

    public Conta(String titular, String agencia, String numeroConta, double saldo, int senha) {
        this.titular = titular;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.senha = senha;
    }

    public Conta() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        if(String.valueOf(senha).length() != 6){
            System.out.println("Senha deve conter exatamente 6 dígitos.");
        } else {
            this.senha = senha;
        }
    }

    public void sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente");
        }else{
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso");
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de "+ valor +" realizado com sucesso");
    }

   

}
