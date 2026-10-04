package Calculadora;

public class Calculadora {
    private double actual;
    private String operation = "";
    private boolean novaEntrada;

    public Calculadora(){};

    public String inserirNumero(String displayAtual, String num){
        if(novaEntrada){
            novaEntrada = false;
            return num;
        }

        return displayAtual + num;
    }

    public double processarOperacao(double actualV, String NewOperation){
        if(operation.isEmpty()){
            actual = actualV;
        }else{
            actual = calcular(actual,actualV,operation);
        }
        this.operation = NewOperation;
        novaEntrada = true;
        return actual;
    }

    public double calcularResultado(double actualV){
        actual = calcular(actual,actualV,operation);

        operation = "";
        novaEntrada = true;

        return actual;
    }

    public static String formatarResultado(double resultado){
        if(resultado ==(long) resultado){
            return String.valueOf((long) resultado);
        }
        return String.valueOf(resultado);
    }


    private double calcular(double a, double b, String operation){
        return switch (operation) {
            case "+" -> a+b;
            case "-" -> a-b;
            case "x" -> a*b;
            case "/" -> { 
                if(b==0){
                    System.err.println("Erro: divisão por 0");
                    yield b;
                }
                yield a / b;
            }
            

                
            default -> b;
        };
    }

}

