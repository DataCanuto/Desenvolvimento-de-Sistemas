
import java.time.LocalDate;

public class UserModel {
    private int id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;

    public UserModel() {
    }

    public UserModel(final int id, final String name, final String email, final LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
    }

    
    
    
    
    
}
