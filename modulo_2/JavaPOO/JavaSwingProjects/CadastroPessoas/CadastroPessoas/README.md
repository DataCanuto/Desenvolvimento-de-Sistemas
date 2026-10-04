# CadastroPessoas

Aplicação desktop (Java Swing) para cadastrar pessoas (nome e idade) em memória, com botões para adicionar, limpar os campos, exibir a lista cadastrada e limpar a lista inteira.

## Conteúdo

- `App.java` — ponto de entrada, abre a janela principal `screen.Screen`.
- `screen/Screen.java` — `JFrame` principal, monta os painéis de formulário e de botões e mantém a lista de `Usuario` em memória.
- `panel/PainelForm.java`, `panel/PainelBotoes.java` — painéis (`JPanel`) que organizam os campos de entrada e os botões de ação.
- `inputs/FieldNome.java`, `inputs/FieldIdade.java` — campos de texto (`JTextField`) customizados com fonte, alinhamento e bordas próprias.
- `btn/BtnAdd.java`, `btn/BtnClean.java`, `btn/BtnShow.java`, `btn/BtnCleanList.java` — botões (`JButton`) que encapsulam suas próprias ações (adicionar usuário, limpar campos, exibir lista em `JOptionPane`, limpar lista).
- `model/Usuario.java` — modelo simples (`nome`, `idade`).

## Como rodar

Aplicação gráfica (Swing) — requer ambiente com suporte a interface gráfica.

```bash
cd JavaSwingProjects/CadastroPessoas/CadastroPessoas/src
javac -d out App.java btn/*.java inputs/*.java model/*.java panel/*.java screen/*.java
java -cp out App
```
