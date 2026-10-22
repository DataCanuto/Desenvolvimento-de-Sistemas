const livros = [];

const isbnTxt = document.querySelector('#isbn-txt')
const tituloTxt = document.querySelector('#titulo-txt')
const autorTxt = document.querySelector('#autor-txt')
const categoriaTxt = document.querySelector('#categoria-txt')

const verLivros = document.querySelector('#livros')
const livrosThead = document.querySelector('#livros-thead')
const livrosTbody = document.querySelector('#livros-tbody')

const form = document.querySelector('#form-cadastrar-livro')


function addLivro(isbn, titulo, autor, categoria) {
    const livro = {
        isbn: isbn, titulo: titulo, autor: autor, categoria: categoria
    };

    livros.push(livro);

    return livro;
}


/*function addThead() {

    if (livrosThead.querySelector('tr')) {
        return;
    }

    const linha = document.createElement('tr')
    linha.innerHTML = `
    <th>ISBN</th>
    <th>TITULO</th>
    <th>CATEGORIA</th>
    <th>AUTOR</th>`

    livrosThead.appendChild(linha)
}*/


function addLinha(livro) {
    const linha = document.createElement('tr')

    linha.innerHTML = `
    <td>${livro.isbn}</td>
    <td>${livro.titulo}</td>
    <td>${livro.categoria}</td>
    <td>${livro.autor}</td>`

    livrosTbody.appendChild(linha);
}


form.addEventListener('submit', function (event) {

    event.preventDefault();

    const isbn = parseInt(isbnTxt.value);
    const titulo = tituloTxt.value;
    const categoria = categoriaTxt.value;
    const autor = autorTxt.value;

    const livro = addLivro(isbn, titulo, categoria, autor);

    
    addLinha(livro)
    carregarSeletores();

    form.reset();

})


const isbnSelector = document.querySelector('#isbn-selector');
const tituloSelector = document.querySelector('#titulo-selector');
const autorSelector = document.querySelector('#autor-selector');
const categoriaSelector = document.querySelector('#categoria-selector');

function preencherSelector(selector, valores, placeholder){
    selector.innerHTML = '';

    const opcaoInicial = document.createElement('option');
    opcaoInicial.value = '';
    opcaoInicial.textContent = placeholder;
    opcaoInicial.selected = true;

    selector.appendChild(opcaoInicial);

    valores.forEach(function(valor){
        const opcao = document.createElement('option');

        opcao.value = valor;
        opcao.textContent = valor;

        selector.appendChild(opcao);
    })
}


function carregarSeletores() {
    preencherSelector(
        isbnSelector,
        [...new Set(livros.map(livro => livro.isbn))],
        'Selecione um ISBN'
    );

    preencherSelector(
        tituloSelector,
        [...new Set(livros.map(livro => livro.titulo))],
        'Selecione um título'
    );

    preencherSelector(
        autorSelector,
        [...new Set(livros.map(livro => livro.autor))],
        'Selecione um autor'
    );

    preencherSelector(
        categoriaSelector,
        [...new Set(livros.map(livro => livro.categoria))],
        'Selecione uma categoria'
    );
}
