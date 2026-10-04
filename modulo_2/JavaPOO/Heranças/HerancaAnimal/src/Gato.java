public class Gato extends Animal {
    private boolean domesticado;

    public Gato(boolean domesticado) {
        super();
        this.domesticado = domesticado;
    }

    public Gato(){
        super();
    }

    public boolean getDomesticado(){
        return domesticado;
    }

    public void setDomesticado(boolean domesticado) {
        this.domesticado = domesticado;
    }

    @Override
    public  void emitirSom(){
        System.out.println("Miaaau");
             }

    public void animalData(){
        super.animalData();
    }
}
