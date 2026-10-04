package dio.my_first_web_api.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dio.my_first_web_api.model.Usuario;
import dio.my_first_web_api.repository.UsuarioRepository;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return repository.listAll();
    }

    @GetMapping("/usuarios/{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @DeleteMapping("/usuarios/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.remove(id);
    }
}
