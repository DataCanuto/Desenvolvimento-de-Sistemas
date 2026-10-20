const alunos = [];


const form_aluno = document.querySelector('#form-aluno')
const nome_aluno = document.querySelector('#nome-aluno')
const nota_aluno = document.querySelector('#nota-aluno')
const alunos_cadastrados = document.querySelector('#alunos-cadastrados tbody')

const relatorio = document.querySelector('.relatorio')



function addAluno(nome, nota, situacao) {
    alunos.push({
        nome: nome,
        nota: parseFloat(nota),
        situacao: calcularSituacao(nota)
    });
}

function calcularQuantidadeAlunos(alunos) {
    return alunos.length;
}

function clear() {
    nome_aluno.value = '';
    nota_aluno.value = '';
}

function calcularSituacao(nota) {
    return nota >= 7 ? 'Aprovado' :
        nota >= 5 ? 'Recuperação' :
        'Reprovado';
}

function calcularMedia(alunos) {
    if (alunos.length === 0) return 0;

    let soma = 0;
    for (let i = 0; i < alunos.length; i++) {
        soma += alunos[i].nota;
    }

    return soma / alunos.length
}

function calcularMaiorNota(alunos) {
    let maior = 0;
    for (let i = 0; i < alunos.length; i++) {
        if (alunos[i].nota > maior) {
            maior = alunos[i].nota;
        }
    }
    return maior;
}

function calcularMenorNota(alunos) {
    if (alunos.length === 0) return 0;

    let menor = alunos[0].nota;
    for (let i = 1; i < alunos.length; i++) {
        if (alunos[i].nota < menor) {
            menor = alunos[i].nota;
        }
    }
    return menor;
}

function calcularAprovados(alunos) {
    let aprovados = 0;
    for (let i = 0; i < alunos.length; i++) {
        if (alunos[i].situacao === 'Aprovado') {
            aprovados++;
        }
    }
    return aprovados;
}

function calcularReprovados(alunos) {
    let reprovados = 0;
    for (let i = 0; i < alunos.length; i++) {
        if (alunos[i].situacao === 'Reprovado') {
            reprovados++;
        }
    }
    return reprovados;
}

function calcularRecuperacao(alunos) {
    let recuperacao = 0;
    for (let i = 0; i < alunos.length; i++) {
        if (alunos[i].situacao === 'Recuperação') {
            recuperacao++;
        }
    }
    return recuperacao;
}

function mostrarAlunosCadastrados(alunos) {
    alunos_cadastrados.innerHTML = '';
    for (let i = 0; i < alunos.length; i++) {

        const aluno = alunos[i];
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${aluno.nome}</td>
            <td>${aluno.nota}</td>
            <td>${aluno.situacao}</td>
        `;
        alunos_cadastrados.appendChild(row);
    }
}

form_aluno.addEventListener('submit', (event) => {

    event.preventDefault();

    const nome = nome_aluno.value;

    const nota = parseFloat(nota_aluno.value);

    const situacao = calcularSituacao(nota);

    addAluno(nome, nota, situacao);

    const quantidade = alunos.length;
    const maiorNota = calcularMaiorNota(alunos)
    const menorNota = calcularMenorNota(alunos)
    const media = calcularMedia(alunos)

    const aprovados = calcularAprovados(alunos);
    const reprovados = calcularReprovados(alunos);
    const recuperacao = calcularRecuperacao(alunos);



    mostrarAlunosCadastrados(alunos);

    relatorio.innerHTML = gerarRelatorio(
        quantidade,
        media,
        maiorNota,
        menorNota,
        aprovados,
        reprovados,
        recuperacao
    );


    clear();
})


function gerarRelatorio(
    quantidade,
    media,
    maiorNota,
    menorNota,
    aprovados,
    reprovados,
    recuperacao
) {
    return `
        <p><strong>Quantidade de alunos:</strong> ${quantidade}</p>
        <p><strong>Média da turma:</strong> ${media.toFixed(2)}</p>
        <p><strong>Maior nota:</strong> ${maiorNota}</p>
        <p><strong>Menor nota:</strong> ${menorNota}</p>
        <p><strong>Aprovados:</strong> ${aprovados}</p>
        <p><strong>Recuperação:</strong> ${recuperacao}</p>
        <p><strong>Reprovados:</strong> ${reprovados}</p>
    `;
}