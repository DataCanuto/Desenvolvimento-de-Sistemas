import livros from "./array-db.js";

export function listarLivros() {
    return livros;
}

export function buscarLivroPorId(id) {
    return livros.findIndex(livro => livro.id === Number(id));
}

export function criarLivro(dados) {
    const novoLivro = {
        ...dados,
        id: Math.max(0, ...livros.map(livro => livro.id)) + 1
    };
    livros.push(novoLivro);
    return novoLivro;
}

export function atualizarLivro(id, dados) {
    const index = buscarLivroPorId(id);
    if (index === -1) {
        return null;
    }

    livros[index] = { ...livros[index], ...dados, id: livros[index].id };
    return livros[index];
}

export function deletarLivro(id) {
    const index = buscarLivroPorId(id);
    if (index === -1) {
        return false;
    }

    livros.splice(index, 1);
    return true;
}