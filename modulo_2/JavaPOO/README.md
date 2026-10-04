# Java POO Learning and Practcing

## POO - PROGRAMAÇÃO ORIENTADA A OBJETOS
- Este repositório contem projetos que fizeram parte da minha formação em desenvolvimento de sistemas
- O principal objetivo, é demonstrar domínio dos pilares da POO com a linguagem java, citando os projetos mais relevantes de cada etapa do aprendizado. 

## Ambiente de desenvolvimento
- VS Code
- Intellij
- Appache NetBeans

## Base teórica:

SENAI, CIMATEC

## Pilares da programação orientada a objetos
- Abstração, Herança, Polimorfismo, Encapsulamento

### Abstração
- Abstração em POO é o princípio de representar apenas as características e comportamentos essenciais de um objeto, ocultando detalhes desnecessários.
- Ela reduz a complexidade e permite que o programador utilize objetos sem conhecer seu funcionamento interno.
- Por se tratar de um conceito elementar, está presente em todos os projetos no momento de selecionar os *atributos* e *métodos* que farão parte da classe.

### Herança
- Herança em POO é o mecanismo que permite a uma classe herdar atributos e métodos de outra classe. 
- A classe filha pode reutilizar, modificar ou ampliar comportamentos da classe pai, promovendo reaproveitamento de código e facilitando a organização da aplicação.
- Em Java, uma classe filha só pode herdar os atributos e métodos de uma única classe. Existem outras linguagens em que uma classe pode ser herdeira de mais de uma classe pai.
- [Heranças](Heranças)

### Polimorfismo
- Polimorfismo em POO é a capacidade de um mesmo *método* ou *interface* apresentar diferentes comportamentos, dependendo do objeto que o utiliza. 
- Isso permite maior flexibilidade, reutilização e extensibilidade do código, facilitando a implementação de diferentes classes.
- [Polimorfismo](Polimorfismo)
- [SobrecargaMetodos/SafeBankv3](SobrecargaMetodos/SafeBankv3)

### Encapsulamento
- Encapsulamento em POO é o princípio de proteger os dados internos de um objeto, restringindo seu acesso direto e controlando sua manipulação por meio de métodos. 
- Isso aumenta a segurança, organização e manutenção do código.
- [Encapsulamento](Encapsulamento)

## Java 21

### Classe
- Classe em Java é uma estrutura que define atributos e métodos de um objeto.
- Ela funciona como um modelo para criar objetos com características e comportamentos específicos.

### Interface
- Interface em Java é um contrato que define métodos que uma classe deve implementar.
- Ela estabelece comportamentos esperados, promovendo abstração, flexibilidade e permitindo que diferentes classes compartilhem funcionalidades.
- [Interfaces](Interfaces)

### Record
- Record em Java é um tipo especial de classe usado para representar dados imutáveis de forma concisa.
- Ele gera automaticamente métodos como construtor, acessores, `equals()`, `hashCode()` e `toString()`.
- [Records/MyFirstRecordsProject/Person](Records/MyFirstRecordsProject/Person)

### Enum
- Enum em Java é um tipo especial que representa um conjunto fixo de constantes.
- Ele permite definir valores pré-determinados de forma segura e organizada, podendo também possuir atributos e métodos.

### Tratamento de erro
- Tratamento de erros em Java é o uso de mecanismos como `try`, `catch`, `finally` e `throw` para identificar, tratar e controlar exceções, evitando que erros interrompam inesperadamente a execução.
- [TratamentoErro/SistemaDeCadastro/SistemaDeCadastros](TratamentoErro/SistemaDeCadastro/SistemaDeCadastros)

## E Mais
### Collections
[CollectionsAPI/Calculadora/CalculadoraStrings](CollectionsAPI/Calculadora/CalculadoraStrings)

### Stream
[StreamAPI](StreamAPI)

### Java Swing
[JavaSwingProjects](JavaSwingProjects)

### Maven Project
[MyFirstMavenProject/maven-project](MyFirstMavenProject/maven-project)

## Linha do tempo dos projetos

| Ordem | Projeto | Descrição rápida |
|---|---|---|
| 1 | [HerancaAnimal](Heranças/HerancaAnimal) | Primeiro contato com herança: `Animal` abstrato, `Cachorro` e `Gato`. |
| 2 | [HerancaVeiculos](Heranças/HerancaVeiculos) | Herança aplicada a `Veiculo`, `Carro` e `Moto`. |
| 3 | [HerancaProdutos](Heranças/HerancaProdutos) | Herança aplicada a um catálogo de produtos (`Produto`, `Eletronico`, `Livro`). |
| 4 | [SistemaSafeBankDigital](Heranças/HerancaContas/SistemaSafeBankDigital) | Banco digital em terminal com hierarquias de conta, cartão e usuário. |
| 5 | [PetShopSistem](Encapsulamento/SistemaPetShop/PetShopSistem) | Encapsulamento aplicado a uma máquina de banho para pets. |
| 6 | [RelacionamentoClasses](Interfaces/Aula09_CursoEmVideo_Poo/RelacionamentoClasses) | Interface `Publicacao` e associação entre `Livro` e `Pessoa`. |
| 7 | [ControleRemotoJava](Interfaces/ControleRemotoJava) | Interface `Controlador` implementada por `ControleRemoto`. |
| 8 | [SimuladorDeLuta](Interfaces/SimuladorDeLuta) | Simulador de lutas entre `Lutador`es por categoria de peso. |
| 9 | [Animais (Polimorfismo)](Polimorfismo/Animais/Animais) | Hierarquia polimórfica de animais (mamíferos, répteis, peixes, aves). |
| 10 | [Cinema](Polimorfismo/Cinema/Cinema) | Bilheteria com ingressos comuns, meia-entrada e familiares. |
| 11 | [SafeBankv3](SobrecargaMetodos/SafeBankv3) | Sobrecarga de métodos aplicada a operações de saque/depósito. |
| 12 | [CadastroPessoas](JavaSwingProjects/CadastroPessoas/CadastroPessoas) | Cadastro de pessoas com interface gráfica Swing. |
| 13 | [caluladoraSwing](JavaSwingProjects/caluladoraSwing) | Calculadora gráfica Swing com as quatro operações básicas. |
| 14 | [calculadoraSwing](JavaSwingProjects/calculadoraSwing) | Pasta remanescente sem código-fonte (ver `caluladoraSwing`). |
| 15 | [maven-project](MyFirstMavenProject/maven-project) | Primeiro projeto Maven, com MapStruct e Lombok. |
| 16 | [Person](Records/MyFirstRecordsProject/Person) | Primeiro exemplo de `record`. |
| 17 | [SistemaDeCadastros](TratamentoErro/SistemaDeCadastro/SistemaDeCadastros) | CRUD de usuários com tratamento de exceções customizadas. |
| 18 | [CalculadoraStrings](CollectionsAPI/Calculadora/CalculadoraStrings) | Calculadora de strings com Collections/Streams e enum funcional. |
| 19 | [ApisDeStream](StreamAPI/ApisDeStream) | Exercícios introdutórios de Stream API. |
| 20 | [ExplorandoApiStream](StreamAPI/ExplorandoApisDeStream/ExplorandoApiStream) | Filtros avançados de Stream API (`anyMatch`, `allMatch`, `noneMatch`). |
| 21 | [Generics](StreamAPI/Generics/Generics) | DAO genérico reutilizável (`GenericDAO<T, ID>`). |
| 22 | [Sudoku](Sudoku) | Jogo de Sudoku completo, com versão terminal e interface gráfica Swing. |

## Acesso rápido por tema

- **Herança:** [Heranças](Heranças), [HerancaAnimal](Heranças/HerancaAnimal), [HerancaVeiculos](Heranças/HerancaVeiculos), [HerancaProdutos](Heranças/HerancaProdutos), [SistemaSafeBankDigital](Heranças/HerancaContas/SistemaSafeBankDigital)
- **Polimorfismo:** [Polimorfismo](Polimorfismo), [Animais](Polimorfismo/Animais/Animais), [Cinema](Polimorfismo/Cinema/Cinema), [SafeBankv3](SobrecargaMetodos/SafeBankv3)
- **Encapsulamento:** [Encapsulamento](Encapsulamento), [PetShopSistem](Encapsulamento/SistemaPetShop/PetShopSistem)
- **Interfaces:** [Interfaces](Interfaces), [RelacionamentoClasses](Interfaces/Aula09_CursoEmVideo_Poo/RelacionamentoClasses), [ControleRemotoJava](Interfaces/ControleRemotoJava), [SimuladorDeLuta](Interfaces/SimuladorDeLuta)
- **Records:** [Person](Records/MyFirstRecordsProject/Person)
- **Tratamento de Erro:** [SistemaDeCadastros](TratamentoErro/SistemaDeCadastro/SistemaDeCadastros)
- **Collections:** [CalculadoraStrings](CollectionsAPI/Calculadora/CalculadoraStrings)
- **Stream:** [StreamAPI](StreamAPI), [ApisDeStream](StreamAPI/ApisDeStream), [ExplorandoApiStream](StreamAPI/ExplorandoApisDeStream/ExplorandoApiStream), [Generics](StreamAPI/Generics/Generics)
- **Swing:** [JavaSwingProjects](JavaSwingProjects), [CadastroPessoas](JavaSwingProjects/CadastroPessoas/CadastroPessoas), [caluladoraSwing](JavaSwingProjects/caluladoraSwing), [Sudoku](Sudoku)
- **Maven:** [MyFirstMavenProject/maven-project](MyFirstMavenProject/maven-project)

## Como rodar um projeto

A maioria dos projetos é composta por classes soltas em uma pasta `src`, sem gerenciador de dependências. Dentro da pasta `src` do projeto desejado:

```bash
javac -d out *.java
java -cp out <ClassePrincipal>
```

Projetos organizados em pacotes (ex.: `Heranças/HerancaContas/SistemaSafeBankDigital`, `JavaSwingProjects/*`) exigem compilar todos os subpacotes:

```bash
javac -d out *.java pacote1/*.java pacote2/*.java
java -cp out <ClassePrincipal>
```

O projeto `MyFirstMavenProject/maven-project` usa Maven:

```bash
cd MyFirstMavenProject/maven-project
mvn compile exec:java -Dexec.mainClass=br.com.DataCanuto.Main
```

Cada pasta de projeto possui seu próprio `README.md` com detalhes específicos, incluindo o comando exato de execução.
