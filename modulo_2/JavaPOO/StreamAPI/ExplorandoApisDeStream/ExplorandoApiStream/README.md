# ExplorandoApiStream

Exploração da Stream API sobre uma lista de usuários com contatos: filtragem por quantidade de contatos e por tipo de contato usando `anyMatch`, `allMatch` e `noneMatch`.

## Conteúdo

- `App.java` — gera uma lista fixa de `User`s com contatos variados e demonstra `filter`, `anyMatch`, `allMatch`, `noneMatch` para separar usuários com mais de um contato, com exatamente um contato, com e-mail, apenas com e-mail, e sem e-mail.
- `domain/User.java` — record `User(String name, int age, Sex sex, List<Contact> contacts)`.
- `domain/Contact.java` — record `Contact(String description, ContactType type)`.
- `domain/Sex.java`, `domain/ContactType.java` — enums de apoio (`FEMALE`/`MALE`, `EMAIL`/`PHONE`).

## Como rodar

```bash
cd StreamAPI/ExplorandoApisDeStream/ExplorandoApiStream/src
javac -d out App.java domain/*.java
java -cp out App
```
