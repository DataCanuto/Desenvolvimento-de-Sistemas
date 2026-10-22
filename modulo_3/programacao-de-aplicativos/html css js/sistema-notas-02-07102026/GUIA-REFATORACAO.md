# Guia de organização — Sistema de Notas

Este guia **não altera seu código**. Ele só explica o que está acontecendo, aponta os pontos problemáticos e dá uma estrutura para você mesmo implementar as correções e o restante das funcionalidades.

---

## 1. Diagnóstico rápido

Olhando `index.js` e `index.html` juntos, encontrei estas inconsistências:

### 1.1. `campos` aponta para IDs que não existem no HTML
```js
const campos = [
    document.querySelector('#nome-aluno'),
    document.querySelector('#nota-aluno'),
    document.querySelector('#situacao-aluno')
]
```
No HTML os inputs são `id="nome"` e `id="nota"` — não existe `nome-aluno`, `nota-aluno` nem `situacao-aluno`. Resultado: `querySelector` retorna `null` para os três, e qualquer uso de `campos[0].value` vai quebrar.

**Pergunta para você responder sozinho:** os IDs devem ser ajustados no JS ou no HTML? Qual combinação faz sentido, considerando que você também vai precisar de um lugar para mostrar a "Situação" na tabela (ela não é um input, é só exibida)?

### 1.2. O formulário é selecionado por uma classe que não existe
```js
const form = document.querySelector('.form')
```
O `<form>` no HTML não tem `class="form"`. Pense em como selecionar o form de forma mais direta (ex: por tag, por um id, ou adicionando a classe no HTML).

### 1.3. `calcularMediaTurma` trata `nota` como se fosse um elemento do DOM
```js
function calcularMediaTurma(alunos){
    let somaNotas = 0;
    alunos.forEach(function(aluno){
        somaNotas += parseFloat(aluno.nota.value)   // <- aqui
    })
    return somaNotas / alunos.length
}
```
Repare em `addAluno`: `nota` já é convertida com `parseFloat` **antes** de entrar no array `alunos`:
```js
function addAluno(nome,nota){
    alunos.push({
        nome:nome,
        nota:parseFloat(nota)
    })
}
```
Ou seja, `aluno.nota` já é um **número puro** (ex: `8.5`), não um input do DOM. Não existe `.value` em um número — isso vai gerar `NaN`.

### 1.4. `verMenorNota` nunca encontra a menor nota
```js
function verMenorNota(alunos){
    let menor = 0;
    for (let i = 0; i < alunos.length; i++){
        if(alunos[i].nota < menor){   // <- nota < 0 ? quase nunca
            menor = alunos[i].nota
        }
    }
    return menor;
}
```
Como `menor` começa em `0` e a comparação é "a nota é **menor** que menor", e notas de prova são sempre ≥ 0, essa condição praticamente nunca é verdadeira. A função sempre vai retornar `0`.

Pense: qual deveria ser o valor inicial de `menor` para que a primeira nota real do array sempre "vença" essa comparação?

### 1.5. `#total-alunos` nunca é atualizado
O elemento existe no HTML (`<p id="total-alunos"></p>`) e a constante `totalAlunos` é criada no JS, mas nenhuma linha do código escreve nela.

### 1.6. A "Situação" nunca aparece na tabela
Você calcula `situacao` dentro do submit:
```js
const situacao = verificarSituacao(nota);
```
...mas depois, ao montar as células (`td`), o código usa `campos.forEach` e pega `campo.value` — ou seja, só repete o que já está nos inputs (nome, nota). A variável `situacao` fica sem uso.

---

## 2. Conceito-chave: dois vetores com papéis diferentes

Esse é o ponto central da sua dúvida. No seu projeto você tem (ou deveria ter) **dois tipos de vetor**, e eles não devem se misturar:

| Vetor | O que guarda | Para que serve |
|---|---|---|
| `campos` | Referências aos elementos do **DOM** (os `<input>`) | Ler o que o usuário digitou e limpar o formulário depois do submit |
| `alunos` | **Dados** já processados (`{ nome: string, nota: number }`) | Fazer cálculos (média, maior, menor, situação) e alimentar a tabela |

Regra prática:
- Funções que leem a **tela** (inputs) → recebem/usam `campos`.
- Funções que fazem **cálculo/regra de negócio** (média, maior nota, menor nota, situação) → recebem/usam `alunos`, nunca `campos`.

Isso explica o bug do item 1.3: `calcularMediaTurma` já recebe `alunos` (dados), então é um erro tentar ler `.value` de dentro dela — `.value` só existe em elementos do DOM, que estão em `campos`.

---

## 3. Sugestão de organização do arquivo `index.js`

Sem reescrever a lógica, você pode reorganizar o arquivo em blocos, sempre na mesma ordem. Isso ajuda a não misturar "o que é DOM" com "o que é dado":

```js
// ===== 1. Seleção de elementos do DOM =====
// (inputs do formulário, elementos de saída, botões, tbody, etc.)


// ===== 2. Estado da aplicação =====
// o array `alunos` mora aqui — é a "fonte da verdade" dos dados


// ===== 3. Funções de regra de negócio (não tocam no DOM) =====
// addAluno, verificarSituacao, calcularMediaTurma, verMaiorNota, verMenorNota
// → todas recebem `alunos` ou valores simples, nunca elementos do DOM


// ===== 4. Funções que manipulam o DOM =====
// criar <tr>/<td> da tabela, atualizar #total-alunos,
// escrever o resultado de média/maior/menor na tela, limpar formulário (clear)


// ===== 5. Handlers de evento =====
// o que acontece no submit do form
// o que acontece no click de cada botão de estatística


// ===== 6. Registro dos listeners =====
// form.addEventListener(...)
// btnMedia.addEventListener(...)
// etc. — de preferência tudo no final do arquivo
```

Com essa separação, fica mais fácil responder "essa função deveria receber `campos` ou `alunos`?" — é só olhar em qual bloco ela está.

---

## 4. Passo a passo para ligar os botões de estatística (média, maior, menor nota)

Hoje `calcularMediaTurma`, `verMaiorNota` e `verMenorNota` existem mas **nunca são chamadas**. Para usá-las, faltam três coisas:

### 4.1. No HTML
Adicione um botão e um elemento de saída para cada operação, por exemplo:
```html
<button type="button" id="btn-media">Calcular média da turma</button>
<p id="resultado-media"></p>

<button type="button" id="btn-maior">Maior nota</button>
<p id="resultado-maior"></p>

<button type="button" id="btn-menor">Menor nota</button>
<p id="resultado-menor"></p>
```
Use `type="button"` (não `submit`), para não disparar o envio do formulário.

### 4.2. No JS — selecionar os novos elementos
No bloco "1. Seleção de elementos do DOM", adicione as referências aos botões e aos parágrafos de resultado.

### 4.3. No JS — criar os handlers de click
Cada botão deve, ao ser clicado:
1. Chamar a função de cálculo correspondente passando `alunos` (o array de **dados**, não `campos`).
2. Escrever o resultado no `textContent` do elemento de saída.

Esqueleto (sem a implementação pronta, para você completar):
```js
btnMedia.addEventListener('click', function(){
    // tratar o caso de lista vazia antes de calcular
    // chamar calcularMediaTurma(alunos)
    // colocar o resultado em resultadoMedia.textContent
})
```

### 4.4. Cuidado com lista vazia
Se `alunos.length === 0`, `calcularMediaTurma` vai dividir por zero e gerar `NaN`. Pense em como tratar esse caso antes de chamar a função (ex: checar o tamanho do array e mostrar uma mensagem como "Nenhum aluno cadastrado ainda").

### 4.5. Checklist de verificação manual
- [ ] Cadastrei pelo menos 2 alunos com notas diferentes.
- [ ] Cliquei em "Calcular média" e o número exibido bate com a conta manual (soma das notas ÷ quantidade).
- [ ] Cliquei em "Maior nota" e apareceu a nota mais alta cadastrada.
- [ ] Cliquei em "Menor nota" e apareceu a nota mais baixa cadastrada (depois de corrigir o bug do item 1.4).
- [ ] Sem nenhum aluno cadastrado, os botões não mostram `NaN` nem travam a página.

---

## 5. Checklist geral de autoestudo

Ordem sugerida para você implementar e testar, uma coisa por vez:

1. [ ] Corrigir os seletores de `campos` para casar com os IDs reais do HTML (ou ajustar os IDs no HTML).
2. [ ] Corrigir a seleção do `form` (ela usa `.form`, que não existe).
3. [ ] Fazer a "Situação" aparecer de fato na tabela (hoje ela é calculada e descartada).
4. [ ] Atualizar `#total-alunos` a cada novo cadastro.
5. [ ] Corrigir `calcularMediaTurma` (remover o `.value`, já que `aluno.nota` é número).
6. [ ] Corrigir o valor inicial de `menor` em `verMenorNota`.
7. [ ] Adicionar os botões e elementos de saída de média/maior/menor no HTML.
8. [ ] Criar e registrar os handlers de click que chamam essas três funções passando `alunos`.
9. [ ] Tratar o caso de array vazio nos três cálculos.
10. [ ] Testar manualmente com o checklist da seção 4.5.

Depois de passar por esses 10 passos, o sistema deve: cadastrar alunos corretamente, mostrar nome/nota/situação na tabela, manter o total de alunos atualizado, e calcular média/maior/menor nota sob demanda ao clicar nos botões.
