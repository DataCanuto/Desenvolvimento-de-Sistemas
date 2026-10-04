package cartao;
import conta.Conta;

public class Credito extends Cartao{
    private double limite;

    public Credito() {}

    // Construtor sem limite (limite definido depois via setLimite)
    public Credito(String titular, String numeroCartao, String bandeira, int senha, Conta conta, double saldo) {
        super(titular, numeroCartao, bandeira, senha, conta, saldo);
    }

    // Construtor completo com limite
    public Credito(String titular, String numeroCartao, String bandeira, int senha, Conta conta, double saldo, double limite) {
        super(titular, numeroCartao, bandeira, senha, conta, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public double getSaldo() {
        return this.getLimite();
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    
    
    public void realizarCompraCredito(double v){
        if(this.getLimite() < v){
            System.out.println("Limite insuficiente");
            return;
        }else{
            System.out.println("Operação realizada com sucesso!");
            this.setLimite(this.getLimite() - v);
            return;
        }
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Limite: R$ " + limite);
    }
    
    
    
        
    
    
}
