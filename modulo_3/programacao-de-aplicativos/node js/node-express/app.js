//import { livros, autores } from "./db.js" -> mockups com arrays
//import { buscarLivroPorId, buscarAutorPorId } from "./service.js"; -> serviço de arrays;
//trabalhando com models
import express from "express";
import db from "./db/connection.js";
import {
    listarLivros, buscarLivroPorId, criarLivro, atualizarLivro, deletarLivro,
    listarAutores, buscarAutorPorId, criarAutor, atualizarAutor, deletarAutor
} from "./service.js";


const app = express();
app.use(express.json());

//DB
db.authenticate().then(() => {
    console.log("Conectado com sucesso");
}).catch(err => {
    console.log("Erro ao conectar ", err)
})

//APP
app.get("/", (req, res) => {
    res.status(200).send("Node JS")
})


//------------- Livros -------------
app.get("/livros", async (req, res) => {
    const livros = await listarLivros();
    res.status(200).json(livros);
})

app.get("/livros/:id", async (req, res) => {
    const livro = await buscarLivroPorId(req.params.id);
    if(!livro) return res.status(404).send("Livro não encontrado!");
    res.status(200).json(livro);
});


app.post("/livros", async (req, res) => {
    const livro = await criarLivro(req.body);
    res.status(201).json(livro);
})

app.put("/livros/:id", async (req, res) => {
    const livro = await atualizarLivro(req.params.id, req.body);
    if(!livro) return res.status(404).send("Livro não encontrado!");
    res.status(200).json(livro);
})

app.delete("/livros/:id", async (req, res) => {
    const livro = await deletarLivro(req.params.id);
    if(!livro) return res.status(404).send("Livro não encontrado!");
    res.status(200).send("Deletado com sucesso!")
})

//------------- Autores -------------
app.get("/autores", async (req, res) => {
    const autores = await listarAutores();
    res.status(200).json(autores);
})

app.get("/autores/:id", async (req, res) => {
    const autor = await buscarAutorPorId(req.params.id);
    if (!autor) return res.status(404).send("Autor não encontrado");
    res.status(200).json(autor);
})

app.post("/autores", async (req, res) => {
    const autor = await criarAutor(req.body);
    res.status(201).json(autor);
})

app.put("/autores/:id", async (req, res) => {
    const autor = await atualizarAutor(req.params.id, req.body);
    if (!autor) return res.status(404).send("Autor não encontrado");
    res.status(200).json(autor);
})

app.delete("/autores/:id", async (req,res) =>{
    const autor = await deletarAutor(req.params.id);
    if (!autor) return res.status(404).send("Autor não encontrado");
    res.status(200).json(autor);

})
export default app;