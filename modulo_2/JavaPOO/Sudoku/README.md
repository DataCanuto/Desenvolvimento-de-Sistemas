# 🎮 Jogo de Sudoku em Java

Projeto de um jogo de Sudoku desenvolvido em Java, com duas interfaces: uma versão em modo texto (terminal) e uma versão gráfica utilizando Java Swing.

---

## 📋 Etapas do Desenvolvimento (Passo a Passo)

### 1. Modelagem do Domínio
Criação das classes do modelo que representam as entidades centrais do jogo:
- **`Space`** — representa cada célula do tabuleiro, armazenando o valor esperado, o valor atual e se a célula é fixa (pré-definida) ou editável.
- **`Board`** — representa o tabuleiro 9x9, com a lógica de status do jogo (`NON_STARTED`, `INCOMPLETE`, `COMPLETE`) e verificação de erros.
- **`GameStatusEnum`** — enumeração com os possíveis estados do jogo.

### 2. Implementação da Interface via Terminal
Desenvolvimento da classe `App.java` com um menu interativo em linha de comando para:
- Iniciar um novo jogo com configuração via argumentos
- Inserir e remover números no tabuleiro
- Visualizar o estado atual do tabuleiro
- Verificar o status e finalizar o jogo

### 3. Criação da Camada de Serviço
Separação da lógica de negócio em serviços:
- **`BoardService`** — responsável por inicializar o tabuleiro a partir de uma configuração externa (mapa de posições), e expor operações como reset, verificação de erros e status.
- **`NotifierService`** — implementação do padrão **Observer** para comunicação entre componentes da interface gráfica.
- **`EventEnum`** e **`EventListener`** — definição dos eventos suportados pelo sistema de notificações (ex.: limpeza de células).

### 4. Desenvolvimento da Interface Gráfica (Swing)
Construção da UI com Java Swing, organizada em componentes reutilizáveis:
- **`MainFrame`** — janela principal da aplicação.
- **`MainPanel`** — painel raiz que organiza o layout do jogo.
- **`SudokuSector`** — painel que representa cada um dos 9 setores 3x3 do tabuleiro.
- **`NumberText`** / **`NumberTextLimit`** — campos de texto customizados para entrada de números de 1 a 9, com validação de input.
- **`BtnReset`**, **`BtnCheckGameStatus`**, **`BtnFinishGame`** — botões de ação com comportamentos integrados ao serviço.

### 5. Integração e Orquestração da Tela Principal
Desenvolvimento da classe `MainScreen`, responsável por:
- Instanciar e conectar `BoardService` e `NotifierService`
- Montar dinamicamente os 9 setores do tabuleiro com as células corretas
- Adicionar os botões de controle ao painel principal
- Exibir diálogos de feedback ao usuário (`JOptionPane`)

### 6. Ponto de Entrada da Interface Gráfica
Criação de `UIMain.java` como entry point da versão gráfica, recebendo a configuração do tabuleiro via argumentos de linha de comando e iniciando a tela principal.

---

## 🛠️ Principais Ferramentas Utilizadas

| Ferramenta | Descrição |
|---|---|
| **Java 17+** | Linguagem principal do projeto |
| **Java Swing** | Biblioteca para construção da interface gráfica |
| **VS Code** | Ambiente de desenvolvimento (IDE) |
| **Extension Pack for Java** | Suporte a Java no VS Code (compilação, debug, gerenciamento de projetos) |
| **Git / GitHub** | Controle de versão e hospedagem do repositório |

---

## 🧠 Principais Habilidades Adquiridas

- **Programação Orientada a Objetos (POO):** modelagem de entidades com encapsulamento, herança e polimorfismo aplicados às classes do tabuleiro e da UI.
- **Padrão de Projeto Observer:** implementação de um sistema de eventos (`NotifierService` / `EventListener`) para desacoplar componentes da interface.
- **Java Swing:** criação de interfaces gráficas com componentes customizados (`JPanel`, `JFrame`, `JTextField`, `JButton`), layouts e diálogos.
- **Separação de responsabilidades:** organização do código em camadas (`model`, `service`, `ui`), mantendo cada classe com uma única responsabilidade.
- **Manipulação de dados com Streams:** uso de `Stream` e `Collectors` para processar argumentos de configuração e iterar sobre o tabuleiro de forma funcional.
- **Validação de entrada:** controle de input do usuário tanto no terminal quanto nos campos de texto da interface gráfica.
- **Configuração externa do tabuleiro:** carregamento dinâmico da configuração do jogo via argumentos da JVM, tornando o tabuleiro flexível e reutilizável.

---

## 📁 Estrutura do Projeto

```
src/
├── App.java                  # Interface via terminal
├── UIMain.java               # Entry point da interface gráfica
├── model/
│   ├── Board.java            # Lógica do tabuleiro
│   ├── Space.java            # Representação de cada célula
│   └── GameStatusEnum.java   # Estados do jogo
├── service/
│   ├── BoardService.java     # Serviço de gerenciamento do tabuleiro
│   ├── NotifierService.java  # Sistema de notificações (Observer)
│   ├── EventListener.java    # Interface de escuta de eventos
│   └── EventEnum.java        # Tipos de eventos
└── ui/
    └── custom/
        ├── button/           # Botões customizados
        ├── frame/            # Janela principal
        ├── inputs/           # Campos de entrada numérica
        ├── panel/            # Painéis do tabuleiro
        └── screen/           # Orquestração da tela principal
```
