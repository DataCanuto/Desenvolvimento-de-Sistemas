public class App {
    public static void main(String[] args) throws Exception {
        var person = new Person("John",12);
        

        System.out.println(person.name());
        System.out.println(person.age());
    }
}
