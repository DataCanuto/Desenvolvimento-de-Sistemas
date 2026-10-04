public class App {
    public static void main(String[] args){

        Conta c = new Conta(0,"Pedro Canuto",EnumAgencia.AG_3466,EnumConta.CC_123974,1000);

        System.out.println(c.toString());

        System.out.println(("==================\n"));

        System.out.println(c.getSaldo());

        var valor = 90;
        var deposito = c.depositar(valor);

        c.depositar(deposito,valor);

        System.out.println(("==================\n"));
        System.out.println(c.getSaldo());

        var valorSaque = 2000;
        var saque = c.sacar(valorSaque);

        c.sacar(saque,valorSaque);

        System.out.println(("==================\n"));
        System.out.println(c.getSaldo());
        


        

    }
}
