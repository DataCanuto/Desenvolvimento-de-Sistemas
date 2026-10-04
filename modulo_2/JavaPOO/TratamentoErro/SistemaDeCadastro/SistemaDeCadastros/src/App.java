import java.util.Scanner;

public class App {
    //Escopo global
    private final static UserDAO dao = new UserDAO();

    private final static Scanner scanner = new Scanner(System.in);





    public static void main(String[] args) {
      


        while (true) {
            System.out.println("Bem vindo ao sistema de cadastro de usuários!");
            System.out.println("Selecione a opção desejada:");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Atualizar usuário");
            System.out.println("3. Deletar usuário");
            System.out.println("4. Buscar usuário por id");
            System.out.println("5. Listar usuários");
            System.out.println("6. Sair");

            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values()[userInput -1];
            
            switch(selectedOption){
                case SAVE -> {
                    dao.save(addUser());
                    System.out.println("Usuário cadastrado com sucesso!");                    
                }
                case UPDATE -> {
                    try {
                        dao.update(updateUser());
                        System.out.println("Usuário atualizado com sucesso!");
                        dao.orderById();
                        
                    } catch (UserNotFoundException | EmptyStorageException e) {
                        System.out.println(e.getMessage());
                    }
                                  
                } 
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("Usuário deletado com sucesso!");
                    } catch(UserNotFoundException | EmptyStorageException e){
                        System.out.println(e.getMessage());
                    }
                }
                case FIND_BY_ID -> {
                    try{
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.println("Usuário com id " + id + ":\n" + user.toString());
                    } catch(UserNotFoundException | EmptyStorageException e){
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("Operação de busca por id finalizada.");
                    }

                    
                }
                case FIND_ALL -> listUsers();
                case EXIT -> {
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                }
            }

        }         
              
    }

    private static int requestId(){
        System.out.println("Digite o id do usuário:");
        return scanner.nextInt();
    }

    private static UserModel addUser(){
        System.out.println("Digite o nome do usuário:");
        var name = scanner.next();

        System.out.println("Digite o email do usuário:");
        var email = scanner.next();

        System.out.println("Digite a data de nascimento do usuário (formato: yyyy-MM-dd):");
        var dateOfBirth = scanner.next();

        var user = new UserModel(0, name, email, java.time.LocalDate.parse(dateOfBirth));
        return validateInputs(user);       

    }

    private static UserModel validateInputs(final UserModel user) {
        try {
            UserValidator.VerifyModel(user);
            return user;
        } catch (ValidatorException e) {
            System.out.println("Erro de validação: " + e.getMessage());
            return null;
        }
    }

    private static UserModel updateUser(){
        System.out.println("Digite o id do usuário a ser atualizado:");
        var id = scanner.nextInt();

        System.out.println("Digite o nome do usuário:");
        var name = scanner.next();

        System.out.println("Digite o email do usuário:");
        var email = scanner.next();

        System.out.println("Digite a data de nascimento do usuário (formato: yyyy-MM-dd):");
        var dateOfBirth = scanner.next();

        var user = new UserModel(id, name, email, java.time.LocalDate.parse(dateOfBirth));
        return validateInputs(user);
    }

    private static void listUsers(){
        var users = dao.findAll();
        users.forEach(u -> System.out.println(u.getId() + " - " + u.getName() + " - " + u.getEmail() + " - " + u.getDateOfBirth()));
    }

   

    

    
}
