public class Mamifero extends Animal {


    @Override
    public void locomover() {
        System.out.println("Caminhando");
    }

    @Override
    public void alimentar() {
        System.out.println("Mamando");
    }

    @Override
    public void emitirSom() {
        System.out.println("Som de mamífero");
    }
    
}
