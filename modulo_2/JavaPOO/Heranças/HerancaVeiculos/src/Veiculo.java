public class Veiculo {
    private String marca;
    private String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Veiculo() {

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void exibirVeiculo(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
    }

    public void stringVeiculo(String classe, String txt){
        System.out.println(classe + " da marca " + this.marca+",  modelo " + this.modelo + txt+".");
    }
}
