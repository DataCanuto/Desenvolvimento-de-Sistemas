# SistemaSafeBankDigital

Simulação de um banco digital em terminal, com hierarquias de herança para contas (`Corrente`, `Poupanca`), cartões (`Credito`, `Debito`) e usuários (`Admin`, `Client`), organizadas em pacotes.

## Conteúdo

- `App.java` — ponto de entrada com menu global (acesso administrador / acesso do cliente): cadastra contas e cartões, lista usuários/contas/cartões e permite login do cliente.
- `conta/Conta.java`, `conta/Corrente.java`, `conta/Poupanca.java` — hierarquia de contas bancárias, com `Corrente` e `Poupanca` estendendo o comportamento base de `Conta`.
- `cartao/Cartao.java`, `cartao/Credito.java`, `cartao/Debito.java` — hierarquia de cartões associados às contas.
- `user/User.java`, `user/Admin.java`, `user/Client.java` — hierarquia de usuários do sistema, distinguindo administrador e cliente.

## Como rodar

```bash
cd Heranças/HerancaContas/SistemaSafeBankDigital/src
javac -d out App.java cartao/*.java conta/*.java user/*.java
java -cp out App
```
