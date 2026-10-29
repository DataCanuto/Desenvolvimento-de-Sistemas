import express from "express";
import { buscarAgendamentoPorId, listarAgendamentos, criarAgendamento, atualizarAgendamento, deletarAgendamento} from "./services.js";

const app = express();
app.use(express.json());

app.get("/",(req,res)=>{
    res.status(200).send("Barbearia Node Js");
})

app.get("/agendamentos", (req, res) => {
    res.status(200).json(listarAgendamentos());
})

app.get("/agendamentos/:id", (req, res) => {
    const index = buscarAgendamentoPorId(req.params.id);
    res.status(200).json(listarAgendamentos()[index])
})


app.post("/agendamentos", (req, res) => {
    const novoAgendamento = criarAgendamento(req.body);
    res.status(201).json(novoAgendamento)
})

app.put("/agendamentos/:id", (req, res) => {
    const agendamentoAtualizado = atualizarAgendamento(req.params.id, req.body);
    res.status(200).json(agendamentoAtualizado);
})

app.delete("/agendamentos/:id", (req, res) => {
    deletarAgendamento(req.params.id);
    res.status(200).send("Deletado com sucesso!")
})



export default app;