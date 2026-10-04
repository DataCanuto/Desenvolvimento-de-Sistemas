package cartao;
import conta.Conta;

public class Cartao {
    private String titular;
    private String numeroCartao;
    private String bandeira;
    private int senha;
    private Conta conta;
    private double saldo;

    public Cartao(String titular, String numeroCartao, String bandeira, int senha, Conta conta, double saldo) {
        this.titular = titular;
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.senha = senha;
        this.conta = conta;
        this.saldo = saldo;
    }

    public Cartao() {
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCartao() {
        String firstFourDigits = this.numeroCartao.substring(0, 4);
        String secondFourDigits = this.numeroCartao.substring(4, 8);
        String thirdFourDigits = this.numeroCartao.substring(8, 12);

        return firstFourDigits + " " + secondFourDigits + " " + thirdFourDigits;
    }

    public void setNumeroCartao(int opBandeira, String numeroCartao) {
        switch (opBandeira) {
            case 1 -> this.numeroCartao = "4025" + numeroCartao; // VISA
            case 2 -> this.numeroCartao = "5208" + numeroCartao; // MASTERCARD
            case 3 -> this.numeroCartao = "6416" + numeroCartao; // ELO
            default -> this.numeroCartao = "XXXX" +numeroCartao; // Caso a bandeira seja inválida, mantém o número original
        }
        
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
            if(String.valueOf(senha).length() != 4){
                System.out.println("Senha deve conter exatamente 4 dígitos.");
            } else {
                this.senha = senha;
            }
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void exibirDetalhes(){
        System.out.println("Titular: " + titular);
        System.out.println("Número do Cartão: " + getNumeroCartao());
        System.out.println("Bandeira: " + bandeira);
        System.out.println("Saldo: R$ " + saldo);
    }

}
