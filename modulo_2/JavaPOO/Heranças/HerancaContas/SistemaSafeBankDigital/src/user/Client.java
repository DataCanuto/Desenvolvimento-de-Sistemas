package user;

import cartao.Cartao;
import conta.Conta;

public class Client extends User {
    private Conta conta;
    private Cartao cartao;

    public Client() {}
    
    public Client(String nome, String cpf, String email, String telefone) {
        super(nome, cpf, email, telefone);
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    

}
