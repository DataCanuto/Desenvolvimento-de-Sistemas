# caluladoraSwing

Calculadora gráfica (Java Swing) com as quatro operações básicas, teclado numérico e display, organizada em painéis e botões customizados.

> Observação: o nome da pasta contém um erro de digitação ("caluladoraSwing"); mantido como está para não quebrar referências existentes. Veja também `JavaSwingProjects/calculadoraSwing`, uma pasta irmã sem código-fonte (apenas configurações de IDE).

## Conteúdo

- `Main.java` — ponto de entrada, abre `screen.Screen.Screen`.
- `screen/Screen/Screen.java` — `JFrame` principal, monta o display numérico e os painéis de números/operações.
- `Calculadora/Calculadora.java` — lógica de cálculo (`inserirNumero`, `processarOperacao`, `calcularResultado`), incluindo tratamento de divisão por zero.
- `panel/NumberPanel.java`, `panel/BtnPanel.java` — grades de botões numéricos e de operações (`+`, `-`, `x`, `/`, `=`, `C`).
- `btn/BtnNumber.java`, `btn/BtnSum.java`, `btn/BtnSub.java`, `btn/BtnMult.java`, `btn/BtnDiv.java`, `btn/BtnEqual.java`, `btn/BtnClear.java` — botões que disparam ações sobre a instância de `Calculadora`.
- `inputs/NumberTxtField/NumberTxtField.java` — campo de texto customizado usado como display.

## Como rodar

Aplicação gráfica (Swing) — requer ambiente com suporte a interface gráfica.

```bash
cd JavaSwingProjects/caluladoraSwing/src
javac -d out Main.java Calculadora/*.java btn/*.java inputs/NumberTxtField/*.java panel/*.java screen/Screen/*.java
java -cp out Main
```
