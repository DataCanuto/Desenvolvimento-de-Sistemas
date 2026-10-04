//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.setMarca("Ford");
        carro.setModelo("Ká");
        carro.setNum_portas(2);

        carro.exibirVeiculo();

        carro.stringVeiculo();

        Moto moto = new Moto();
        moto.setMarca("Honda");
        moto.setModelo("CG");
        moto.setCilindradas(160);

        moto.exibirVeiculo();
        moto.stringVeiculo();



    }
}