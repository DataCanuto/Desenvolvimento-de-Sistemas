public class Conta {
    private int id;
    private String titular;
    private EnumAgencia agencia;
    private EnumConta conta;
    private double saldo;

    public Conta() {
    }

    public Conta(int id, String titular, EnumAgencia agencia, EnumConta conta, double saldo) {
        this.id = id;
        this.titular = titular;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }
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
    public EnumAgencia getAgencia() {
        return agencia;
    }
    public void setAgencia(EnumAgencia agencia) {
        this.agencia = agencia;
    }
    public EnumConta getConta() {
        return conta;
    }
    public void setConta(EnumConta conta) {
        this.conta = conta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        if(saldo >= 0){
            this.saldo = saldo;
        }else{
            this.saldo = 0;
        }
        
    }

    public boolean sacar(double valor){
        return valor >= this.getSaldo();
    }

    public void sacar(boolean function, double valor){
        if(function){
            setSaldo(getSaldo() - valor);
        }
    }

    public boolean depositar(double valor){
        return valor >= 0;
    }

    public void depositar(boolean function, double valor){
        if(function){
            setSaldo(getSaldo() + valor);
        }
    }

    @Override
    public String toString() {
        return "Conta [getId()=" + getId() + ", getTitular()="
        + getTitular() + ", getAgencia()=" + getAgencia().getNumeroAgencia()
                + ", getConta()=" + getConta().getNumeroConta() + ", getSaldo()="
                + getSaldo() + ", getClass()=" + getClass() + "]";
    }

    

    

}
