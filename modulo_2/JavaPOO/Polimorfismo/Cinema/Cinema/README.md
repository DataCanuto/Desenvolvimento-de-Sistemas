# Cinema

Sistema de bilheteria de cinema em terminal que vende ingressos comuns, de meia-entrada e familiares, aplicando desconto de 5% em compras de 3 ou mais ingressos.

## Conteúdo

- `Ingresso.java` — classe base com `valor`, `nomeFilme`, `legendado`.
- `MeiaEntrada.java` — estende `Ingresso`, adiciona `tipoMeia` (Estudante, De menor, Idoso, Doador de sangue).
- `IngressoFamilia.java` — estende `Ingresso`, adiciona `quantidadePessoas`.
- `App.java` — menu (vender ingressos / relatório de vendas), usa `instanceof` para identificar o tipo de ingresso ao exibir o relatório e calcula o valor total arrecadado.

## Como rodar

```bash
cd Polimorfismo/Cinema/Cinema/src
javac -d out *.java
java -cp out App
```
