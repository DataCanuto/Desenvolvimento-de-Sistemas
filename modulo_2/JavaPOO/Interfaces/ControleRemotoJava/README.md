# ControleRemotoJava

Simulação de um controle remoto de TV, onde a interface `Controlador` define o contrato de comandos e `ControleRemoto` implementa o comportamento (volume, mudo, play/pause).

## Conteúdo

- `Controlador.java` — interface com os métodos `ligar()`, `desligar()`, `abrirMenu()`, `fecharMenu()`, `maisVolume()`, `menosVolume()`, `ligarMudo()`, `desligarMudo()`, `play()`, `pause()`.
- `ControleRemoto.java` — implementa `Controlador`, mantendo estado (`volume`, `ligado`, `tocando`) e as regras de cada ação (ex.: só altera volume se estiver ligado).
- `Main.java` — liga o controle, dá play, aumenta o volume algumas vezes e exibe o menu de status.

## Como rodar

```bash
cd Interfaces/ControleRemotoJava/src
javac -d out *.java
java -cp out Main
```
