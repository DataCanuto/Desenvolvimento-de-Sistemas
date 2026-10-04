# Animais

Exemplo clássico de polimorfismo: uma hierarquia de `Animal` (abstrata) com subclasses de nível intermediário (`Mamifero`, `Reptil`, `Peixe`, `Ave`) e subclasses concretas (`Cachorro`, `Canguru`, `Cobra`, `Tartaruga`, `Goldfish`, `Arara`, `Galinha`), cada uma sobrescrevendo `locomover()`, `alimentar()` e `emitirSom()`.

## Conteúdo

- `Animal.java` — classe abstrata base com `peso`, `idade`, `membros` e os métodos abstratos `locomover()`, `alimentar()`, `emitirSom()`.
- `Mamifero.java`, `Reptil.java`, `Peixe.java`, `Ave.java` — implementações intermediárias com comportamento padrão do grupo.
- `Cachorro.java`, `Canguru.java` (mamíferos), `Cobra.java`, `Tartaruga.java` (répteis), `Goldfish.java` (peixe), `Arara.java`, `Galinha.java` (aves) — especializações concretas que sobrescrevem métodos específicos.
- `App.java` — instancia um representante de cada grupo intermediário e chama seus métodos polimórficos.

## Como rodar

```bash
cd Polimorfismo/Animais/Animais/src
javac -d out *.java
java -cp out App
```
