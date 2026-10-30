import { Router } from "express";
import { atualizarCurso, atualizarProfessor, buscarCurso, buscarProfessor, criarCurso, criarProfessor, deletarCurso, deletarProfessor, listarTodosCursos, listarTodosProfessores } from "./services.js";

const routes = Router();

routes.get("/",(req,res) =>{
    res.status(200).send("Sistema de Cursos Técnicos");
})

//Métodos de Cursos
routes.post("/cursos",(req,res)=>{
    criarCurso(req.body);
    res.status(201).send("Curso cadastrado com sucesso");
})

routes.get("/cursos",(req,res) =>{
    res.status(200).json(listarTodosCursos());
})

routes.get("/cursos/:id",(req,res) =>{
    const curso = buscarCurso(req.params.id);
    if(!curso) return res.status(404).send("Curso não encontrado");
    res.status(200).json(curso);
})

routes.put("/cursos/:id",(req,res)=>{
    const cursoAtualizado = atualizarCurso(req.params.id,req.body);
    if(!cursoAtualizado) return res.status(404).send("Curso não encontrado");
    res.status(200).json(cursoAtualizado);
})

routes.delete("/cursos/:id",(req,res) =>{
    const deletado = deletarCurso(req.params.id);
    if(!deletado) return res.status(404).send("Curso não encontrado");
    res.status(200).send("Deletado com sucesso")
})

//Métodos de Professores
routes.post("/professores",(req,res) =>{
    criarProfessor(req.body);
    res.status(201).send("Professor cadastrado com sucesso")
})

routes.get("/professores",(req,res) =>{
    res.status(200).json(listarTodosProfessores());
})

routes.get("/professores/:id",(req,res) =>{
    const professor = buscarProfessor(req.params.id);
    if(!professor) return res.status(404).send("Professor não encontrado");
    res.status(200).json(professor);
})

routes.put("/professores/:id",(req,res)=>{
    const professorAtualizado = atualizarProfessor(req.params.id, req.body);
    if(!professorAtualizado) return res.status(404).send("Professor não encontrado");
    res.status(200).json(professorAtualizado);
})

routes.delete("/professores/:id",(req,res) =>{
    const deletado = deletarProfessor(req.params.id);
    if(!deletado) return res.status(404).send("Professor não encontrado");
    res.status(200).send("Deletado com sucesso")
})

//Métodos de Sobre
routes.get("/sobre",(req,res) =>{
    res.status(200).send("Informações sobre a instituição");
})

export default routes;
