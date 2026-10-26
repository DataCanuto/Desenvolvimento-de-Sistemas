const campos = [
    document.querySelector('#nome-aluno'),
    document.querySelector('#nota-aluno')
];

const form = document.querySelector('#alunos-form');

const tbody = document.querySelector('table tbody');

const btnTotal = document.querySelector('#btn-total');
const btnMedia = document.querySelector('#btn-media');
const btnMax = document.querySelector('#btn-maior');
const btnMin = document.querySelector('#btn-menor');

const totalAlunos = document.querySelector('#total-alunos');
const resultadoMedia = document.querySelector('#resultado-media');
const resultadoMaior = document.querySelector('#resultado-maior');
const resultadoMenor = document.querySelector('#resultado-menor');

const alunos = [];



function addAluno(nome, nota) {
    alunos.push({
        nome: nome,
        nota: parseFloat(nota)
    })
}

function verificarSituacao(nota) {
    return nota >= 7 ? 'Aprovado' : 'Reprovado';
}

function calcularMediaTurma(alunos) {
    let somaNotas = 0;
    alunos.forEach(function (aluno) {
        somaNotas += parseFloat(aluno.nota)
    })

    return somaNotas / alunos.length
}

function verMaiorNota(alunos) {
    let maior = alunos[0].nota;
    for (let i = 0; i < alunos.length; i++) {
        if (alunos[i].nota > maior) {
            maior = alunos[i].nota
        }
    }
    return maior;
}
function verMenorNota(alunos) {
    let menor = alunos[0].nota;
    for (let i = 0; i < alunos.length; i++) {
        if (alunos[i].nota < menor) {
            menor = alunos[i].nota;
        }
    }
    return menor;
}


function clear(campos) {
    campos.forEach(function (campo) {
        campo.value = '';
    })
    return campos[0].focus();
}

function adicionarLinhaTabela(aluno) {
    const tr = document.createElement('tr');

    const tdNome = document.createElement('td');
    tdNome.textContent = aluno.nome;
    tr.appendChild(tdNome);

    const tdNota = document.createElement('td');
    tdNota.textContent = aluno.nota;
    tr.appendChild(tdNota);

    const tdSituacao = document.createElement('td');
    tdSituacao.textContent = verificarSituacao(aluno.nota);
    tr.appendChild(tdSituacao);

    tbody.appendChild(tr);
}

form.addEventListener('submit', function (event) {
    event.preventDefault();

    const nome = campos[0].value;
    const nota = campos[1].value;

    addAluno(nome, nota);
    adicionarLinhaTabela(alunos[alunos.length - 1]);

    clear(campos);
});


btnTotal.addEventListener('click', function () {
    totalAlunos.textContent = alunos.length;
});

btnMedia.addEventListener('click', function () {
    if (alunos.length === 0) {
        resultadoMedia.textContent = 'Nenhum aluno cadastrado';
        return;
    }
    resultadoMedia.textContent = calcularMediaTurma(alunos).toFixed(2);
});

btnMax.addEventListener('click', function () {
    if (alunos.length === 0) {
        resultadoMaior.textContent = 'Nenhum aluno cadastrado';
        return;
    }
    resultadoMaior.textContent = verMaiorNota(alunos);
});

btnMin.addEventListener('click', function () {
    if (alunos.length === 0) {
        resultadoMenor.textContent = 'Nenhum aluno cadastrado';
        return;
    }
    resultadoMenor.textContent = verMenorNota(alunos);
});
