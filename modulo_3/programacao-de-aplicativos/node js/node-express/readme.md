# API de livros e autores

Projeto didático desenvolvido com Node.js e Express para praticar a criação de uma API REST. A aplicação possui rotas para consultar e manipular livros e autores, além de funções de serviço para localizar registros pelo identificador.

## Tecnologias

- **Node.js** para executar JavaScript no servidor.
- **Express** para configurar o servidor HTTP e as rotas.
- **Nodemon** para reiniciar o servidor automaticamente durante o desenvolvimento.
- **Sequelize e SQLite**: há uma configuração inicial de conexão em `db/connection.js`; a API ainda utiliza arrays em memória para os dados.

## Como executar

No terminal, dentro desta pasta do projeto:

```bash
npm install
npm run dev
```

O servidor está configurado para usar a porta `3000`.

## Rotas disponíveis

| Método | Caminho | Descrição |
|---|---|---|
| GET | `/` | Retorna uma mensagem de confirmação do servidor. |
| GET | `/livros` | Retorna a lista de livros. |
| GET | `/livros/:id` | Consulta um livro pelo ID. |
| POST | `/livros` | Adiciona o JSON enviado no corpo da requisição. |
| PUT | `/livros/:id` | Atualiza o título do livro indicado pelo ID. |
| DELETE | `/livros/:id` | Remove o livro indicado pelo ID. |
| GET | `/autores` | Retorna a lista de autores. |
| GET | `/autores/:id` | Consulta um autor pelo ID. |
| POST | `/autores` | Rota de cadastro de autor, ainda em desenvolvimento. |
| PUT | `/autores/:id` | Atualiza o nome do autor indicado pelo ID. |

As rotas que recebem JSON usam o middleware `express.json()`. Por exemplo, para cadastrar um livro, envie uma requisição `POST /livros` com o cabeçalho `Content-Type: application/json` e um corpo como:

```json
{
  "id": 2,
  "titulo": "Novo livro"
}
```

## Organização

- `server.js`: inicia o servidor na porta 3000.
- `app.js`: configura o Express, o middleware e as rotas da API.
- `db.js`: contém os arrays iniciais de livros e autores.
- `service.js`: contém funções para localizar livros e autores pelo ID.
- `db/connection.js`: contém a configuração inicial do Sequelize com SQLite.
- `RESPOSTAS.TXT`: reúne respostas sobre os conceitos estudados no projeto.

## Observações

Os endpoints de livros e autores ainda trabalham com arrays em memória. Portanto, os dados alterados durante a execução não são persistidos e voltam aos valores iniciais quando o processo é reiniciado. A configuração do SQLite é um primeiro passo e ainda não substitui esses arrays nas operações da API.

A API também está em desenvolvimento: o cadastro de autores ainda precisa ser concluído, e as rotas por ID não tratam todos os casos de identificadores inexistentes.