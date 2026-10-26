import express from "express";
import { livros, autores } from "./db.js"
import { buscarLivroPorId, buscarAutorPorId } from "./service.js";

const app = express();

app.get("/", (req, res) => {
    res.status(200).send("Node JS")
})


//Livros
app.get("/livros", (req, res) => {
    res.status(200).json(livros);
})

app.get("/livros/:id", (req, res) => {
    const index = buscarLivroPorId(req.params.id);
    res.status(200).json(livros[index])
})

app.use(express.json());
app.post("/livros", (req, res) => {
    livros.push(req.body);
    res.status(201).send("livro cadastrado com sucesso")
})

app.put("/livros/:id", (req, res) => {
    const i = buscarLivroPorId(req.params.id);
    livros[i].titulo = req.body.titulo;
    res.status(200).json(livros);
})

app.delete("/livros/:id", (req, res) => {
    const i = buscarLivroPorId(req.params.id);
    livros.splice(i, 1);
    res.status(200).send("Deletado com sucesso!")
})

//Autores
app.get("/autores", (req, res) => {
    res.status(200).json(autores);
})

app.get("/autores/:id", (req, res) => {
    const i = buscarAutorPorId(req.params.id);
    res.status(200).json(autores[i]);
})

app.use(express.json());
app.post("/autores", (req, res) => {
    livros.push(req.body);
    res.status(201).send("autor cadastrado com sucesso")
})

app.put("/autores/:id", (req, res) => {
    const i = buscarAutorPorId(req.params.id);
    autores[i].nome = req.body.nome;
    res.status(200).json(autores);
})

export default app;