# SistemaDeCadastros

Sistema de cadastro de usuários em terminal com CRUD completo e tratamento de exceções customizadas para validação de dados, usuário não encontrado e armazenamento vazio.

## Conteúdo

- `App.java` — menu (`MenuOption`: cadastrar, atualizar, deletar, buscar por id, listar, sair), com blocos `try/catch/finally` tratando `UserNotFoundException` e `EmptyStorageException`.
- `UserDAO.java` — armazenamento em memória (`List<UserModel>`) com `save`, `update`, `delete`, `findById`, `findAll`, `orderById`, lançando `UserNotFoundException`/`EmptyStorageException` quando aplicável.
- `UserModel.java` — modelo do usuário (`id`, `name`, `email`, `dateOfBirth`).
- `UserValidator.java` — validação estática (`VerifyModel`) de nome, e-mail e data de nascimento, lançando `ValidatorException`.
- `EmptyStorageException.java`, `UserNotFoundException.java` — exceções não checadas (`RuntimeException`).
- `ValidatorException.java` — exceção checada (`Exception`) usada na validação de entrada.
- `MenuOption.java` — enum das opções do menu.

## Como rodar

```bash
cd TratamentoErro/SistemaDeCadastro/SistemaDeCadastros/src
javac -d out *.java
java -cp out App
```
