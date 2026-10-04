# SimuladorDeLuta

Simulador de lutas entre `Lutador`es da mesma categoria de peso, com resultado sorteado aleatoriamente (vitória, derrota ou empate) e histórico de rounds.

## Conteúdo

- `Lutador.java` — dados do lutador (nome, nacionalidade, idade, altura, peso) e categoria calculada automaticamente a partir do peso (`Leve`, `Médio`, `Pesado`, `Inválido`); contadores de vitórias/derrotas/empates.
- `Luta.java` — organiza uma luta entre dois lutadores da mesma categoria (`marcarLuta`), sorteia o resultado com `Random` em `Lutar()` e exibe o status acumulado em `statusLuta()`.
- `Main.java` — cria seis lutadores, marca uma luta entre os dois primeiros e executa várias rodadas, exibindo o status a cada round.

## Como rodar

```bash
cd Interfaces/SimuladorDeLuta/src
javac -d out *.java
java -cp out Main
```
