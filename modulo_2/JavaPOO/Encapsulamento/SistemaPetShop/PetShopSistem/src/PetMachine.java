public class PetMachine {

    private boolean clean;
    private boolean isOn;
    private double waterLevel;
    private double shampooLevel;
    private Pet pet;

    

    public PetMachine(boolean clean, boolean isOn, double waterLevel, double shampooLevel, Pet pet) {
        this.clean = clean;
        this.isOn = isOn;
        this.waterLevel = waterLevel;
        this.shampooLevel = shampooLevel;
        this.pet = pet;
    }

    
    public PetMachine() {
    }

    



    public boolean isClean() {
        return clean;
    }


    public void setClean(boolean clean) {
        this.clean = clean;
    }


    public boolean isOn() {
        return isOn;
    }


    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }


    public double getWaterLevel() {
        return waterLevel;
    }


    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }


    public double getShampooLevel() {
        return shampooLevel;
    }


    public void setShampooLevel(double shampooLevel) {
        this.shampooLevel = shampooLevel;
    }


    public Pet getPet() {
        return pet;
    }




    public void placePet(Pet pet) {
        this.pet = pet;
    }

    public void takeAShower(){
        if(!this.isOn()){
            System.out.println("Por favor, ligue a máquina de banho para começar o banho do seu pet.");
            return;
        }
        if(!isClean()){
            System.out.println("A máquina de banho está suja. Por favor, limpe a máquina antes de dar banho no seu pet.");
            return;
        }
        if(!hasPet()){
            System.out.println("Por favor, coloque um pet na máquina para começar o banho.");
            return;
        }
        if(this.getWaterLevel() < 20){
            System.out.println("Nível de água insuficiente. Por favor, adicione mais água para dar banho no seu pet.");
            return;
        }
        if(this.getShampooLevel() < 3){
            System.out.println("Nível de shampoo insuficiente. Por favor, adicione mais shampoo para dar banho no seu pet.");
            return;
        }
        pet.setClean(true);
        this.setClean(false);
        System.out.println("Banho do pet " + pet.getName());
        System.out.println("O banho do seu pet foi concluído com sucesso!");
        setWaterLevel(this.getWaterLevel() - 20);
        setShampooLevel(this.getShampooLevel() - 3);
    }

    public void addWater(){
        if(this.getWaterLevel() >= 100){
            System.out.println("O nível de água já está cheio. Não é necessário adicionar mais água.");
            return;
        }
        this.setWaterLevel(this.getWaterLevel() + 10);
        System.out.println("Água adicionada com sucesso. O nível de água agora está cheio.");
    }
    
    public void addShampoo(){
        if(this.getShampooLevel() >= 5){
            System.out.println("O nível de shampoo já está cheio. Não é necessário adicionar mais shampoo.");
            return;
        }
        this.setShampooLevel(this.getShampooLevel() + 0.5);
        System.out.println("Shampoo adicionado com sucesso. O nível de shampoo agora está cheio.");
    }

    public boolean hasPet(){
        return this.getPet() != null;
    }

    public void removePet(){
        
        if(hasPet()){
            this.setClean(this.pet.isClean());
            System.out.println(this.pet.getName() + " está pronto para sair da máquina de banho.");
            this.pet = null;
        }
    }

    public void cleanMachine(){
        if(this.isOn()){
            System.out.println("Desligue a máquina para iniciar a limpeza.");
            return;
        }
        this.setClean(true);
        System.out.println("A máquina de banho foi limpa com sucesso!");
    }

    

}


