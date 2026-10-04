const formatacao_de_computador = 120;
const instalacao_de_software = 40;
const limpeza_de_computador = 80;
const manutencao = 60;
const desconto_especial = 0.1;


const form_servicos = document.getElementById('form-servicos');
const servico_select = document.getElementById('servico');
const quantidade_input = document.getElementById('quantidade');
const valor_unitario_output = document.getElementById('valor-unitario');
const resultado_output = document.getElementById('resultado-servicos');
const resultado_desconto_output = document.getElementById('resultado-desconto-servicos');

function calcularServico(servico, quantidade) {
    let valor_final = 0;

    switch(servico) {
        case '1':
            valor_final = formatacao_de_computador * quantidade;
            break;
        case '2':
            valor_final = instalacao_de_software * quantidade;
            break;
        case '3':
            valor_final = limpeza_de_computador * quantidade;
            break;
        case '4':
            valor_final = manutencao * quantidade;
            break;
        case '5':
            valor_final = (formatacao_de_computador + instalacao_de_software + limpeza_de_computador + manutencao) * desconto_especial * quantidade;
            break;
        default:
            alert("Serviço inválido!");
            return;
    }
    return valor_final;
}

function calcularDesconto(valor) {
    return valor - (valor * desconto_especial);
}

form_servicos.addEventListener('submit', function(event) {
    event.preventDefault();

    const servico = document.getElementById('servico').value;
    const quantidade = parseFloat(quantidade_input.value);



    const resultado = calcularServico(servico, quantidade);
    const valor_unitario = calcularServico(servico, 1);

    if (event.submitter && event.submitter.id === 'btn-calcular') {
        valor_unitario_output.value = `R$ ${valor_unitario.toFixed(2)}`;
        resultado_output.value = `R$ ${resultado.toFixed(2)}`;
    }

    if (event.submitter && event.submitter.id === 'btn-calcular-desconto') {
        resultado_desconto_output.value = `R$ ${calcularDesconto(resultado).toFixed(2)}`;
    }
});