#include <iostream>
using namespace std;
int main(){
    int n1, n2,aux;
    cout<<"Digite um valor para n1: ";
    cin>>n1;
    cout<<"Digite um valor para n2: ";
    cin>>n2;
    cout<<"Números digitados em ordem: "<<endl<<n1<<" "<<n2<<endl;
    aux = n1;
    n1 = n2;
    n2 = aux;
    cout<<"Números trocados: "<<endl<<n1<<" "<<n2;
}
