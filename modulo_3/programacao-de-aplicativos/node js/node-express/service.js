//import { livros, autores } from "./db.js";

import {Livro, Autor } from "./models/index.js";

/*
----------- Funções direcionadas aos mockups de arrays ----------
export function buscarLivroPorId(id) {
    return livros.findIndex(livro => livro.id === Number(id));
}

export function buscarAutorPorId(id) {
    return autores.findIndex(autor => autor.id === Number(id))
}*/

// -------------- Livros -------------
export async function listarLivros(){
    return Livro.findAll();
}

export async function buscarLivroPorId(id){
    return Livro.findByPk(id);
}

export async function criarLivro(dados){
    return Livro.create(dados);
}

export async function atualizarLivro(id,dados){
    const livro = await Livro.findByPk(id);
    if(!livro) return null;
    return livro.update(dados);
}

export async function deletarLivro(id){
    const livro = await Livro.findByPk(id);
    if(!livro) return null;
    await livro.destroy();
    return livro;
}






// -------------- Autores -------------
export async function listarAutores(){
    return Autor.findAll();
}

export async function buscarAutorPorId(id) {
    return Autor.findByPk(id);
}

export async function criarAutor(dados) {
    return Autor.create(dados);
}

export async function atualizarAutor(id, dados) {
    const autor = await Autor.findByPk(id);
    if (!autor) return null;
    return autor.update(dados);
}

export async function deletarAutor(id){
    const autor = await Autor.findByPk(id);
    if(!autor) return null;
    autor.destroy();
    return autor;
}