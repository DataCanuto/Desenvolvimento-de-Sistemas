# HerancaAnimal

Exemplo introdutório de herança: uma classe abstrata `Animal` compartilha atributos e comportamento comum entre `Cachorro` e `Gato`, cada um sobrescrevendo o som emitido.

## Conteúdo

- `Animal.java` — classe abstrata com `especie`, `idade`, o método abstrato `emitirSom()` e `animalData()`, que imprime os dados formatando a idade no singular/plural.
- `Cachorro.java` — estende `Animal`, adiciona `raca` e implementa `emitirSom()` ("Auau").
- `Gato.java` — estende `Animal`, adiciona `domesticado` e implementa `emitirSom()` ("Miaaau"), reaproveitando `animalData()` via `super`.
- `Main.java` — cria um `Gato` e um `Cachorro`, define seus atributos e chama `emitirSom()`/`animalData()`.

## Como rodar

```bash
cd Heranças/HerancaAnimal/src
javac -d out *.java
java -cp out Main
```
