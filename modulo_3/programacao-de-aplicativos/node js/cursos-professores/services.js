import { cursos } from "./db-simulation.js";
import { professores } from "./db-simulation.js";
//Serviços de Curso
export function buscarCurso(id){
    return cursos.find(curso => curso.id === Number(id));
}

export function listarTodosCursos(){
    return cursos;
}

export function criarCurso(curso){
    cursos.push(curso);
    return curso;
}

export function atualizarCurso(id,dadosAtualizados){
    const curso = buscarCurso(id);
    if(!curso) return null;

    curso.titulo = dadosAtualizados.titulo;
    return curso;
}

export function deletarCurso(id){
    const index = cursos.findIndex(curso => curso.id === Number(id));
    if(index === -1) return false;

    cursos.splice(index,1);
    return true;
}

//Serviços de professor
export function buscarProfessor(id){
    return professores.find(professor => professor.id === Number(id));
}

export function listarTodosProfessores(){
    return professores;
}

export function criarProfessor(professor){
    professores.push(professor);
    return professor;
}

export function atualizarProfessor(id,dadosAtualizados){
    const professor = buscarProfessor(id);
    if(!professor) return null;

    professor.nome = dadosAtualizados.nome;
    professor.curso = dadosAtualizados.curso;
    return professor;
}

export function deletarProfessor(id){
    const index = professores.findIndex(professor => professor.id === Number(id));
    if(index === -1) return false;

    professores.splice(index,1);
    return true;
}