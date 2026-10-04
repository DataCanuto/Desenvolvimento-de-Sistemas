# Person

Primeiro exemplo de `record` do repositório: demonstra como o Java gera automaticamente construtor e acessores (`name()`, `age()`) para um tipo de dado imutável.

## Conteúdo

- `Person.java` — `record Person(String name, int age)`, sem código adicional além do que o compilador gera.
- `App.java` — cria um `Person` e imprime `name()` e `age()`.

## Como rodar

```bash
cd Records/MyFirstRecordsProject/Person/src
javac -d out *.java
java -cp out App
```
