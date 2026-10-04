public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Camiseta", 29.99, "123456789");
        produto1.exibirEtiqueta();
        System.out.println("Frete: R$ " + produto1.calcularFrete());
        System.out.println("Preço com desconto de 10%: R$ " + produto1.calcularDesconto(10));
        System.out.println("Preço final: R$ " + produto1.valorFinal());

        System.out.println("\n---\n");

        Eletronico eletronico1 = new Eletronico(220, 24);
        eletronico1.setNome("Smartphone");
        eletronico1.setPreco(1999.99);
        eletronico1.setCodigoBarras("987654321");
        eletronico1.exibirEtiqueta();
        

        eletronico1.verificaCompatibilidade(110);
        System.out.println("Consumo em 24 horas: " + eletronico1.calcularConsumo(24) + " kWh");


        System.out.println("\n---\n");
        Livro livro1 = new Livro("Anildo", "978-3-16-148410-0", 350);
        livro1.setNome("Java para Iniciantes");
        livro1.setPreco(59.99);
        livro1.setCodigoBarras("555555555");
        livro1.exibirEtiqueta();
        livro1.abrirPrevisualizacao();

    }
}