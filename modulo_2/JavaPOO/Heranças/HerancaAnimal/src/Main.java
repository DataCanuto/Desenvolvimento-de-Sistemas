public class Main {
    public static void main(String[] args) {
        

        Gato azula = new Gato();
        azula.especie = "British Short-Hair";
        azula.idade = 1;

        azula.emitirSom();

        azula.animalData();

        System.out.println("\n===========================\n" );
        

        Cachorro borogodo = new Cachorro();
        borogodo.especie = "Caramelo";
        borogodo.idade = 7;

        borogodo.emitirSom();

        borogodo.animalData();

        System.out.println("===== Programa Finalizado =====");
    }
}