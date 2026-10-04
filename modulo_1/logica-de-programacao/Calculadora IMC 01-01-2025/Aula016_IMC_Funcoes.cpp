#include <iostream>
using namespace std;
double altura = 0, peso = 0, imc = 0;
string sexo;
void menu(){
    cout<<"\n--Menu Principal--\n";
    cout<<"1. Calcular IMC\n"; cout<<"2. Exibir Classificação\n";
    cout<<"3. Zerar dados\n"; cout<<"4. Sair\n";
}
double getIMC(double a, double b){ imc = a / (b * b); return imc; }
void getClass(double i, string s){
    if(sexo == "M"){
        if(imc < 20) cout<<"Abaixo do peso";
        else if(imc >= 20 && imc < 25) cout<<"Normal";
        else if(imc >= 25 && imc < 30) cout<<"Obesidade leve";
        else if(imc >= 30 && imc <40) cout<<"Obesidade moderada";
        else cout<<"Obesidade mórbida";
    }
    else if(sexo == "F"){
        if(imc < 19) cout<<"Abaixo do peso";
        else if(imc >= 19 && imc < 24) cout<<"Normal";
        else if(imc >= 24 && imc < 29) cout<<"Obesidade leve";
        else if(imc >= 29 && imc <39) cout<<"Obesidade moderada";
        else cout<<"Obesidade mórbida";
    }
}
int main(){
    int op;
    do{
        menu(); cout<<"Escolha sua opção: "; cin>>op;
        switch(op){
            case 1: cout<<"Peso: "; cin>>peso; cout<<"Altura: "; cin>>altura; getIMC(peso,altura); cout<<"IMC: "<<imc<<endl; break;
            case 2: cout<<"Sexo (M/F): \nDigite a sua opção: "<<endl; cin>>sexo; getClass(imc,sexo); break;
            case 3: cout<<"Zerando informações..."<<endl; altura = peso = imc = 0; break;
            case 4: cout<<"Saindo do programa..."<<endl; break;
        }
    }while (op != 4);
}
