import domain.Contact;
import static domain.ContactType.EMAIL;
import static domain.ContactType.PHONE;
import domain.Sex;
import static domain.Sex.FEMALE;
import static domain.Sex.MALE;
import domain.User;
import java.util.ArrayList;
import java.util.List;

public class App {
    
    public static void main(String[] args){
        List<User> users = new ArrayList<>(generateUsers());

        //users.sort((u1, u2) -> u1.name().compareTo(u2.name()));
        //users.sort(Comparator.comparing(User::age));

        var hasTwoContacts = users.stream().filter(u -> u.contacts().size() > 1).toList();
        
        var hasOneContact = users.stream().filter(u -> u.contacts().size() == 1).toList();

        var userHasEmail = users.stream().filter(u -> u.contacts().stream().anyMatch(c -> c.type() == EMAIL)).toList();
        var userHasOnlyEmail = users.stream().filter(u -> u.contacts().stream().allMatch(c -> c.type() == EMAIL)).toList();
        var userHasntEmail = users.stream().filter(u -> u.contacts().stream().noneMatch(c -> c.type() == EMAIL)).toList();

        //users.forEach(System.out::println);
        System.out.println("===========");
        hasTwoContacts.forEach(System.out::println);
        System.out.println("===========");
        hasOneContact.forEach(System.out::println);
        System.out.println("===========");
        userHasEmail.forEach(System.out::println);
        System.out.println("===========");
        userHasOnlyEmail.forEach(System.out::println);
        System.out.println("===========");
        userHasntEmail.forEach(System.out::println); 
        
    
        
    }

    private static List<User> generateUsers(){
        var contacts1 = List.of(
            new Contact("(71)99958-8950",PHONE),
            new Contact("pedrocanuto@gmail.com",EMAIL)
        );

         var contacts2 = List.of(
            new Contact("(71)99276-0330",PHONE)            
        );

         var contacts3 = List.of(
            new Contact("oliveirapintoleila@gmail.com",EMAIL)
        );

         var contacts4 = List.of(
            new Contact("(71)99983-7602",PHONE),
            new Contact("paulorcanuto@gmail.com",EMAIL)
        );

         var contacts5 = List.of(
            new Contact("(71)99109-1956",PHONE)           
        );

        var user1 = new User("Pedro",29,Sex.MALE, new ArrayList<>(contacts1));
        var user2 = new User("Liz",30,FEMALE, new ArrayList<>(contacts2));
        var user3 = new User("Leila",65,FEMALE, new ArrayList<>(contacts3));
        var user4 = new User("Paulo",73,MALE, new ArrayList<>(contacts4));
        var user5 = new User("Larissa",43,MALE, new ArrayList<>(contacts5));       


        return List.of(user1, user2, user3, user4, user5);
    }
}
