import dao.GenericDAO;
import dao.UserDAO;
import domain.UserDomain;


public class App {

    private static GenericDAO<UserDomain, Integer> dao = new UserDAO();
    public static void main(String[] args){
        var user = new UserDomain("João",36);
        System.out.println(dao.count());
        System.out.println(dao.save(user));
        System.out.println(dao.findAll());
        System.out.println(dao.count());
        System.out.println(dao.delete(new UserDomain("",-1)));
        System.out.println(dao.delete(user));
        System.out.println(dao.findAll());      
        
    }
}
