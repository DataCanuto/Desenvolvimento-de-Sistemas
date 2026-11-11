import express from "express";
import {
    listarLivros,
    buscarLivroPorId,
    criarLivro,
    atualizarLivro,
    deletarLivro
} from "./services.js";

const app = express();
app.use(express.json());

app.get("/", (req, res) => {
    res.status(200).send("API da Livraria");
})

app.get("/livros", (req, res) => {
    res.status(200).json(listarLivros());
})

app.get("/livros/:id", (req, res) => {
    const index = buscarLivroPorId(req.params.id);
    if (index === -1) {
        return res.status(404).json({ erro: "Livro não encontrado" });
    }

    res.status(200).json(listarLivros()[index])
})


app.post("/livros", (req, res) => {
    const novoLivro = criarLivro(req.body);
    res.status(201).json(novoLivro)
})

app.put("/livros/:id", (req, res) => {
    const livroAtualizado = atualizarLivro(req.params.id, req.body);
    if (!livroAtualizado) {
        return res.status(404).json({ erro: "Livro não encontrado" });
    }

    res.status(200).json(livroAtualizado);
})

app.delete("/livros/:id", (req, res) => {
    const deletado = deletarLivro(req.params.id);
    if (!deletado) {
        return res.status(404).json({ erro: "Livro não encontrado" });
    }

    res.status(200).send("Deletado com sucesso!")
})


export default app;