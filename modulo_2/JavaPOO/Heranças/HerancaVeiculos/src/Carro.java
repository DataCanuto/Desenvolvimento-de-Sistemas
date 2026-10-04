public class Carro extends Veiculo{
    private int num_portas;

    public Carro(int num_portas) {
        this.num_portas = num_portas;
    }

    public Carro(){

    }

    public int getNum_portas() {
        return num_portas;
    }
    public void setNum_portas(int num_portas) {
        this.num_portas = num_portas;
    }

    @Override
    public void exibirVeiculo(){
        super.exibirVeiculo();
        System.out.println("Nº de portas: " + this.num_portas);
    }
    public void stringVeiculo(){
        super.stringVeiculo("Carro"," e tem "+this.num_portas+" portas");
    }
}
