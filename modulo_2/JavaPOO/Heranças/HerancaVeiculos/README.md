# HerancaVeiculos

Exemplo de herança com uma classe base `Veiculo` (marca, modelo) estendida por `Carro` (número de portas) e `Moto` (cilindradas), cada uma sobrescrevendo a exibição dos dados.

## Conteúdo

- `Veiculo.java` — classe base com `marca`, `modelo`, `exibirVeiculo()` e `stringVeiculo(classe, txt)`.
- `Carro.java` — estende `Veiculo`, adiciona `num_portas` e sobrescreve `exibirVeiculo()`/`stringVeiculo()`.
- `Moto.java` — estende `Veiculo`, adiciona `cilindradas` e sobrescreve `exibirVeiculo()`/`stringVeiculo()`.
- `Main.java` — cria um `Carro` e uma `Moto`, define seus atributos e chama os métodos de exibição.

## Como rodar

```bash
cd Heranças/HerancaVeiculos/src
javac -d out *.java
java -cp out Main
```
