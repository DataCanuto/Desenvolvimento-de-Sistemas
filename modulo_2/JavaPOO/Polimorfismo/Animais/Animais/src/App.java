public class App {
    public static void main(String[] args) {

        Mamifero m = new Mamifero();
        m.setPeso(85.3f);
        m.setIdade(2);
        m.setMembros(4);
        System.out.println("Mamífero:");
        m.locomover();
        m.alimentar();
        m.emitirSom();

        Reptil r = new Reptil();
        r.setPeso(0.8f);
        r.setIdade(1);
        r.setMembros(4);
        System.out.println("\nRéptil:");
        r.locomover();
        r.alimentar();
        r.emitirSom();

        Peixe p = new Peixe();
        p.setPeso(0.35f);
        p.setIdade(1);
        p.setMembros(0);
        System.out.println("\nPeixe:");
        p.locomover();
        p.alimentar();
        p.emitirSom();

        Ave a = new Ave();
        a.setPeso(0.89f);
        a.setIdade(3);
        a.setMembros(2);
        System.out.println("\nAve:");
        a.locomover();
        a.alimentar();
        a.emitirSom();
        
    }
}
