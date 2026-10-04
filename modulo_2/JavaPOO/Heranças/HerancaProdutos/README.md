# HerancaProdutos

Exemplo de herança aplicado a um catálogo de produtos: `Produto` define preço, frete e desconto, enquanto `Eletronico` e `Livro` estendem essas regras com comportamentos próprios.

## Conteúdo

- `Produto.java` — classe base com `nome`, `preco`, `codigoBarras`, `exibirEtiqueta()`, `calcularFrete()`, `calcularDesconto()` e `valorFinal()`.
- `Eletronico.java` — estende `Produto`, adiciona `voltagem`/`garantiaMeses`, sobrescreve `calcularFrete()` (valor fixo de eletrônicos) e inclui `verificaCompatibilidade()` e `calcularConsumo()`.
- `Livro.java` — estende `Produto`, adiciona `autor`/`isbn`/`numeroPaginas` e o método `abrirPrevisualizacao()`.
- `Main.java` — cria um `Produto`, um `Eletronico` e um `Livro`, exibindo etiquetas, frete, desconto e preço final de cada um.

## Como rodar

```bash
cd Heranças/HerancaProdutos/src
javac -d out *.java
java -cp out Main
```
