package user;

public class Admin extends User {
    private String cargo;
    private String senhaAdmin;


    public Admin() {}

    public Admin(String nome, String cpf, String email, String telefone, String cargo, String senhaAdmin) {
        super(nome, cpf, email, telefone);
        this.cargo = cargo;
        this.senhaAdmin = senhaAdmin;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

    public void setSenhaAdmin(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }

}
