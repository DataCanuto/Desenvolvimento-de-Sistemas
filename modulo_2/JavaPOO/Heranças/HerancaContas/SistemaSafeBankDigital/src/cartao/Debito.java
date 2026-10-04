package cartao;
import conta.Conta;

public class Debito extends Cartao{

    public Debito() {}

    public Debito(String titular, String numeroCartao, String bandeira, int senha, Conta conta, double saldo) {
        super(titular, numeroCartao, bandeira, senha, conta, saldo);
    }
    
    @Override
    public double getSaldo() {
        return this.getConta().getSaldo();
    }

    public void realizarCompraDebito(double v){
        if(this.getConta().getSaldo() < v){
            System.out.println("Saldo insuficiente");
            return;
        } else {
            this.getConta().sacar(v);
            System.out.println("Pagamento de R$ " + v + " realizado com sucesso!");
        }
    }        
}
