# Generics

Exemplo de Generics aplicado a um DAO em memória: `GenericDAO<T, ID>` fornece operações CRUD reutilizáveis para qualquer domínio, especializado aqui para `UserDomain`.

## Conteúdo

- `dao/GenericDAO.java` — classe abstrata genérica com `save`, `update`, `delete`, `find` (via `Predicate`), `findAll` e `count`, usando uma `List<T>` interna como armazenamento.
- `dao/UserDAO.java` — especialização de `GenericDAO<UserDomain, Integer>`.
- `domain/UserDomain.java` — record `UserDomain(String name, int age)`.
- `App.java` — salva, lista, conta e remove usuários usando o DAO genérico.

## Como rodar

```bash
cd StreamAPI/Generics/Generics/src
javac -d out App.java dao/*.java domain/*.java
java -cp out App
```
