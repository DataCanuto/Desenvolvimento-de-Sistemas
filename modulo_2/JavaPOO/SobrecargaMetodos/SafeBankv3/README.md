# SafeBankv3

Exemplo de sobrecarga de métodos (polimorfismo) aplicado a uma conta bancária: `sacar`/`depositar` possuem duas versões — uma que valida a operação e outra que efetivamente a executa.

## Conteúdo

- `App.java` — cria uma `Conta`, realiza um depósito e um saque (com valor maior que o saldo, demonstrando a validação) e imprime o saldo em cada etapa.
- `Conta.java` — modelo da conta (`id`, `titular`, `agencia`, `conta`, `saldo`); os métodos `sacar(double)`/`depositar(double)` retornam `boolean` validando a operação, enquanto `sacar(boolean, double)`/`depositar(boolean, double)` aplicam a mudança de saldo.
- `EnumAgencia.java`, `EnumConta.java` — enums com número de agência e número de conta associados.

## Como rodar

```bash
cd SobrecargaMetodos/SafeBankv3/src
javac -d out *.java
java -cp out App
```
