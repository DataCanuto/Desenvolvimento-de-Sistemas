package one.digitalinnovation.lab_padroes_projeto_spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.lab_padroes_projeto_spring.model.Cliente;
import one.digitalinnovation.lab_padroes_projeto_spring.model.ClienteRepository;
import one.digitalinnovation.lab_padroes_projeto_spring.model.Endereco;
import one.digitalinnovation.lab_padroes_projeto_spring.model.EnderecoRepository;
import one.digitalinnovation.lab_padroes_projeto_spring.service.ClienteService;
import one.digitalinnovation.lab_padroes_projeto_spring.service.ViaCepService;

@Service
public class ClientServiceImplementation implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired 
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    @Override
    public void inserir(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()-> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        clienteRepository.findById(id).ifPresentOrElse(clienteExistente -> {
            cliente.setId(id);
            inserir(cliente);
        }, () -> {
            throw new RuntimeException("Cliente não encontrado com id: " + id);
        });
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
    
    

}
