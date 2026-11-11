//Pessoas 
import { pessoas, passaportes } from "./db.js";
export function listarPessoas() {
    return pessoas;
}

export function buscarPessoaPorId(id) {
    return pessoas.findIndex(pessoa => pessoa.id === Number(id));
}

export function criarPessoa(dados) {
    const novoPessoa = {
        ...dados,
        id: Math.max(0, ...pessoas.map(pessoa => pessoa.id)) + 1
    };
    pessoas.push(novoPessoa);
    return novoPessoa;
}

export function atualizarPessoa(id, dados) {
    const index = buscarPessoaPorId(id);
    if (index === -1) {
        return null;
    }

    pessoas[index] = {...pessoas[index], ...dados, id: pessoas[index].id };
    return pessoas[index];
}

export function deletarPessoa(id) {
    const index = buscarPessoaPorId(id);
    if (index === -1) {
        return false;
    }

    pessoas.splice(index, 1);
    return true;
}

//Passaportes
export function listarPassaportes() {
    return passaportes;
}

export function buscarPassaportePorId(id) {
    return passaportes.findIndex(passaporte => passaporte.id === Number(id));
}

export function criarPassaporte(dados) {
    const novoPassaporte = {
        ...dados,
        id: Math.max(0, ...passaportes.map(passaporte => passaporte.id)) + 1
    };
    passaportes.push(novoPassaporte);
    return novoPassaporte;
}

export function atualizarPassaporte(id, dados) {
    const index = buscarPassaportePorId(id);
    if (index === -1) {
        return null;
    }

    passaportes[index] = {...passaportes[index], ...dados, id: passaportes[index].id };
    return passaportes[index];
}

export function deletarPassaporte(id) {
    const index = buscarPassaportePorId(id);
    if (index === -1) {
        return false;
    }

    passaportes.splice(index, 1);
    return true;
}