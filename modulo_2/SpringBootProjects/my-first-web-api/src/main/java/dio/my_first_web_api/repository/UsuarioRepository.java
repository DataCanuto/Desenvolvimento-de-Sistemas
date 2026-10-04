package dio.my_first_web_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dio.my_first_web_api.model.Usuario;

@Repository
public class UsuarioRepository {

    private static final List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario(1, "gleyson", "senha123"));
        usuarios.add(new Usuario(2, "anna", "senha456"));
        usuarios.add(new Usuario(3, "jose", "senha789"));
    }

    public void save(Usuario usuario) {
        System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
        usuarios.add(usuario);
    }

    public void update(Usuario usuario) {
        System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
    }

    public void remove(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        usuarios.removeIf(u -> u.getId().equals(id));
    }

    public List<Usuario> listAll() {
        return usuarios;
    }

    public Usuario findById(Integer id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Usuario findByUsername(String username) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }
}
