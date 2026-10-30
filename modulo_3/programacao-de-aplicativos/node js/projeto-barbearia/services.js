import agendamentos from "./arrays.js";

export function listarAgendamentos(){
    return agendamentos;
}

export function buscarAgendamentoPorId(id){
    return agendamentos.findIndex(agendamento => agendamento.id === Number(id));
}

export function criarAgendamento(dados){
    const novoAgendamento = { id: agendamentos.length + 1, ...dados };
    agendamentos.push(novoAgendamento);
    return novoAgendamento;
}

export function atualizarAgendamento(id, dados){
    const index = buscarAgendamentoPorId(id);
    agendamentos[index] = { ...agendamentos[index], ...dados };
    return agendamentos[index];
}

export function deletarAgendamento(id){
    const index = buscarAgendamentoPorId(id);
    agendamentos.splice(index, 1);
}