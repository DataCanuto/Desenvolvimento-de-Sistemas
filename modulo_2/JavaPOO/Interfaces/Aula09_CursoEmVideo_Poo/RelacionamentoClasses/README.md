# RelacionamentoClasses

Exercício sobre relacionamento entre classes (associação) e interfaces: `Livro` implementa `Publicacao` e mantém uma referência a `Pessoa` como leitor.

## Conteúdo

- `Publicacao.java` — interface com os contratos `abrir()`, `fechar()`, `folhear(int)`, `avancarPag()` e `voltarPag()`.
- `Livro.java` — implementa `Publicacao`; controla página atual/total e estado aberto/fechado, e mantém a associação com o `Pessoa leitor`.
- `Pessoa.java` — modelo simples (`nome`, `idade`, `sexo`) com o método `fazerAniversario()`.
- `App.java` — cria pessoas e livros, associando cada livro a um leitor, e demonstra `folhear()`/`detalhes()`.

## Como rodar

```bash
cd Interfaces/Aula09_CursoEmVideo_Poo/RelacionamentoClasses/src
javac -d out *.java
java -cp out App
```
