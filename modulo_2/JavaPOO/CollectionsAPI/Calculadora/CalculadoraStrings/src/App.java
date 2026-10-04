import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe a operação: \n1 - Somar\n2 - Subtrair");
        var operationOption = scanner.nextInt();
        while(operationOption > 2 || operationOption < 1){
            System.out.println("Escolha uma operação válida");
            operationOption = scanner.nextInt();

        }
        var selectedOperation = Operation.values()[operationOption - 1];
        System.out.println("Informe os números que serão utilizados na operação separados por vírgula");
        var numbers = scanner.next();
        var numberArray = Arrays.stream(numbers.split(","))
                    .mapToLong(Long::parseLong)
                    .toArray();
        var result = selectedOperation.getOperationCallback().exec(numberArray);
        System.out.println("O resultado da operação é: " + result);
    }
}
