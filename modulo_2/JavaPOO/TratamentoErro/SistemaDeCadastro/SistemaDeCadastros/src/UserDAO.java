import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private int nextId = 1;

    private final List <UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model){
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(final int id){
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(final int id) {
        verifyStorage();
        var message = String.format("User with id %d not found", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
    }

    public List<UserModel> findAll() {
        List<UserModel> result ;
        try {
            verifyStorage();
            result = models;            
        } catch (EmptyStorageException ex) {
            result = new ArrayList<>();
        }        
        return result;
    }

    public void orderById() {
        models.sort((u1, u2) -> Integer.compare(u1.getId(), u2.getId()));
    }

    private void verifyStorage(){
        if(models.isEmpty()) throw new EmptyStorageException("No users found in the system");
    }
    
}
