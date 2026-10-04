#include <iostream>
using namespace std;

int main(){
    string nome;
    int idade;
    
    cout << "Bem-vindo ao programa de introducao ao C++!" << endl;
    cout << "Digite seu nome: ";
    cin >> nome;
    cout << "Digite sua idade: ";
    cin >> idade;
    
    cout << "\nOla, " << nome << "!" << endl;
    cout << "Voce tem " << idade << " anos." << endl;
    
    return 0;
}
