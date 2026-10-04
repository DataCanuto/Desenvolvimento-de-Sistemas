# PetShopSistem

Sistema de terminal que simula uma máquina de banho para pets, controlando níveis de água/shampoo, estado ligado/desligado e limpeza através de atributos encapsulados com getters/setters.

## Conteúdo

- `App.java` — menu interativo (ligar/desligar a máquina, adicionar água/shampoo, colocar/remover pet, dar banho, ver status).
- `PetMachine.java` — classe principal com estado privado (`clean`, `isOn`, `waterLevel`, `shampooLevel`, `pet`) e regras de negócio: `takeAShower()`, `addWater()`, `addShampoo()`, `cleanMachine()`, `placePet()`, `removePet()`.
- `Pet.java` — modelo simples do pet (`name`, `age`, `clean`) com atributos privados e acesso controlado por métodos públicos.

## Como rodar

```bash
cd Encapsulamento/SistemaPetShop/PetShopSistem/src
javac -d out *.java
java -cp out App
```
