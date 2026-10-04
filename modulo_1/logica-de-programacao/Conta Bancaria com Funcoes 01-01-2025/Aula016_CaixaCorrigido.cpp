#include <iostream>
using namespace std;
double saldo = 0;
void menuCaixa(){
    cout<<"\n\n--Menu Principal--\n"<<endl;
    cout<<"1 - Consultar saldo"<<endl;
    cout<<"2 - Realizar depósito"<<endl;
    cout<<"3 - Saque"<<endl;
    cout<<"4 - Sair"<<endl;
}
void getSaldo(){ cout<<"Saldo disponível: R$"<<saldo<<endl; }
double realizarDeposito(double valor){ return saldo += valor; }
bool realizarSaque(double valor){
    if (valor <= saldo){ saldo -= valor; return true; }
    else { return false; }
}
int main(){
    int op = 0; double valor = 0;
    do{
        menuCaixa();
        cout<<"Informe a opção desejada: "; cin>>op;
        switch(op){
            case 1: getSaldo(); break;
            case 2:
                do{
                    cout<<"Informe valor de depósito: R$"; cin>>valor;
                    if(realizarDeposito(valor)){ cout<<"Depósito realizado com sucesso!\nSaldo atualizado: "<<saldo<<endl; }
                    else { cout<<"Não foi possível realizar depósito\n Verifique informações \nSeu saldo: "<<saldo<<endl; }
                    cout<<"\nDigite 0 para voltar para o menu ou informe outro valor de depósito."<<endl;
                }while (valor != 0); break;
            case 3:
                do {
                    cout<<"Informe valor saque: R$"<<endl; cin>>valor;
                    if (realizarSaque(valor)){ cout<<"Saque realizado com sucesso!\nSaldo atualizado: "<<saldo<<endl; }
                    else{ cout<<"Saldo insuficiente!\nSaldo: "<<saldo<<endl; }
                    cout<<"0 para voltar para o menu ou informe outro valor de depósito."<<endl;
                }while(valor !=0); break;
            case 4: cout<<"Saindo do programa..."; break;
            default: cout<<"Opção inválida!"<<endl; break;
        }
    }while(op !=4);
}
