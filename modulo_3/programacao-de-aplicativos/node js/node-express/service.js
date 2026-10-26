import { livros, autores } from "./db.js";

export function buscarLivroPorId(id) {
    return livros.findIndex(livro => livro.id === Number(id));
}

export function buscarAutorPorId(id) {
    return autores.findIndex(autor => autor.id === Number(id))
}