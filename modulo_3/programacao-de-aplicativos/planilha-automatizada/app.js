var campos = [
    document.querySelector('#tipo-tabela'),
    document.querySelector('#percentual-valor'),

    document.querySelector('#desconto-ir'),
    document.querySelector('#recupere-ir')
];

const thead = document.querySelector('table thead');

const tbody = document.querySelector('table tbody');

const form = document.querySelector('form');

const inputValor = document.querySelector('#valor');

const inputPercentual = document.querySelector('#percentual-valor');

const inputDesconto = document.querySelector('#desconto-ir');

const inputRecupere = document.querySelector('#recupere-ir');

const retornoTipoTabela = document.querySelector('#retorno-tipo-tabela');

function calcularPercentualSobreValor(valor, percentual) {
    return valor * (percentual / 100);
}

function calcularDescontoIr(valor, percentual) {
    return valor * (percentual / 100);
}

function calcularValorLiquido(valor, desconto) {
    return valor - desconto;
}

function calcularRecupereIr(valor, percentual) {
    return valor * (percentual / 100);
}

function calcularValorLiquidoFinal(valorLiquido, recupereIr) {
    return valorLiquido + recupereIr;
}

fomr.addEventListener('submit', function(event) {
            event.preventDefault();

            var tr = document.createElement('tr');

            campos.forEach(function(campo) {
                        var td = document.createElement('td');