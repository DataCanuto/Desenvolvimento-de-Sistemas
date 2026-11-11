import express from "express";

//Pessoas
import {
    listarPessoas,
    buscarPessoaPorId,
    criarPessoa,
    atualizarPessoa,
    deletarPessoa
} from "./services.js";

const app = express();
app.use(express.json());

app.get("/", (req, res) => {
    res.status(200).send("API Pessoa - Passaporte");
})

app.get("/pessoas", (req, res) => {
    res.status(200).json(listarPessoas());
})

app.get("/pessoas/:id", (req, res) => {
    const index = buscarPessoaPorId(req.params.id);
    if (index === -1) {
        return res.status(404).json({ erro: "Pessoa não encontrado" });
    }

    res.status(200).json(listarPessoas()[index])
})


app.post("/pessoas", (req, res) => {
    const novoPessoa = criarPessoa(req.body);
    res.status(201).json(novoPessoa)
})

app.put("/pessoas/:id", (req, res) => {
    const pessoaAtualizado = atualizarPessoa(req.params.id, req.body);
    if (!pessoaAtualizado) {
        return res.status(404).json({ erro: "Pessoa não encontrado" });
    }

    res.status(200).json(pessoaAtualizado);
})

app.delete("/pessoas/:id", (req, res) => {
    const deletado = deletarPessoa(req.params.id);
    if (!deletado) {
        return res.status(404).json({ erro: "Pessoa não encontrado" });
    }

    res.status(200).send("Deletado com sucesso!")
})

//Passaportes
import {
    listarPassaportes,
    buscarPassaportePorId,
    criarPassaporte,
    atualizarPassaporte,
    deletarPassaporte
} from "./services.js";

app.get("/passaportes", (req, res) => {
    res.status(200).json(listarPassaportes());
})

app.get("/passaportes/:id", (req, res) => {
    const index = buscarPassaportePorId(req.params.id);
    if (index === -1) {
        return res.status(404).json({ erro: "Passaporte não encontrado" });
    }

    res.status(200).json(listarPassaportes()[index])
})


app.post("/passaportes", (req, res) => {
    const novoPassaporte = criarPassaporte(req.body);
    res.status(201).json(novoPassaporte)
})

app.put("/passaportes/:id", (req, res) => {
    const passaporteAtualizado = atualizarPassaporte(req.params.id, req.body);
    if (!passaporteAtualizado) {
        return res.status(404).json({ erro: "Passaporte não encontrado" });
    }

    res.status(200).json(passaporteAtualizado);
})

app.delete("/passaportes/:id", (req, res) => {
    const deletado = deletarPassaporte(req.params.id);
    if (!deletado) {
        return res.status(404).json({ erro: "Passaporte não encontrado" });
    }

    res.status(200).send("Deletado com sucesso!")
})


export default app;