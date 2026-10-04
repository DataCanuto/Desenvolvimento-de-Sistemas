#include <iostream>
#include <iomanip>
using namespace std;

int numeros[10] = {0};
int quantidade = 0;

void menu(){
    cout << "\t\tMenu Principal" << endl;
    cout << "1. Cadastrar Numero" << endl;
    cout << "2. Exibir Valores" << endl;
    cout << "0. Sair do programa " << endl;
}

void add(){
    for (int i = 0; i<10; i++){
        if (numeros[i] == 0){
            cout << "Digite um valor para a posição " << i << ": ";
            cin >> numeros[i];
            quantidade++;
            break;
        }
    }
}

void menu_exibir(){
    cout << "\n\tMenu de Visualizacao" << endl;
    cout << "1. Exibir maior valor" << endl;
    cout << "2. Exibir menor valor" << endl;
    cout << "3. Exibir soma dos valores" << endl;
    cout << "4. Exibir media dos valores" << endl;
    cout << "5. Exibir numeros pares" << endl;
    cout << "6. Exibir numeros impares" << endl;
    cout << "7. Exibir todos os valores" << endl;
    cout << "0. Retornar ao menu principal " << endl;
}

int maior(){
    int maior = 0;
    for (int i = 0; i<10; i++){
        if (numeros[i] > maior){ maior = numeros[i]; }
    }
    return maior;
}

int menor(){
    int menor = numeros[0];
    for (int i = 0; i < 10; i++){
        if (numeros[i] < menor && numeros[i] != 0){ menor = numeros[i]; }
    }
    return menor;
}

int total(){
    int soma = 0;
    for (int i = 0; i<10; i++){ soma += numeros[i]; }
    return soma;
}

double media(){
    cout << fixed << setprecision(2);
    int soma = 0;
    for (int i = 0; i<10; i++){ soma += numeros[i]; }
    return 1.0*soma/quantidade;
}

void pares(){
    int pares = 0;
    for (int i = 0; i<10; i++){
        if (numeros[i] % 2 == 0 && numeros[i] != 0){
            cout << "[" << numeros[i] << "] ";
            pares++;
        }
    }
    cout <<"\nTotal de numeros pares: " << pares;
}

void impares(){
    int impares = 0;
    for (int i = 0; i<10; i++){
        if (numeros[i] % 2 != 0){
            cout << "[" << numeros[i] << "] ";
            impares++;
        }
    }
    cout <<"\nTotal de numeros impares: " << impares;
}

void exibir_valores(){
    for (int i = 0; i<10; i++){
        if (numeros[i] != 0){ cout << "[" << numeros[i] << "]" << " "; }
    }
}

int main(){
    int op_menu, op_exibir;
    do{
        menu();
        cout << "Digite sua opção: ";
        cin >> op_menu;
        switch(op_menu){
            case 1: add(); break;
            case 2:
                do{
                    menu_exibir();
                    cout << "Digite sua opção: ";
                    cin >> op_exibir;
                    switch(op_exibir){
                        case 1: cout << "Maior: " << maior() << endl; break;
                        case 2: cout << "Menor: " << menor() << endl; break;
                        case 3: cout << "Soma: " << total() << endl; break;
                        case 4: cout << "Media: " << media() << endl; break;
                        case 5: pares(); cout << endl; break;
                        case 6: impares(); cout << endl; break;
                        case 7: exibir_valores(); cout << endl; break;
                        case 0: cout << "Retornando..." << endl; break;
                    }
                }while(op_exibir != 0);
                break;
            case 0: cout << "Saindo do programa..." << endl; break;
        }
    }while(op_menu != 0);
}
