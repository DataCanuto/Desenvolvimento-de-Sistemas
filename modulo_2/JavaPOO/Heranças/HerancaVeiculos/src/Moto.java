public class Moto extends Veiculo{
    private int cilindradas;

    public Moto(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public Moto(){

    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirVeiculo(){
        super.exibirVeiculo();
        System.out.println("Cilindradas: " + this.cilindradas);
    }

    public void stringVeiculo(){
        super.stringVeiculo("Moto", " e tem "+this.cilindradas+" cilindradas");
            }
}
