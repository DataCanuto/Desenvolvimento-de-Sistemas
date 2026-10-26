const form = document.getElementById('resultado-aluno-form')

const input_nota = document.getElementById('nota-aluno')

const input_aluno = document.getElementById('nome-aluno')

const output_result = document.getElementById('resultado-final')

let estado_inicial = true;

output_result.textContent = estado_inicial
    ? 'Preencha os dados para ver o resultado do aluno.'
    : '';


function verificarMedia(nota){
    return nota >= 7 ? 'Aprovado' : 'Reprovado';
}

form.addEventListener('submit', function(event){
    event.preventDefault();

    const nome = input_aluno.value;
    const nota = parseFloat(input_nota.value);

    const resultado = verificarMedia(nota);
    
    estado_inicial = false;
    if (!estado_inicial) {
        output_result.textContent = `Situação de ${nome}: ${resultado}`;
    }

}); 