#include <iostream>
#include <string>
using namespace std;

struct Veiculo {
    int id;
    string modelo;
    string placa;
    string tipo; // carro, moto, caminhao
    double valorDiaria;
    bool disponivel;
};

struct Cliente {
    int id;
    string nome;
    string cpf;
    string telefone;
};

struct Locacao {
    int id;
    Veiculo veiculo;
    Cliente cliente;
    int diasLocacao;
    double valorTotal;
    bool ativa;
};

Veiculo veiculos[20];
Cliente clientes[20];
Locacao locacoes[50];
int qtdVeiculos = 0, qtdClientes = 0, qtdLocacoes = 0;

void menuPrincipal() {
    cout << "\n====== Sistema de Locadora de Veiculos ======" << endl;
    cout << "1. Gerenciar Veiculos" << endl;
    cout << "2. Gerenciar Clientes" << endl;
    cout << "3. Realizar Locacao" << endl;
    cout << "4. Devolver Veiculo" << endl;
    cout << "5. Listar Locacoes Ativas" << endl;
    cout << "0. Sair" << endl;
    cout << "Opcao: ";
}

void cadastrarVeiculo() {
    cout << "\n-- Cadastrar Veiculo --" << endl;
    veiculos[qtdVeiculos].id = qtdVeiculos + 1;
    cout << "Modelo: "; cin.ignore(); getline(cin, veiculos[qtdVeiculos].modelo);
    cout << "Placa: "; getline(cin, veiculos[qtdVeiculos].placa);
    cout << "Tipo (carro/moto/caminhao): "; getline(cin, veiculos[qtdVeiculos].tipo);
    cout << "Valor da diaria: R$"; cin >> veiculos[qtdVeiculos].valorDiaria;
    veiculos[qtdVeiculos].disponivel = true;
    qtdVeiculos++;
    cout << "Veiculo cadastrado com sucesso!" << endl;
}

void listarVeiculos() {
    cout << "\n-- Lista de Veiculos --" << endl;
    for (int i = 0; i < qtdVeiculos; i++) {
        cout << "ID: " << veiculos[i].id 
             << " | Modelo: " << veiculos[i].modelo
             << " | Placa: " << veiculos[i].placa
             << " | Tipo: " << veiculos[i].tipo
             << " | Diaria: R$" << veiculos[i].valorDiaria
             << " | Status: " << (veiculos[i].disponivel ? "Disponivel" : "Locado") << endl;
    }
}

void cadastrarCliente() {
    cout << "\n-- Cadastrar Cliente --" << endl;
    clientes[qtdClientes].id = qtdClientes + 1;
    cout << "Nome: "; cin.ignore(); getline(cin, clientes[qtdClientes].nome);
    cout << "CPF: "; getline(cin, clientes[qtdClientes].cpf);
    cout << "Telefone: "; getline(cin, clientes[qtdClientes].telefone);
    qtdClientes++;
    cout << "Cliente cadastrado com sucesso!" << endl;
}

void realizarLocacao() {
    int idVeiculo, idCliente, dias;
    cout << "\n-- Realizar Locacao --" << endl;
    cout << "ID do veiculo: "; cin >> idVeiculo;
    cout << "ID do cliente: "; cin >> idCliente;
    cout << "Numero de dias: "; cin >> dias;
    
    int idxVeiculo = -1, idxCliente = -1;
    for (int i = 0; i < qtdVeiculos; i++) {
        if (veiculos[i].id == idVeiculo && veiculos[i].disponivel) { idxVeiculo = i; break; }
    }
    for (int i = 0; i < qtdClientes; i++) {
        if (clientes[i].id == idCliente) { idxCliente = i; break; }
    }
    
    if (idxVeiculo >= 0 && idxCliente >= 0) {
        locacoes[qtdLocacoes].id = qtdLocacoes + 1;
        locacoes[qtdLocacoes].veiculo = veiculos[idxVeiculo];
        locacoes[qtdLocacoes].cliente = clientes[idxCliente];
        locacoes[qtdLocacoes].diasLocacao = dias;
        locacoes[qtdLocacoes].valorTotal = veiculos[idxVeiculo].valorDiaria * dias;
        locacoes[qtdLocacoes].ativa = true;
        veiculos[idxVeiculo].disponivel = false;
        cout << "Locacao realizada! Valor total: R$" << locacoes[qtdLocacoes].valorTotal << endl;
        qtdLocacoes++;
    } else {
        cout << "Veiculo indisponivel ou cliente nao encontrado!" << endl;
    }
}

void devolverVeiculo() {
    int idLocacao;
    cout << "\n-- Devolver Veiculo --" << endl;
    cout << "ID da locacao: "; cin >> idLocacao;
    for (int i = 0; i < qtdLocacoes; i++) {
        if (locacoes[i].id == idLocacao && locacoes[i].ativa) {
            locacoes[i].ativa = false;
            for (int j = 0; j < qtdVeiculos; j++) {
                if (veiculos[j].placa == locacoes[i].veiculo.placa) {
                    veiculos[j].disponivel = true; break;
                }
            }
            cout << "Veiculo devolvido com sucesso!" << endl;
            return;
        }
    }
    cout << "Locacao nao encontrada!" << endl;
}

void listarLocacoes() {
    cout << "\n-- Locacoes Ativas --" << endl;
    for (int i = 0; i < qtdLocacoes; i++) {
        if (locacoes[i].ativa) {
            cout << "ID: " << locacoes[i].id
                 << " | Cliente: " << locacoes[i].cliente.nome
                 << " | Veiculo: " << locacoes[i].veiculo.modelo
                 << " | Dias: " << locacoes[i].diasLocacao
                 << " | Total: R$" << locacoes[i].valorTotal << endl;
        }
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
                if (subOp == 1) cadastrarVeiculo();
                else listarVeiculos();
                break;
            }
            case 2: cadastrarCliente(); break;
            case 3: realizarLocacao(); break;
            case 4: devolverVeiculo(); break;
            case 5: listarLocacoes(); break;
            case 0: cout << "Encerrando o sistema..." << endl; break;
        }
    } while (op != 0);
    return 0;
}
