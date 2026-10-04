
import cartao.Cartao;
import cartao.Credito;
import cartao.Debito;
import conta.Conta;
import conta.Corrente;
import conta.Poupanca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import user.Client;
import user.User;

public class App {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Cartao> cartoes = new ArrayList<>();
    public static List<Conta> contas = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        do {
            globalMenu();
            int globalOption = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente
            switch(globalOption) {
                case 1 -> {
                    System.out.println("Acesso administrador selecionado.");
                    int opcaoAdm = 0;
                    do{
                        exibirMenuAdm();
                        opcaoAdm = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha pendente
                        switch (opcaoAdm) {
                            case 1 -> cadastrarConta();
                            case 2 -> cadastrarCartao();
                            case 3 -> exibirUsuarios();
                            case 4 -> exibirContas();
                            case 5 -> exibirCartoes();
                            case 6 -> System.out.println("Voltando ao menu principal...");
                            default -> System.out.println("Opção inválida. Tente novamente.");
                        }
                } while (opcaoAdm != 6);
                }
                case 2 -> {
                    System.out.println("Área do Usuário");
                    Client cliente = validacaoAcesso();
                    if (cliente == null) break;

                    int opClient = 0;
                    do {
                        menuCliente();
                        opClient = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha pendente
                        switch (opClient) {
                            case 1 -> System.out.println("Saldo: R$ " + cliente.getConta().getSaldo());
                            case 2 -> {
                                System.out.print("Informe o valor do depósito: R$ ");
                                double valorDeposito = scanner.nextDouble();
                                scanner.nextLine();
                                cliente.getConta().depositar(valorDeposito);
                            }
                            case 3 -> {
                                System.out.print("Informe o valor do saque: R$ ");
                                double valorSaque = scanner.nextDouble();
                                scanner.nextLine();
                                cliente.getConta().sacar(valorSaque);
                            }
                            case 4 -> {
                                if (cliente.getCartao() == null) {
                                    System.out.println("Você não possui cartão associado.");
                                    break;
                                }
                                menuCompras(cliente);
                            }
                            case 5 -> {
                                System.out.println("Saindo...");
                                break;
                            }
                            default -> System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (opClient != 5);
                }
                case 0 -> {
                    System.out.println("Encerrando o programa. Até logo!");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
        
    }

    public static Client validacaoAcesso() {
        System.out.println("\n==Menu de Acesso==");
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        User encontrado = null;
        for (User user : users) {
            if (user.getCpf().equals(cpf)) {
                encontrado = user;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("CPF não encontrado. Por favor, tente novamente.");
            return null;
        }

        if (encontrado.getConta() == null) {
            System.out.println("Usuário não possui conta associada.");
            return null;
        }

        System.out.println("Informe a senha: ");
        int senha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente

        if (senha != encontrado.getConta().getSenha()) {
            System.out.println("Senha incorreta. Por favor, tente novamente.");
            return null;
        }

        Client cliente = new Client(encontrado.getNome(), encontrado.getCpf(), encontrado.getEmail(), encontrado.getTelefone());
        cliente.setConta(encontrado.getConta());
        cliente.setCartao(encontrado.getCartao());
        System.out.println("Login bem-sucedido. Bem-vindo, " + cliente.getNome() + "!");
        return cliente;
    }
    
    public static void menuCliente() {
        System.out.println("\n==Menu do Cliente==");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar saque");
        System.out.println("4. Acessar cartão");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void menuCompras(Client cliente) {
        int opCartao = 0;
        do {
            System.out.println("\n==Realizar Compra==");
            System.out.println("Informe operação: 1 - Crédito, 2 - Débito, 3 - Voltar");
            opCartao = scanner.nextInt();
            scanner.nextLine();
            switch (opCartao) {
                case 1 -> {
                    if(cliente.getCartao() instanceof Credito){
                        System.out.println("\n==Cartão de Crédito==");
                    } else {
                        System.out.println("Você não possui um cartão de crédito associado.");
                        break;
                    }
                    System.out.print("Informe o valor da compra: R$ ");
                    double valorCompra = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Informe a senha do cartão (4 dígitos): ");
                    int senhaInformada = scanner.nextInt();
                    scanner.nextLine();
                    if (!validarSenhaCartao(senhaInformada)) {
                        break;
                    }
                    if (senhaInformada != cliente.getCartao().getSenha()) {
                        System.out.println("Senha incorreta. Operação cancelada.");
                        break;
                    }

                    ((Credito) cliente.getCartao()).realizarCompraCredito(valorCompra);
                    System.out.println("Limite disponível: R$ " + ((Credito) cliente.getCartao()).getLimite());
                    
                }
                case 2 -> {
                    System.out.println("\n==Cartão de Débito==");
                    System.out.print("Informe o valor da compra: R$ ");
                    double valorCompra = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Informe a senha do cartão (4 dígitos): ");
                    int senhaInformada = scanner.nextInt();
                    scanner.nextLine();
                    if (!validarSenhaCartao(senhaInformada)) {
                        break;
                    }
                    if (senhaInformada != cliente.getCartao().getSenha()) {
                        System.out.println("Senha incorreta. Operação cancelada.");
                        break;
                    }

                    ((Debito) cliente.getCartao()).realizarCompraDebito(valorCompra);
                    System.out.println("Saldo disponível: R$ " + ((Debito) cliente.getCartao()).getSaldo());
                }
                case 3 -> System.out.println("Voltando ao menu do cliente...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opCartao != 3);
    }






    public static boolean validarConta(String titular) {
        for (Conta conta : contas) {
            if (conta.getTitular().equals(titular)){
                return true;
            }
        }
        return false;
    }

    public static List<String> bandeirasAceitas = List.of("VISA", "MASTERCARD", "ELO");

    public static boolean verificarBandeira(String bandeira) {
        if (bandeirasAceitas.contains(bandeira)){
            System.out.println("Bandeira aceita.");
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarSenhaConta(int senha) {
        if (String.valueOf(senha).length() != 6) {
            System.out.println("Senha deve conter exatamente 6 dígitos.");
            return false;
        }
        return true;
    }

    public static boolean validarSenhaCartao(int senha) {
        if (String.valueOf(senha).length() != 4) {
            System.out.println("Senha deve conter exatamente 4 dígitos.");
            return false;
        }
        return true;
    }


    public static void cadastrarCartao() {
        Cartao cartao = new Cartao();

        System.out.println("\n==Cadastro de Cartão==");
        System.out.println("1. Informe o nome do titular do cartão: ");
        String titular = scanner.nextLine();
        if(!validarConta(titular)){
            System.out.println("Titular não encontrado. Por favor, cadastre uma conta primeiro.");
            return;
        }else{
            System.out.println("Seja bem vindo(a) " + titular + "! Vamos cadastrar seu cartão.");
            for(int i = 0; i < contas.size(); i++){
                if(contas.get(i).getTitular().equals(titular)){
                    cartao.setConta(contas.get(i));
                    break;
                }
            }
        }
        cartao.setTitular(cartao.getConta().getTitular());
        cartao.setSaldo(cartao.getConta().getSaldo());
        

        int bandeiraOp = 0;
        String bandeira = "";
        do{
            System.out.println("2. Informe a bandeira do cartão: \n1 - VISA, 2 - MASTERCARD, 3 - ELO");
            bandeiraOp = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente
            bandeira = switch(bandeiraOp) {
                case 1 -> bandeirasAceitas.get(0); // "VISA"
                case 2 -> bandeirasAceitas.get(1); // "MASTERCARD"
                case 3 -> bandeirasAceitas.get(2); // "ELO"
                default -> "Bandeira inválida";
            };
            cartao.setBandeira(bandeira);
        } while (!verificarBandeira(bandeira));
        int senha = 0;
        do {
            System.out.println("3. Informe a senha do cartao (4 digitos)");
            senha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente
            if(validarSenhaCartao(senha)){
                cartao.setSenha(senha);
                break;
            } else {
                System.out.println("Senha invalida. Por favor, tente novamente.");
            }
        } while (!validarSenhaCartao(senha));
        cartao.setNumeroCartao(bandeiraOp, "78945612");
        System.out.println("Deseja habilitar a função de crédito? (S/N)");
        String opcaoCredito = scanner.nextLine();
        Cartao cartaoFinal;
        switch (opcaoCredito.toUpperCase()) {
            case "S" -> {
                System.out.println("Defina um limite de crédito para o cartão: ");
                double limite = scanner.nextDouble();
                scanner.nextLine();
                Credito credito = new Credito(cartao.getTitular(), cartao.getNumeroCartao(), cartao.getBandeira(), cartao.getSenha(), cartao.getConta(), cartao.getSaldo(), limite);
                cartaoFinal = credito;
                System.out.println("Função de crédito habilitada com sucesso! Limite: R$ " + limite);
            }
            default -> {
                Debito debito = new Debito(cartao.getTitular(), cartao.getNumeroCartao(), cartao.getBandeira(), cartao.getSenha(), cartao.getConta(), cartao.getSaldo());
                cartaoFinal = debito;
                System.out.println("Cartão de débito cadastrado com sucesso.");
            }
        }
        cartoes.add(cartaoFinal);
        for (User user : users) {
            if (user.getNome().equals(cartaoFinal.getTitular())) {
                user.setCartao(cartaoFinal);
                System.out.println("Cartão associado ao cliente " + user.getNome() + " com sucesso!");
                break;
            }
        }
    }

    public static void cadastrarConta(){
        System.out.println("\n==Seja bem vindo(a) a agência 1234==");
        System.out.println("1. Informe nome do novo titular: ");
        String titular = scanner.nextLine();
        System.out.println("2. Informe o CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("3. Informe o email: ");
        String email = scanner.nextLine();
        System.out.println("4. Informe o telefone: ");
        String telefone = scanner.nextLine();
        System.out.println("5. Informe o valor do depósito inicial: ");
        double depositoInicial = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("6. Informe a senha da conta (6 dígitos): ");
        int senha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        Client cliente = new Client(titular, cpf, email, telefone);
        System.out.println("7. Gostaria de abrir uma conta poupança? (S/N)");
        String opcaoPoupanca = scanner.nextLine();
        switch (opcaoPoupanca.toUpperCase()) {
            case "S" ->{
                System.out.println("Conta poupança aberta com sucesso!");
                Poupanca novaPoupanca = new Poupanca(titular, "1234", "5678-9", depositoInicial, senha);
                novaPoupanca.setId(contas.size() + 1);
                contas.add(novaPoupanca);
                cliente.setConta(novaPoupanca);
                users.add(cliente);
            }
            case "N" -> {
                System.out.println("Conta corrente aberta com sucesso!");
                Corrente novaCorrente = new Corrente(titular, "1234", "5678-9", depositoInicial, senha);
                novaCorrente.setId(contas.size() + 1);
                contas.add(novaCorrente);
                cliente.setConta(novaCorrente);
                users.add(cliente);
            }
            default -> {
                System.out.println("Opção inválida. Tente novamente.");
                
            }
        }
    }

    public static void globalMenu(){
        System.out.println("\n==Menu Global==\n");
        System.out.println("1. Acesso administrador");
        System.out.println("2. Acesso cliente");
    }

    public static void exibirMenuAdm() {
        System.out.println("\n==Menu Principal==");
        System.out.println("1. Cadastrar Conta");
        System.out.println("2. Cadastrar Cartão");
        System.out.println("3. Cadastrar Usuário");
        System.out.println("4. Exibir Contas");
        System.out.println("5. Exibir Cartões");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirContas() {
        System.out.println("\n==Contas Cadastradas==");
        contas.forEach(conta -> {
            System.out.println("ID: " + conta.getId() + ", Titular: " + conta.getTitular() + ", Agência: " + conta.getAgencia() + ", Número da Conta: " + conta.getNumeroConta() + ", Saldo: " + conta.getSaldo()+
        ", Tipo da conta: " + (conta instanceof Poupanca ? "Poupança" : "Corrente"));
        });
    }

    public static void exibirCartoes() {
        System.out.println("\n==Cartões Cadastrados==");
        cartoes.forEach(cartao -> {
            System.out.println("Titular: " + cartao.getTitular() + ", Número do Cartão: " + cartao.getNumeroCartao() + ", Bandeira: " + cartao.getBandeira() + ", Saldo: " + cartao.getSaldo() + ", Dados da conta vinculada: " + cartao.getConta().getTitular() + ", Agência: " + cartao.getConta().getAgencia() + ", Número da Conta: " + cartao.getConta().getNumeroConta() + ", Saldo: " + cartao.getConta().getSaldo()+
        ", Tipo do cartão: " + (cartao instanceof Credito ? "Crédito" : "Débito"));
        });
    }

    public static void exibirUsuarios() {
        System.out.println("\n==Usuários Cadastrados==");
        users.forEach(user -> {
            System.out.println("Nome: " + user.getNome() + ", CPF: " + user.getCpf() + ", Email: " + user.getEmail() + ", Telefone: " + user.getTelefone() + ", Conta vinculada: " + (user.getConta() != null ? user.getConta().getNumeroConta() : "Nenhuma") + ", Cartão vinculado: " + (user.getCartao() != null ? user.getCartao().getNumeroCartao() : "Nenhum"));
        });
    }

}
