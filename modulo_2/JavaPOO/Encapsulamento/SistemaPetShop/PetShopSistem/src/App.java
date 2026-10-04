import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var option = 0;

        var petMachine = new PetMachine();
        

        do{
            
        System.out.println("\nBem-vindo ao sistema de banho para pets! Por favor, escolha uma opção:");
        System.out.println("1. Verificar status da máquina");;
        System.out.println("2. Adicionar água na máquina");
        System.out.println("3. Adicionar shampoo na máquina");
        System.out.println("4. Colocar pet na máquina");
        System.out.println("5. Dar banho no pet");
        System.out.println("6. Remover pet da máquina");
        System.out.println("7. Limpar máquina");        
        System.out.println("8. Ligar máquina");
        System.out.println("9. Desligar máquina");
        System.out.println("0. Sair do sistema");
        option = scanner.nextInt();

        switch(option){
            case 1 -> {
                System.out.println("Status da máquina:");
                System.out.println("Ligada: " + petMachine.isOn());
                System.out.println("Limpa: " + petMachine.isClean());
                System.out.println("Nível de água: " + petMachine.getWaterLevel() + "L");
                System.out.println("Nível de shampoo: " + petMachine.getShampooLevel() + " ml");
                if(petMachine.hasPet()){
                    System.out.println("Há um pet na máquina: " + petMachine.getPet().getName());
                } else {
                    System.out.println("Não há nenhum pet na máquina.");
                }
            }
            case 2 -> petMachine.addWater();
            case 3 -> petMachine.addShampoo();
            case 4 -> {
                System.out.println("Digite o nome do pet:");
                String name = scanner.next();
                System.out.println("Digite a idade do pet:");
                int age = scanner.nextInt();
                var pet = new Pet(name, age, false);
                petMachine.placePet(pet);
            }
            case 5 -> petMachine.takeAShower();
            case 6 -> petMachine.removePet();
            case 7 -> petMachine.cleanMachine();
            case 8 -> {
                petMachine.setOn(true);
                System.out.println("Ligado");
            }
            case 9 -> {
                petMachine.setOn(false);
                System.out.println("Desligado");
            }
            case 0 -> System.out.println("Saindo do sistema. Obrigado por usar o sistema de banho para pets!");
            default -> System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            
        }
    }while(option != 0);
    }
    

    
}
