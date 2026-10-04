public class App {
    public static void main(String[] args) {
        
        Pessoa[] p = new Pessoa[2];
        Livro[] l = new Livro[3];

        p[0] = new Pessoa("Pedro", 22, "Masculino");
        p[1] = new Pessoa("Maria", 31, "Feminino");

        l[0] = new Livro("Aprendendo Java", "José da Silva", 300, p[0]);
        l[1] = new Livro("POO para Iniciantes", "Maria Oliveira", 500, p[1]);
        l[2] = new Livro("Java Avançado", "Ana Paula", 800, p[0]);

        
        l[1].folhear(1000);

        l[1].detalhes();                 
        
    }
}
