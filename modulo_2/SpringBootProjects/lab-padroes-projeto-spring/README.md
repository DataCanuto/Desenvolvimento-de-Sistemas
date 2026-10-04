# lab-padroes-projeto-spring

Laboratório da DIO sobre padrões de projeto com Spring Boot. Introduz a separação em camadas de serviço (`service` / `service/implementation`) e integração com uma API externa (ViaCEP) para consulta de endereços.

## Conteúdo

- `controller/ClientRestController.java`
- `model/Cliente.java`, `model/Endereco.java`
- `model/ClienteRepository.java`, `model/EnderecoRepository.java`
- `service/ClienteService.java`, `service/ViaCepService.java`
- `service/implementation/ClientServiceImplementation.java`

## Como rodar

```bash
./mvnw spring-boot:run
```
