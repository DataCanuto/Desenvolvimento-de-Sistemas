# ApisDeStream

Exercícios de exploração da Stream API: geração de números aleatórios, `filter`, `reduce`, `distinct`, `map` e combinações de `filter` + `peek` + `map` + `collect` sobre listas de inteiros.

## Conteúdo

- `App.java` — contém, comentados, vários exemplos isolados (`Stream.generate`, `filter` em strings, `reduce` com `Integer::sum`, `distinct`, `map`) e um exemplo ativo: filtra `values2` pelos elementos presentes em `values1`, imprime cada filtro com `peek`, aplica uma redução com `map` e coleta o resultado em um `Set` com `Collectors.toSet()`.

## Como rodar

```bash
cd StreamAPI/ApisDeStream/src
javac -d out App.java
java -cp out App
```
