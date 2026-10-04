
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Ingresso> ingressos = new ArrayList<>();
    private static int valorInteira = 50;
    private static double valorTotal = 0;    
    
    public static void main(String[] args) throws Exception {
        int main_option;
        do{
            System.out.println("Bem-vindo a bilheteria do cinema!");
            System.out.println("1 - Vender ingressos");
            System.out.println("2 - Relatório de ingressos vendidos");
            System.out.println("0 - Sair");
            main_option = scanner.nextInt();

            switch(main_option){
                case 1 -> venderIngresso();
                case 2 -> exibirIngressos();
                case 0 -> System.out.println("Obrigado por usar o sistema de bilheteria do cinema!");
                default -> System.out.println("Opção inválida");
            }

            
        }while(main_option != 0);
        
    }

    public static void exibirIngressos(){
        if(ingressos.isEmpty()){
            System.out.println("Nenhum ingresso vendido ainda.");
        } else {
            System.out.println("Ingressos vendidos:");
            for(Ingresso ingresso : ingressos){
                String tipoIngresso = (ingresso instanceof MeiaEntrada) ? "Meia Entrada" : "Inteira";
                String detalhes = "";
                if(ingresso instanceof MeiaEntrada){
                    detalhes = " - Tipo de meia: " + ((MeiaEntrada) ingresso).getTipoMeia();
                } else if(ingresso instanceof IngressoFamilia){
                    detalhes = " - Quantidade de pessoas: " + ((IngressoFamilia) ingresso).getQuantidadePessoas();
                }
                System.out.println("Filme: " + ingresso.getNomeFilme() + ", Valor: R$" + ingresso.getValor() + ", Legendado: " + (ingresso.isLegendado() ? "Sim" : "Não") + ", Tipo: " + tipoIngresso + detalhes);
            }
            System.out.println("Valor total arrecadado: R$" + valorTotal);
        }
    }
    public static void venderIngresso(){
            scanner.nextLine(); // Consumir a quebra de linha pendente
            System.out.println("Informe o nome do filme: ");
            String nomeFilme = scanner.nextLine();
            System.out.println("O filme é legendado? (S/N): ");
            String legendado = scanner.nextLine();
            boolean isLegendado = false;
            if (legendado.equals("S")){
                isLegendado = true;
            } else if (legendado.equals("N")){
                isLegendado = false;
            } else {
                System.out.println("Resposta inválida. Por favor, informe 'S' para sim ou 'N' para não.");
                return;
            }
            
            System.out.println("Informe quantos ingressos deseja comprar: ");
            int quantidadeIngressos = scanner.nextInt();
            if (quantidadeIngressos <= 0) {
                System.out.println("Quantidade de ingressos deve ser maior que zero.");
                return;
            }else if(quantidadeIngressos < 3){
                for(int i = 0; i < quantidadeIngressos; i++) {
                    System.out.println("Informe o tipo do" + (i+1) + "º ingresso (1 - Inteira, 2 - Meia Entrada): ");
                    int tipoIngresso = scanner.nextInt();
                    switch(tipoIngresso) {
                        case 1:
                            Ingresso ingresso = new Ingresso(valorInteira, nomeFilme, isLegendado);
                            ingressos.add(ingresso);
                            valorTotal += ingresso.getValor();
                            break;
                        case 2:
                            System.out.println("Informe o tipo da meia entrada (1 - Estudante, 2 - De menor, 3 - Idoso, 4 - Doador de sangue: ");
                            int op_meia = scanner.nextInt();
                            String tipoMeia = "";
                            switch(op_meia) {
                                case 1:
                                    tipoMeia = "Estudante";
                                    break;
                                case 2:
                                    tipoMeia = "De menor";
                                    break;
                                case 3:
                                    tipoMeia = "Idoso";
                                    break;
                                case 4:
                                    tipoMeia = "Doador de sangue";
                                    break;
                                default:
                                    System.out.println("Opção inválida para tipo de meia entrada.");
                                    return;
                            }
                            Ingresso meiaEntrada = new MeiaEntrada(valorInteira / 2, nomeFilme, isLegendado, tipoMeia);
                            ingressos.add(meiaEntrada);
                            valorTotal += meiaEntrada.getValor();
                            break;
                        default:
                            System.out.println("Opção inválida para tipo de ingresso.");
                            return;
                    }
                    
                }
            }else if(quantidadeIngressos >= 3){
                
                for(int i = 0; i < quantidadeIngressos; i++) {
                    System.out.println("Informe o tipo do" + (i+1) + "º ingresso (1 - Inteira, 2 - Meia Entrada): ");
                    int tipoIngresso = scanner.nextInt();
                    switch(tipoIngresso) {
                        case 1:
                            Ingresso ingresso = new Ingresso(valorInteira, nomeFilme, isLegendado);
                            valorTotal += ingresso.getValor();
                            ingressos.add(ingresso);
                            break;
                        case 2:
                            System.out.println("Informe o tipo da meia entrada (1 - Estudante, 2 - De menor, 3 - Idoso, 4 - Doador de sangue: ");
                            int op_meia = scanner.nextInt();
                            String tipoMeia = "";
                            switch(op_meia) {
                                case 1:
                                    tipoMeia = "Estudante";
                                    break;
                                case 2:
                                    tipoMeia = "De menor";
                                    break;
                                case 3:
                                    tipoMeia = "Idoso";
                                    break;
                                case 4:
                                    tipoMeia = "Doador de sangue";
                                    break;
                                default:
                                    System.out.println("Opção inválida para tipo de meia entrada.");
                                    return;
                            }
                            Ingresso meiaEntrada = new MeiaEntrada(valorInteira / 2, nomeFilme, isLegendado, tipoMeia);
                            ingressos.add(meiaEntrada);
                            valorTotal += meiaEntrada.getValor();
                            break;
                        default:
                            System.out.println("Opção inválida para tipo de ingresso.");
                            return;
                    }
                    valorTotal = valorTotal * 0.95; // Aplica desconto de 5% para compras de 3 ou mais ingressos                
                }
            }
    }
}
