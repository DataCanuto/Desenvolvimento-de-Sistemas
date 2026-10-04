# CalculadoraStrings

Calculadora de linha de comando que lê números separados por vírgula em uma única string e aplica uma operação (soma ou subtração) usando `Stream` e uma interface funcional.

## Conteúdo

- `App.java` — menu no terminal: pede a operação, lê os números como texto (`"1,2,3"`), converte com `Arrays.stream(...).mapToLong(...)` e executa a operação escolhida.
- `Operation.java` — enum com as operações (`SUM`, `SUBTRACTION`), cada uma associada a um `Calc` implementado com `LongStream.reduce`.
- `Calc.java` — interface funcional (`@FunctionalInterface`) com o método `exec(long... numbers)`.

## Como rodar

```bash
cd CollectionsAPI/Calculadora/CalculadoraStrings/src
javac -d out *.java
java -cp out App
```
