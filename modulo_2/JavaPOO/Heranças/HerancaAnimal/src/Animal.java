public abstract class Animal {
    public String especie;
    public int idade;

    public Animal(String especie, int idade) {
        this.especie = especie;
        this.idade = idade;
    }

    public Animal() {
    }

    private void setTextIdade() {
        String text = "";
       if (this.idade <= 1){
           System.out.println("Idade: "+this.idade + " ano de idade");
       }else{
           System.out.println("Idade: "+this.idade + " anos de idade");
       }
    }


    public abstract void emitirSom();

    public void animalData(){
        System.out.println("Dados do animal:");
        System.out.println("Especie: " + especie);
        setTextIdade();
    }

}

