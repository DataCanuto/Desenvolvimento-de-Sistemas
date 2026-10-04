#include <iostream>
#include <string>
using namespace std;

struct Livro {
    int id;
    string titulo;
    string autor;
    bool disponivel;
};

struct Aluno {
    int matricula;
    string nome;
};

struct Emprestimo {
    int id;
    Livro livro;
    Aluno aluno;
    string dataEmprestimo;
    string dataDevolucao;
};

Livro livros[50];
Aluno alunos[50];
Emprestimo emprestimos[50];
int qtdLivros = 0, qtdAlunos = 0, qtdEmprestimos = 0;

void menuPrincipal() {
    cout << "\n=== Sistema de Biblioteca SENAI ===" << endl;
    cout << "1. Gerenciar Livros" << endl;
    cout << "2. Gerenciar Alunos" << endl;
    cout << "3. Gerenciar Emprestimos" << endl;
    cout << "0. Sair" << endl;
    cout << "Opcao: ";
}

void cadastrarLivro() {
    cout << "\n-- Cadastrar Livro --" << endl;
    livros[qtdLivros].id = qtdLivros + 1;
    cout << "Titulo: "; cin.ignore(); getline(cin, livros[qtdLivros].titulo);
    cout << "Autor: "; getline(cin, livros[qtdLivros].autor);
    livros[qtdLivros].disponivel = true;
    qtdLivros++;
    cout << "Livro cadastrado com sucesso!" << endl;
}

void listarLivros() {
    cout << "\n-- Lista de Livros --" << endl;
    for (int i = 0; i < qtdLivros; i++) {
        cout << "ID: " << livros[i].id << " | Titulo: " << livros[i].titulo
             << " | Autor: " << livros[i].autor
             << " | Status: " << (livros[i].disponivel ? "Disponivel" : "Emprestado") << endl;
    }
}

void cadastrarAluno() {
    cout << "\n-- Cadastrar Aluno --" << endl;
    alunos[qtdAlunos].matricula = qtdAlunos + 1;
    cout << "Nome: "; cin.ignore(); getline(cin, alunos[qtdAlunos].nome);
    qtdAlunos++;
    cout << "Aluno cadastrado com sucesso!" << endl;
}

void realizarEmprestimo() {
    int idLivro, matriculaAluno;
    cout << "\n-- Realizar Emprestimo --" << endl;
    cout << "ID do livro: "; cin >> idLivro;
    cout << "Matricula do aluno: "; cin >> matriculaAluno;
    
    bool livroEncontrado = false, alunoEncontrado = false;
    int idxLivro = -1, idxAluno = -1;
    
    for (int i = 0; i < qtdLivros; i++) {
        if (livros[i].id == idLivro && livros[i].disponivel) {
            idxLivro = i; livroEncontrado = true; break;
        }
    }
    for (int i = 0; i < qtdAlunos; i++) {
        if (alunos[i].matricula == matriculaAluno) {
            idxAluno = i; alunoEncontrado = true; break;
        }
    }
    
    if (livroEncontrado && alunoEncontrado) {
        emprestimos[qtdEmprestimos].id = qtdEmprestimos + 1;
        emprestimos[qtdEmprestimos].livro = livros[idxLivro];
        emprestimos[qtdEmprestimos].aluno = alunos[idxAluno];
        livros[idxLivro].disponivel = false;
        qtdEmprestimos++;
        cout << "Emprestimo realizado com sucesso!" << endl;
    } else {
        cout << "Livro ou aluno nao encontrado!" << endl;
    }
}

int main() {
    int op;
    do {
        menuPrincipal();
        cin >> op;
        switch (op) {
            case 1: {
                int subOp;
                cout << "1. Cadastrar | 2. Listar\nOpcao: "; cin >> subOp;
                if (subOp == 1) cadastrarLivro();
                else listarLivros();
                break;
            }
            case 2: cadastrarAluno(); break;
            case 3: realizarEmprestimo(); break;
            case 0: cout << "Saindo..." << endl; break;
        }
    } while (op != 0);
    return 0;
}
